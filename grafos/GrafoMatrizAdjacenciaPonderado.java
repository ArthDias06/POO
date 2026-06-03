//Arthur de Castro Dias - 16855302
//GUilherme Cavalcanti de Santana - 15456556

import java.util.Collections;
import java.util.Vector;

public class GrafoMatrizAdjacenciaPonderado extends Grafo implements Grafo.MetodosGrafo {
    Vector<Vector<Integer>> matriz = new Vector<>();

    public void adicionarVertice(String vertice) {
        if (existeVertice(vertice)) {
            return;
        }
        this.vertices.add(vertice);
        Collections.sort(this.vertices);
        int i = this.vertices.indexOf(vertice);

        for (int j = 0; j < this.matriz.size(); j++) {
            this.matriz.get(j).add(i, -1);
        }

        Vector<Integer> nl = new Vector<>();
        for (int j = 0; j < this.vertices.size(); j++) {
            nl.add(-1);
        }
        this.matriz.add(i, nl);
    }

    public void removerVertice(String vertice) {
        int i = this.vertices.indexOf(vertice);
        if (i == -1) {
            return;
        }

        this.vertices.remove(i);
        this.matriz.remove(i);

        for (int j = 0; j < this.matriz.size(); j++) {
            this.matriz.get(j).remove(i);
        }
    }

    public void adicionarAresta(String origem, String destino, int peso) {
        if (!existeVertice(origem) || !existeVertice(destino) || existeAresta(origem, destino)) {
            return;
        }

        int i = this.vertices.indexOf(origem);
        int j = this.vertices.indexOf(destino);

        this.matriz.get(i).set(j, peso);
        this.matriz.get(j).set(i, peso);
        this.numArestas++;
    }

    public void adicionarAresta(String origem, String destino) {}

    public void removerAresta(String origem, String destino) {
        if (!existeVertice(origem) || !existeVertice(destino) || !existeAresta(origem, destino)) {
            return;
        }

        int i = this.vertices.indexOf(origem);
        int j = this.vertices.indexOf(destino);

        this.matriz.get(i).set(j, -1);
        this.matriz.get(j).set(i, -1);
        this.numArestas--;
    }

    public boolean existeVertice(String vertice) {
        return this.vertices.contains(vertice);
    }

    public boolean existeAresta(String origem, String destino) {
        if (!existeVertice(origem) || !existeVertice(destino)) {
            return false;
        }

        int i = this.vertices.indexOf(origem);
        int j = this.vertices.indexOf(destino);

        return this.matriz.get(i).get(j) != -1;
    }

    public int grau(String vertice) {
        int i = this.vertices.indexOf(vertice);
        if (i == -1) {
            return -1;
        }

        int grau = 0;
        for (int j = 0; j < this.vertices.size(); j++) {
            if (this.matriz.get(i).get(j) != -1) {
                grau++;
            }
        }
        return grau;
    }

    public int ordem() {
        return this.vertices.size();
    }

    public int tamanho() {
        return this.numArestas;
    }

    @Override
    public String toString() {
        String s = "Ponderado - Matriz de Adjacencia\ngraph {\n";

        for (int i = 0; i < this.vertices.size(); i++) {
            if (grau(this.vertices.get(i)) == 0) {
                s += "    \"" + this.vertices.get(i) + "\";\n";
            }
        }

        for (int i = 0; i < this.vertices.size(); i++) {
            String origem = this.vertices.get(i);
            for (int j = i + 1; j < this.vertices.size(); j++) {
                int peso = this.matriz.get(i).get(j);
                if (peso != -1) {
                    String destino = this.vertices.get(j);
                    s += "    \"" + origem + "\" -- \"" + destino + "\" [label=\"" + peso + "\"];\n";
                }
            }
        }

        s += "}";
        return s;
    }
}
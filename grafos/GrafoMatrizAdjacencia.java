//Arthur de Castro Dias - 16855302
//GUilherme Cavalcanti de Santana - 15456556

import java.util.Collections;
import java.util.Vector;

public class GrafoMatrizAdjacencia extends Grafo implements Grafo.MetodosGrafo {
    Vector<Vector<Boolean>> matriz = new Vector<>();

    public void adicionarVertice(String vertice) {
        if (existeVertice(vertice)) {
            return;
        }

        this.vertices.add(vertice);
        Collections.sort(this.vertices);
        int i = this.vertices.indexOf(vertice);

        for (int j = 0; j < this.matriz.size(); j++) {
            this.matriz.get(j).add(i, false);
        }

        Vector<Boolean> l = new Vector<>();
        for (int j = 0; j < this.vertices.size(); j++) {
            l.add(false);
        }
        this.matriz.add(i, l);
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

    public void adicionarAresta(String origem, String destino) {
        if (!existeVertice(origem) || !existeVertice(destino) || existeAresta(origem, destino)) {
            return;
        }

        int i = this.vertices.indexOf(origem);
        int j = this.vertices.indexOf(destino);

        this.matriz.get(i).set(j, true);
        this.matriz.get(j).set(i, true);
        this.numArestas++;
    }

    public void removerAresta(String origem, String destino) {
        if (!existeVertice(origem) || !existeVertice(destino) || !existeAresta(origem, destino)) {
            return;
        }

        int i = this.vertices.indexOf(origem);
        int j = this.vertices.indexOf(destino);

        this.matriz.get(i).set(j, false);
        this.matriz.get(j).set(i, false);
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

        return this.matriz.get(i).get(j);
    }

    public int grau(String vertice) {
        int i = this.vertices.indexOf(vertice);
        if (i == -1) {
            return -1;
        }

        int grau = 0;
        for (int j = 0; j < this.vertices.size(); j++) {
            if (this.matriz.get(i).get(j)) {
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
        String s = "Matriz de Adjacencia\ngraph {\n";

        for (int i = 0; i < this.vertices.size(); i++) {
            if (grau(this.vertices.get(i)) == 0) {
                s += "    \"" + this.vertices.get(i) + "\";\n";
            }
        }

        for (int i = 0; i < this.vertices.size(); i++) {
            String origem = this.vertices.get(i);
            for (int j = i + 1; j < this.vertices.size(); j++) {
                if (this.matriz.get(i).get(j)) {
                    String destino = this.vertices.get(j);
                    s += "    \"" + origem + "\" -- \"" + destino + "\";\n";
                }
            }
        }

        s += "}";
        return s;
    }
}
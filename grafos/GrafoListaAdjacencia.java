//Arthur de Castro Dias - 16855302
//GUilherme Cavalcanti de Santana - 15456556

package grafos;
import java.util.Collections;
import java.util.Vector;

public class GrafoListaAdjacencia extends Grafo implements Grafo.MetodosGrafo{
    Vector<Vector<String>> lista = new Vector<>();

    public void adicionarVertice(String vertice) {
        if (existeVertice(vertice)) {
            return;
        }

        this.vertices.add(vertice);
        Collections.sort(this.vertices);
        Vector<String> a = new Vector<>();
        int i = this.vertices.indexOf(vertice);
        this.lista.add(i, a);
    }

    public void removerVertice(String vertice){
        int i = this.vertices.indexOf(vertice);
        if(i == -1){
            return;
        }

        for(int j = 0; j < this.lista.size(); j++){
            if(this.lista.get(j).contains(vertice)){
                this.lista.get(j).remove(vertice);
                this.numArestas--;
            }
        }
        this.vertices.remove(i);
        this.lista.remove(i);
    }

    public void adicionarAresta(String origem, String destino){
        if(!existeVertice(destino) || !existeVertice(origem) || existeAresta(origem, destino)){
            return;
        }
        this.numArestas++;
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).equals(origem)){
                this.lista.get(i).add(destino);
                Collections.sort(this.lista.get(i));
            }
            else if(this.vertices.get(i).equals(destino)){
                this.lista.get(i).add(origem);
                Collections.sort(this.lista.get(i));
            }
        }
    }

    public void removerAresta(String origem, String destino){
        if(!existeVertice(destino) || !existeVertice(origem)){
            return;
        }
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).equals(origem)){
                this.lista.get(i).remove(destino);
                this.numArestas--;
            }
            else if(this.vertices.get(i).equals(destino)){
                this.lista.get(i).remove(origem);
            }
        }
    }

    public boolean existeVertice(String vertice){
        return this.vertices.contains(vertice);
    }

    public boolean existeAresta(String origem, String destino){
        if(!existeVertice(destino) || !existeVertice(origem)){
            return false;
        }

        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).equals(origem)){
                if(this.lista.get(i).contains(destino)){
                    return true;
                }
            }
            else if(this.vertices.get(i).equals(destino)){
                if(this.lista.get(i).contains(origem)){
                    return true;
                }
            }
        }
        return false;
    }

    public int grau(String vertice){
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).equals(vertice)){
                return this.lista.get(i).size();
            }
        }
        return -1;
    }

    public int ordem(){
        return this.vertices.size();
    }

    public int tamanho(){
        return this.numArestas;
    }

    @Override
    public String toString() {
        String s = "Lista de Adjacencia\ngraph {\n";
        
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.lista.get(i).size() == 0) {
                s += "    \"" + this.vertices.get(i) + "\";\n";
            }
        }

        for (int i = 0; i < this.vertices.size(); i++) {
            String origem = this.vertices.get(i);
            for (int j = i + 1; j < this.vertices.size(); j++) {
                if (this.lista.get(i).contains(this.vertices.get(j))) {
                    String destino = this.vertices.get(j);
                    s += "    \"" + origem + "\" -- \"" + destino + "\";\n";
                }
            }
        }
        s += "}";
        return s;
    }
}

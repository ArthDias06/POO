//Arthur de Castro Dias - 16855302
//GUilherme Cavalcanti de Santana - 15456556

package grafos;
import java.util.Vector;

public abstract class Grafo {
    Vector<String> vertices = new Vector<>();
    int numArestas = 0;

    public interface MetodosGrafo{
        public void adicionarVertice(String vertice);
        public void removerVertice(String vertice);
        public void adicionarAresta(String origem, String destino);
        public void removerAresta(String origem, String destino);
        public boolean existeVertice(String vertice);
        public boolean existeAresta(String origem, String destino);
        public int grau(String vertice);
        public int ordem();
        public int tamanho();
        public String toString();
    }
}

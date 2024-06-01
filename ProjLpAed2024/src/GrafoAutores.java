import edu.princeton.cs.algs4.Graph;

public class GrafoAutores {
    private Graph grafo;

    public GrafoAutores(int numVertices) {
        grafo = new Graph(numVertices);
    }

    // Método para adicionar um autor ao grafo
    public void adicionarAutor(int idAutor) {
        grafo.addEdge(idAutor, idAutor); // Adiciona uma aresta de um autor para ele mesmo
    }

    // Método para adicionar uma colaboração entre dois autores
    public void adicionarColaboracao(int idAutor1, int idAutor2) {
        grafo.addEdge(idAutor1, idAutor2);
    }
    
}

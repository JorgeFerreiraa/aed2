import edu.princeton.cs.algs4.*;

import java.util.*;

public class GrafoArtigos {
   private Map<Integer, Artigo> idDoArtigo;
   private Digraph digraph;


   public GrafoArtigos(){
       idDoArtigo = new HashMap<>();
       digraph = new Digraph(0);
   }

   public void addVertex(Artigo artigo) {
        if (!idDoArtigo.containsKey(artigo.getId())) {
            int index = digraph.V();
            idDoArtigo.put(artigo.getId(), artigo);
            digraph = new Digraph(index + 1); // Incrementa o número de vértices
        }
    }

    public void addEdge(int fromId, int toId) {
        Artigo fromArtigo = idDoArtigo.get(fromId);
        Artigo toArtigo = idDoArtigo.get(toId);

        if (fromArtigo != null && toArtigo != null) {
            digraph.addEdge(fromId,toId);
        }else{
            System.out.println("Erro: 1 dos artigos não existe no grafo!");
        }
    }

    /**
     * Retorna uma coleção dos id dos artigos presentes no grafo
     * @return idDoArtigo.values()
     */
    public Collection<Artigo> getArtigos() {
        return idDoArtigo.values();
    }



    public Digraph getDigraph() {
        return digraph;
    }

    public Artigo getArtigo(int artigoId) {
        return idDoArtigo.get(artigoId);
    }
    /**
     * Metodo para calcular citações de primeira ordem
     * @param artigoId
     * @return
     */
    public int calcularCitacoesPrimeiraOrdem(int artigoId){
       int count = 0;
       for (int v = 0; v < digraph.V(); v++){
           for (int w = 0; w < digraph.V(); w++){
               if (w == artigoId){
                   count++;
               }
           }
       }
       return count;
    }

    /**
     * Calcula o número de citações de segunda ordem para um artigo especificado pelo seu ID.
     * As citações de segunda ordem são definidas como citações indiretas, ou seja,
     * artigos que citam o artigo especificado diretamente e, em seguida, os artigos que citam
     * esses artigos diretamente.
     *
     * @param artigoId o ID do artigo para o qual as citações de segunda ordem serão calculadas
     * @return o número de citações de segunda ordem do artigo especificado
     */
    public int calcularCitacoesSegundaOrdem(int artigoId){
        int count = 0;
        List<Integer> primeiraOrdem = new ArrayList<>();
        for (int v = 0; v < digraph.V(); v++){
            for (int w = 0; w < digraph.V(); w++){
                if (w == artigoId){
                    primeiraOrdem.add(v);
                }
            }
        }

        for (int citado : primeiraOrdem){
            count += calcularCitacoesSegundaOrdem(citado);
        }
        return count;
    }

    /**
     * Função que returna true no caso de encontrar um artigo com o respetivo id e false caso contrário
     * @param artigoId
     * @return
     */
    public boolean existeArtigo(int artigoId){
        return idDoArtigo.containsKey(artigoId);
    }

    /**
     * Função que returna o numero de vertices do digraph
     * @return
     */
    public int numeroVertices(){
        return digraph.V();
    }

    public Iterable<Integer> getAdjacentVertices(int vertice){
        return digraph.adj(vertice);
    }


    /**
     * Algoritmo do dfs
     * @param v
     * @param visitado
     */
    private void dfs(int v, boolean[] visitado) {
        visitado[v] = true;

        for (int w : digraph.adj(v)) {
            if (!visitado[w]) {
                dfs(w, visitado);
            }
        }
    }

    /**
     * Função que verifica se os grafos são conexos ou nao
     * @return boolean
     */
    public boolean isConnected() {
        boolean[] visitado = new boolean[digraph.V()];
        int v = 0; // Vértice inicial arbitrário

        dfs(v, visitado);


        for (int i = 0; i < digraph.V(); i++) {
            if (!visitado[i]) {
                return false;
            }
        }

        return true;
    }

}

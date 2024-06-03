import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;

public class GrafoAutores {
    private Graph grafo;
    private ST<Integer, String> atributosColaboracao;
    private ArrayList<Autor> autores;

    public GrafoAutores(int numAutores) {
        grafo = new Graph(numAutores);
        atributosColaboracao = new ST<>();
        autores = new ArrayList<>();
    }

    /**
     * Método para adicionar 1 autor ao grafo
     * @param autor
     */
    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    /**
     * Metodo para adicionar uma colaboração entre dois autores com atributos
     * @param idAutor1
     * @param idAutor2
     * @param atributo
     */
    public void adicionarColaboracao(int idAutor1, int idAutor2, String atributo) {
        grafo.addEdge(idAutor1, idAutor2);
        atributosColaboracao.put(grafo.E() - 1, atributo);
    }


    /**
     * Metodo para listar autores por instuições
      * @param instituicao
     * @return
     */
    public ArrayList<Autor> listarAutoresPorInstituicao(String instituicao) {
        ArrayList<Autor> autoresPorInstituicao = new ArrayList<>();

        for (Autor autor : autores) {
            if (autor.getCienciaID().equals(instituicao) || autor.getGoogleScholarID().equals(instituicao) || autor.getORCID().equals(instituicao)) {
                autoresPorInstituicao.add(autor);
            }
        }

        return autoresPorInstituicao;
    }


    /**
     * Metodo para calcular com quantos autores um dado autor trabalhou
     * @param autor
     * @return grafo.degree(idAutor)
     */
    public int calcularColaboracoesDeAutor(Autor autor) {
        int idAutor = autores.indexOf(autor);
        return grafo.degree(idAutor);
    }

    /**

     Calcula o número de artigos escritos em colaboração entre dois autores.*
     @param autor1 O primeiro autor.
     @param autor2 O segundo autor.
     @return O número de artigos escritos em colaboração entre os dois autores.
     */
    public int calcularNumeroArtigosEntreAutores(Autor autor1, Autor autor2) {// Encontra os índices dos autores no ArrayList de autores
        int idAutor1 = autores.indexOf(autor1);
        int idAutor2 = autores.indexOf(autor2);
        int numArtigos = 0;

        // Percorre todas as arestas do grafo
        for (int v = 0; v < grafo.V(); v++) {
            for (int w : grafo.adj(v)) {
                // Verifica se os dois autores são extremidades da aresta
                if ((v == idAutor1 && w == idAutor2) || (v == idAutor2 && w == idAutor1)) {
                    numArtigos++;
                }
            }
        }

        return numArtigos;
    }


    /**
     * Calcular o caminho mais curto entre autores
     * @param autorOrigem
     * @param autorDestino
     * @return
     */
    public int calcularCaminhoMaisCurto(Autor autorOrigem, Autor autorDestino) {
        int idOrigem = autores.indexOf(autorOrigem);
        int idDestino = autores.indexOf(autorDestino);


        boolean[] visitado = new boolean[grafo.V()];

        int[] saltos = new int[grafo.V()];


        for (int i = 0; i < grafo.V(); i++) {
            visitado[i] = false;
            saltos[i] = Integer.MAX_VALUE;
        }


        Queue<Integer> fila = new Queue<>();

        fila.enqueue(idOrigem);
        visitado[idOrigem] = true;
        saltos[idOrigem] = 0;


        while (!fila.isEmpty()) {
            int v = fila.dequeue();

            for (int w : grafo.adj(v)) {
                if (!visitado[w]) {
                    fila.enqueue(w);
                    visitado[w] = true;
                    saltos[w] = saltos[v] + 1;
                }
            }
        }


        return saltos[idDestino];
    }

    /**
     * Metodo para selecionar um subgrafo contento apenas os autores de um conjunto de instituiçoes
     * @param instituicao
     * @return subgrafo de autores
     */

    public GrafoAutores selecionarSubgrafoPorInstituicoes(ArrayList<String> instituicao) {
        GrafoAutores subgrafo = new GrafoAutores(autores.size());

        for (Autor autor : autores) {
            if (instituicao.contains(autor.getCienciaID()) || instituicao.contains(autor.getGoogleScholarID()) || instituicao.contains(autor.getORCID())) {
                subgrafo.adicionarAutor(autor);
            }
        }
        return subgrafo;
    }

    /**
     * Metodo para verificar se o grafo é conexo
     * @return boolean
     */
    public boolean verificarConexo() {
        boolean[] visitado = new boolean[grafo.V()];

        dfs(0, visitado);


        for (int i = 0; i < grafo.V(); i++) {
            if (!visitado[i]) {
                return false;
            }
        }
        return true;
    }


    private void dfs(int v, boolean[] visitado) {
        visitado[v] = true;
        for (int w : grafo.adj(v)) {
            if (!visitado[w]) {
                dfs(w, visitado);
            }
        }
    }


    /**
     * Metodo para encontrar autores que citaram uma lista de artigos em um dado periodo
     * @param artigos
     * @param dataInicial
     * @param dataFinal
     * @return autorescitadores
     */

    public ArrayList<Autor> encontrarAutoresQueCitaramArtigos(ArrayList<Artigo> artigos, Date dataInicial, Date dataFinal) {
        ArrayList<Autor> autoresCitadores = new ArrayList<>();

        for (Autor autor : autores) {
            for (Artigo artigo : autor.getHistoricoArtigos()) {
                if (artigos.contains(artigo) && artigo.getData().after(dataInicial) && artigo.getData().before(dataFinal)) {
                    autoresCitadores.add(autor);
                    break;
                }
            }
        }
        return autoresCitadores;
    }

    /**
     * Citacoes journal num determinado periodo
     * @param dataInicial
     * @param dataFinal
     * @return artigos ArrayList de artigos em journal num determinado periodo
     */
    public ArrayList<Artigo> citacoesJournalPeriodo( Date dataInicial, Date dataFinal) {
        ArrayList<Artigo> artigos = new ArrayList<>();
        for (Autor autor : autores) {
            for (Artigo artigo : autor.getHistoricoArtigos()) {
                if (artigo.getTipoPublicacao().equals("Journal") && artigo.getData().after(dataInicial) && artigo.getData().before(dataFinal)) {
                    artigos.add(artigo);
                    break;
                }
            }
        }
        return artigos;
    }

}
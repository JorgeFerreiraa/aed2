import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import edu.princeton.cs.algs4.*;

public class BaseDeDados {
    // Coleções de dados
    private GrafoArtigos grafo;
    private Map<String, Artigo> artigos;
    private Map<String, Autor> autores;
    private Map<String, Publicacao> publicacoes;
    private Set<String> autoresRemovidos;



    public BaseDeDados() {
        this.grafo = new GrafoArtigos();
        this.artigos = new HashMap<>();
        this.autores = new HashMap<>();
        this.publicacoes = new HashMap<>();
        this.autoresRemovidos = new HashSet<>();
    }

    /**
     * Inserir um artigo
     * @param artigo
     */
    public void inserirArtigo(Artigo artigo) {
        artigos.put(artigo.getTitulo(), artigo);
    }

    /**
     * Remoção do artigo pelo titulo
     * @param id
     */
    public void removerArtigo(int id) {
        artigos.remove(id);
    }

    /**
     * Pesquisa do artigo pelo titulo
     * @param titulo
     * @return artigos.get(titulo)
     */
    public Artigo pesquisarArtigo(String titulo) {
        return artigos.get(titulo);
    }


    /***
     * Inserir um novo autor
     * @param autor
     */
    public void inserirAutor(Autor autor) {
        autores.put(autor.getNome(), autor);
    }

    /**
     * Remoção do autor
     * @param id
     */
    public void removerAutor(int id) {
        autores.remove(id);

        }


    /**
     * Pequisar autor pelo nome
     * @param nome
     * @return autores.get(nome)
     */
    public Autor pesquisarAutor(String nome) {
        return autores.get(nome);
    }


    /**
     * Validação da consistencia das referencias para autores
     * @return boolean
     */
    public boolean validarReferenciasAutores() {
        for (Artigo artigo : artigos.values()) {
            for (Autor autor : artigo.getAutores()) {
                if (!autores.containsKey(autor.getNome()) && !autoresRemovidos.contains(autor.getNome())) {
                    System.out.println("Referência inválida para o autor: " + autor.getNome());
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Insere uma publicação nova
     * @param publicacao
     */
    public void inserirPublicacao(Publicacao publicacao) {
        publicacoes.put(publicacao.getNome(), publicacao);
    }

    /**
     * Remove a publicação pelo nome da mesma
     * @param nome
     */
    public void removerPublicacao(String nome) {
        publicacoes.remove(nome);
    }

    /**
     * Pesquisar a publicação pelo nome
     * @param nome
     * @return
     */
    public Publicacao pesquisarPublicacao(String nome) {
        return publicacoes.get(nome);
    }


    /**
     * Função que encontra os artigos de um determinado autor num periodo de tempo
     * @param nomeAutor
     * @param anoInicio
     * @param anoFim
     * @return artigosPorAutor
     */
    public ArrayList<Artigo> encontrarArtigosPorAutorNoPeriodo(String nomeAutor, int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosPorAutor = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            for (Autor autor : artigo.getAutores()) {
                if (autor.getNome().equals(nomeAutor) && artigo.data.getYear() >= anoInicio && artigo.data.getYear() <= anoFim) {
                    artigosPorAutor.add(artigo);
                    break; // Se encontrar o autor, não é necessário continuar procurar nos autores do artigo
                }
            }
        }
        return artigosPorAutor;
    }

    /**
     * Função para encontrar artigos nao descarregados ou visualizados num periodo
      * @param anoInicio
     * @param anoFim
     * @return artigosNaoDescarregadosVisualizados
     */
    public ArrayList<Artigo> encontrarArtigosNaoDescarregadosVisualizadosPeriodo(int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosNaoDescarregadosVisualizados = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            if (artigo.data.getYear() >= anoInicio && artigo.data.getYear() <= anoFim && artigo.getNumDownloads() == 0 && artigo.getNumVisualizacoes() == 0) {

                artigosNaoDescarregadosVisualizados.add(artigo);
            }
        }
        return artigosNaoDescarregadosVisualizados;
    }

    /**
     * Função que returna o top3artigos mais usados no determinado tempo
     * @param anoInicio
     * @param anoFim
     * @return top3Artigos
     */

    public ArrayList<Artigo> topArtigosMaisUsadosNumTempo(int anoInicio, int anoFim) {
        ArrayList<Artigo> artigosMaisUsados = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            if (artigo.data.getYear() >= anoInicio && artigo.data.getYear() <= anoFim && artigo.getNumDownloads() > 0 && artigo.getNumVisualizacoes() > 0) {
                artigosMaisUsados.add(artigo);
            }
        }
        quickSort(artigosMaisUsados,0,artigosMaisUsados.size() - 1);

        ArrayList<Artigo> top3Artigos = new ArrayList<>();

        int i = 0;
        while(i<3){
            top3Artigos.add(artigosMaisUsados.get(i));
            i++;
        }

        return top3Artigos;
    }

    /**
     * QuickSort
     * @param list
     * @param low
     * @param high
     */
    private void quickSort(ArrayList<Artigo> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(ArrayList<Artigo> list, int low, int high) {
        Artigo pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getNumDownloads() > pivot.getNumDownloads()) {
                i++;
                Artigo temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Artigo temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    /**
     * Função para gerar um relatorio Global
     */
    public void gerarRelatorioGlobal() {
        System.out.println("### Relatório Global do Sistema ###");
        System.out.println("\nLista de Artigos:");
        for (Artigo artigo : artigos.values()) {
            System.out.println(artigo);
        }
        System.out.println("\nLista de Autores:");
        for (Autor autor : autores.values()) {
            System.out.println(autor);
        }
        System.out.println("\nLista de Ligações entre Artigos:");
        for (Artigo artigo : artigos.values()) {
            System.out.println("Artigo: " + artigo.getTitulo());
            System.out.println("Referências:");
            for (Artigo referencia : artigo.getReferencias()) {
                System.out.println("- " + referencia.getTitulo());
            }
            System.out.println();
        }
    }

    /**
     * Função para escrever um artigo num ficheiro txt
     */
    void escreverArtigo() {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File("data", "artigolista.txt"));
            for (Artigo artigo : artigos.values()) {
                String art = artigo.getTitulo() + "," + artigo.getPalavrasChave() + "," + artigo.getTipoPublicacao() + "," + artigo.getData() + "," + artigo.getNumDownloads() + "," + artigo.getNumVisualizacoes() + "," + artigo.getNumLikes() + "," + artigo.getNumLikes() + "," + artigo.getAutores() + "," + artigo.getReferencias() + "," + artigo.getConferencia() + "," + artigo.getJournal();
                pw.println(art);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Error a) {
                throw new RuntimeException();
            }
        }
    }

    /**
     * Função para ler um artigo de um ficheiro txt
     */
    void lerArtigo() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("data/artigo.txt")))){
            String line = "";
            int lineCount = 1;
            while ((line = br.readLine()) != null){
                System.out.println("Line" + lineCount + ": " + line);
                String nome = "";
                String local = "";
                StringTokenizer st = new StringTokenizer(line, ",");
                int tokenCount = 0;
                while (st.hasMoreTokens()){
                    String token = st.nextToken();
                    switch (tokenCount){
                        case 0:
                            nome = token;
                            break;
                        case 1:
                            local = token;
                            break;
                    }
                    tokenCount++;
                }
                System.out.println("Line separated fields " + lineCount + ": " + nome + " " + local);
                lineCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Função para escrever um artigo num ficheiro .bin
     */
    public void escreverBinarioArtigo(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/utilizadoresListar.bin"))) {
            int i =  0;
            for (Artigo artigo : artigos.values()) {
                String titulo = artigo.getTitulo();
                String tipoPubli = artigo.getTipoPublicacao();
                Date data = artigo.getData();
                int downloads = artigo.getNumDownloads();
                int views = artigo.getNumVisualizacoes();
                int likes = artigo.getNumLikes();
                oos.writeObject(titulo);
                oos.writeObject(data);
                oos.writeObject(downloads);
                oos.writeObject(views);
                oos.writeObject(likes);
                i++;
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Função para ler um artigo de um ficheiro .bin
     */
    public void lerBinarioArtigo(){
        File file = new File("data/utilizadoresListar.bin");

        if (!file.exists()){
            System.out.println("Ficheiro não existe");
            return;
        }
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int byteData;
            while ((byteData = bis.read()) != -1) {
                System.out.printf("%02x ", byteData);  // Imprime o byte em formato hexadecimal
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metódo para listar artigos por Journal ou Conferencia num determinado periodo
     * @param tipoPublicacao
     * @param dataInicio
     * @param dataFim
     * @return
     */
    public List<Artigo> listarArtigosPorJournalConferenciaEPeriodo(String tipoPublicacao, Date dataInicio, Date dataFim) {
        List<Artigo> r = new ArrayList<>();
        for (Artigo artigo : grafo.getArtigos()) {
            if ( (artigo.getTipoPublicacao().equals(tipoPublicacao)) && (dataInicioDataFim(artigo.getData(),dataInicio,dataFim))){
                r.add(artigo);
            }
        }
        return r;
    }

    /**
     * Método para verificar se um artigo está dentro de um determinado período de tempo
     * @param dataArtigo
     * @param dataInicio
     * @param dataFim
     * @return !dataArtigo.before(dataInicio) && !dataArtigo.after(dataFim);
     */
    private boolean dataInicioDataFim(Date dataArtigo, Date dataInicio, Date dataFim) {
        return !dataArtigo.before(dataInicio) && !dataArtigo.after(dataFim);
    }

    /**
     * Função que calcula o número de citações a outros artigos dos mesmos autores
     * @param artigorecebido
     * @return
     */
    public int calcularAutoCitacao(Artigo artigorecebido){
        int cont = 0;

        ArrayList<Autor> autoresArtigo = grafo.getArtigo(artigorecebido.getId()).getAutores();

        for (int v = 0; v < grafo.numeroVertices(); v++) {
            if (v != artigorecebido.getId()){
                ArrayList<Autor> autoresArtigoComparar = grafo.getArtigo(v).getAutores();;
                if (contemAutores(autoresArtigo,autoresArtigoComparar)){
                    for (int w : grafo.getAdjacentVertices(v)){
                        cont++;
                        break;
                    }
                }
            }
        }
        return cont;
    }


    /**
     * Função auxilar para comparar arraylist de autores e encontrar 1 autor em comum
     * @param autorArtigo
     * @param compararAutor
     * @return
     */
    private boolean contemAutores(ArrayList<Autor> autorArtigo, ArrayList<Autor> compararAutor){
        boolean contem = false;
        for (Autor autor : autorArtigo){
            if(compararAutor.contains(autor)){
                contem = true;
                break;
            }
        }
        return contem;
    }

    /**
     * Função que cria um subGrafo apenas de grafos de um tipo de publicação especifico
     * @param tipoPubli
     * @return
     */
    public GrafoArtigos subGrafoPorJournalConferencia(String tipoPubli){
        GrafoArtigos subGrafo = new GrafoArtigos();

        for(Artigo artigo : grafo.getArtigos()){
            if (artigo.getTipoPublicacao().equals(tipoPubli))
                subGrafo.addVertex(artigo);
        }
        return subGrafo;
    }
}



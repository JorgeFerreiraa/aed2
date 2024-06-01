import java.util.ArrayList;
import java.util.Date;

/**
 *Classe que representa o Artigo
 */

public class Artigo {
    private int id;
    private String titulo;
    private ArrayList<String> palavrasChave;
    private String tipoPublicacao;
    public Date data;
    private int numDownloads;
    private int numVisualizacoes;
    private int numLikes;
    private ArrayList<Autor> autores;
    private ArrayList<Artigo> referencias;
    private Conferencia conferencia;
    private Journal journal;

    /**
     * Construtor para criar um novo objeto artigo
     * @param id Id do artigo
     * @param titulo Titulo do artigo
     * @param palavrasChave palavras chaves do artigo
     * @param tipoPublicacao Tipo de publicação do artigo
     * @param data Data de publicacao do artigo
     * @param numDownloads Numero de Downloads do artigo
     * @param numVisualizacoes Numero de views do artigo
     * @param numLikes Numero de likes
     * @param autores Array list de autores do artigo
     * @param referencias Array list de referencias do artigo
     * @param conferencia Conferencia do artigo
     * @param journal Journal do artigo
     */
    public Artigo(int id, String titulo, ArrayList<String> palavrasChave, String tipoPublicacao, Date data, int numDownloads, int numVisualizacoes, int numLikes, ArrayList<Autor> autores, ArrayList<Artigo> referencias, Conferencia conferencia, Journal journal) {
        this.id = id;
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.tipoPublicacao = tipoPublicacao;
        this.data = data;
        this.numDownloads = numDownloads;
        this.numVisualizacoes = numVisualizacoes;
        this.numLikes = numLikes;
        this.autores = autores;
        this.referencias = referencias;
        this.conferencia = conferencia;
        this.journal = journal;
    }

    /**
     * Obtém o arraylist dos autores do artigo
     * @return autores
     */
    public ArrayList<Autor> getAutores() {
        return autores;
    }
    /**
     * Obtém o id do artigo
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o titulo do artigo
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Define o titulo do artigo
     * @param titulo O novo titulo do artigo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtém o arraylist de Palavras chaves do artigo
     * @return autores
     */
    public ArrayList<String> getPalavrasChave() {
        return palavrasChave;
    }
    /**
     * Define as palavras chaves do artigo
     * @param palavrasChave Novas palavras chave do artigo
     */
    public void setPalavrasChave(ArrayList<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    /**
     * Obtém o tipo de publicacao do artigo
     * @return tipoPublicacao
     */
    public String getTipoPublicacao() {
        return tipoPublicacao;
    }
    /**
     * Define o tipo de publicacao do artigo
     * @param tipoPublicacao
     */
    public void setTipoPublicacao(String tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }
    /**
     * Obtém a data do artigo
     * @return data
     */
    public Date getData() {
        return data;
    }
    /**
     * Define a data do artigo
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }
    /**
     * Obtém o numero de downloads do artigo
     * @return numDownloads
     */
    public int getNumDownloads() {
        return numDownloads;
    }
    /**
     * Define o numero de downloads do artigo
     * @param numDownloads
     */
    public void setNumDownloads(int numDownloads) {
        this.numDownloads = numDownloads;
    }
    /**
     * Obtém o numero de views do artigo
     * @return numVisualizacoes
     */
    public int getNumVisualizacoes() {
        return numVisualizacoes;
    }
    /**
     * Define o numero de views do artigo
     * @param numVisualizacoes
     */
    public void setNumVisualizacoes(int numVisualizacoes) {
        this.numVisualizacoes = numVisualizacoes;
    }
    /**
     * Obtém o numero de likes do artigo
     * @return numLikes
     */
    public int getNumLikes() {
        return numLikes;
    }
    /**
     * Define o numero de likes do artigo
     * @param numLikes
     */
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
    /**
     * Define o os autores do artigo
     * @param autores
     */
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    /**
     * Obtém as referencias do artigo
     * @return referencias
     */
    public ArrayList<Artigo> getReferencias() {
        return referencias;
    }
    /**
     * Define as referencias do artigo
     * @param referencias
     */
    public void setReferencias(ArrayList<Artigo> referencias) {
        this.referencias = referencias;
    }
    /**
     * Obtém a conferencia do artigo
     * @return conferencia
     */
    public Conferencia getConferencia() {
        return conferencia;
    }
    /**
     * Define a conferencia do artigo
     * @param conferencia
     */
    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }
    /**
     * Obtém o journal do artigo
     * @return journal
     */
    public Journal getJournal() {
        return journal;
    }
    /**
     * Define o journal do artigo
     * @param journal
     */
    public void setJournal(Journal journal) {
        this.journal = journal;
    }
    /**
     * Metodo para adicionar autor
     * @param autor
     */
    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }
    /**
     * Metodo para remover autor
     * @param autor
     */
    public void removerAutor(Autor autor) {
        autores.remove(autor);
    }
    /**
     * Metodo para adicionar referencia
     * @param referencia
     */
    public void adicionarReferencia(Artigo referencia) {
        referencias.add(referencia);
    }
    /**
     * Metodo para remover referencia
     * @param referencia
     */
    public void removerReferencia(Artigo referencia) {
        referencias.remove(referencia);
    }
}

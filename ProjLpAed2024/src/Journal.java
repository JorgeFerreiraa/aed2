import java.util.Date;

public class Journal extends Publicacao {
    private String publisher;
    private String periodicidade;
    private double jcrIF;
    private double scopusIF;

    /**
     * Metodo construtor
     * @param nome
     * @param publisher
     * @param data
     * @param periodicidade
     * @param jcrIF
     * @param scopusIF
     */
    public Journal(String nome, String publisher, Date data, String periodicidade, double jcrIF, double scopusIF) {
        super(nome, data);
        this.publisher = publisher;
        this.periodicidade = periodicidade;
        this.jcrIF = jcrIF;
        this.scopusIF = scopusIF;
    }

    /**
     * Metodo que retorna o publisher
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Metodo para definir o publisher
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Metodo que returna a periodicidade
     * @return periodicidade
     */
    public String getPeriodicidade() {
        return periodicidade;
    }

    /**
     * Metodo para setar a periodicidade
     * @param periodicidade
     */
    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    /**
     * Metodo que returna o JCRIF
     * @return
     */
    public double getJcrIF() {
        return jcrIF;
    }

    /**
     * Metodo que define o JCRIF
     * @param jcrIF
     */
    public void setJcrIF(double jcrIF) {
        this.jcrIF = jcrIF;
    }

    /**
     * Metodo que retorna o ScopusIF
     * @return scopusiof
     */
    public double getScopusIF() {
        return scopusIF;
    }

    public void setScopusIF(double scopusIF) {
        this.scopusIF = scopusIF;
    }

}

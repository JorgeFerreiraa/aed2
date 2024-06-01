import java.util.Date;

public class Journal extends Publicacao {
    private String publisher;
    private String periodicidade;
    private double jcrIF;
    private double scopusIF;

    // Construtor
    public Journal(String nome, String publisher, Date data, String periodicidade, double jcrIF, double scopusIF) {
        super(nome, data);
        this.publisher = publisher;
        this.periodicidade = periodicidade;
        this.jcrIF = jcrIF;
        this.scopusIF = scopusIF;
    }

    // Getters e Setters
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public double getJcrIF() {
        return jcrIF;
    }

    public void setJcrIF(double jcrIF) {
        this.jcrIF = jcrIF;
    }

    public double getScopusIF() {
        return scopusIF;
    }

    public void setScopusIF(double scopusIF) {
        this.scopusIF = scopusIF;
    }

    // Outros métodos conforme necessário
}

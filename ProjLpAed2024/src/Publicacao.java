import java.util.Date;

public abstract class Publicacao {
    private String nome;
    private Date data;


    public Publicacao(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }

    /**
     * Metodo para returnar o nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para definir o nome
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo para returnar a data
     * @return
     */
    public Date getDate() {
        return data;
    }

    /**
     * Metodo para setar a data
     * @param data
     */
    public void setDate(Date data) {
        this.data = data;
    }


}

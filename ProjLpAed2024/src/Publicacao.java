import java.util.Date;

public abstract class Publicacao {
    private String nome;
    private Date data;

    // Construtor
    public Publicacao(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    // Outros métodos conforme necessário
}

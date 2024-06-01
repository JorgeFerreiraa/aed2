import java.util.Date;

public class Conferencia extends Publicacao {
    private int numeroEdicao;
    private String local;

    // Construtor
    public Conferencia(String nome, Date data, int numeroEdicao, String local) {
        super(nome, data);
        this.numeroEdicao = numeroEdicao;
        this.local = local;
    }

    // Getters e Setters
    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    // Outros métodos conforme necessário
}

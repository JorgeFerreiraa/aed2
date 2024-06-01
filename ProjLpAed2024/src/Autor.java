import java.util.ArrayList;
import java.util.List;
/**
 *Classe que representa o Autor
 */
public class Autor {
    private int id;
    private String nome;
    private String nomeCurto;
    private String filiacao;
    private String ORCID;
    private String cienciaID;
    private String googleScholarID;
    private String scopusAuthorID;
    private List<String> areasInvestigacao;
    private String formacao;
    private List<Artigo> historicoArtigos;

    /**
     * Construtor para criar um objeto Autor
     * @param nome Nome do autor
     * @param nomeCurto Nome curto do autor
     * @param filiacao Filiação do autor
     * @param ORCID ORCID do autor
     * @param cienciaID Ciencia Id do autor
     * @param googleScholarID GoogleScholar Id do autor
     * @param scopusAuthorID scopusAuthorID do autor
     * @param areasInvestigacao Areas de investigação do autor
     * @param formacao Formação do autor
     */
    public Autor(String nome, String nomeCurto, String filiacao, String ORCID,
                 String cienciaID, String googleScholarID, String scopusAuthorID,
                 List<String> areasInvestigacao, String formacao) {
        this.nome = nome;
        this.nomeCurto = nomeCurto;
        this.filiacao = filiacao;
        this.ORCID = ORCID;
        this.cienciaID = cienciaID;
        this.googleScholarID = googleScholarID;
        this.scopusAuthorID = scopusAuthorID;
        this.areasInvestigacao = areasInvestigacao;
        this.formacao = formacao;
        this.historicoArtigos = new ArrayList<>();
    }

    /**
     * Obtém o nome do autor
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * Obtém o id do autor
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Define o nome do autor
     * @param nome O novo nome do autor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Obtém a filiação do autor
     * @return filiacao
     */
    public String getFiliacao() {
        return filiacao;
    }
    /**
     * Define a filiacao do autor
     * @param filiacao a nova filiacao do autor
     */
    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }
    /**
     * Obtém o ORCID do autor
     * @return orcid
     */
    public String getORCID() {
        return ORCID;
    }
    /**
     * Define o ORC id do autor
     * @param ORCID o novo ORC id do autor
     */
    public void setORCID(String ORCID) {
        this.ORCID = ORCID;
    }
    /**
     * Obtém o cienciaID do autor
     * @return cienciaID
     */
    public String getCienciaID() {
        return cienciaID;
    }
    /**
     * Define o ciencia id do autor
     * @param cienciaID o novo ciencia id do autor
     */
    public void setCienciaID(String cienciaID) {
        this.cienciaID = cienciaID;
    }
    /**
     * Obtém o google Scolar Id do autor
     * @return googleScholarID
     */
    public String getGoogleScholarID() {
        return googleScholarID;
    }
    /**
     * Define o googleScholar id do autor
     * @param googleScholarID o novo google Scholar id do autor
     */
    public void setGoogleScholarID(String googleScholarID) {
        this.googleScholarID = googleScholarID;
    }
    /**
     * Obtém o scopusAuthor Id do autor
     * @return scopusAuthorID
     */
    public String getScopusAuthorID() {
        return scopusAuthorID;
    }
    /**
     * Define o scopusAuthor id do autor
     * @param scopusAuthorID o novo scopusAuthorID id do autor
     */
    public void setScopusAuthorID(String scopusAuthorID) {
        this.scopusAuthorID = scopusAuthorID;
    }
    /**
     * Obtém as areas de investigação do autor
     * @return areasInvestigacao
     */
    public List<String> getAreasInvestigacao() {
        return areasInvestigacao;
    }
    /**
     * Define as areas de investigação do autor
     * @return areasInvestigacao
     */
    public void setAreasInvestigacao(List<String> areasInvestigacao) {
        this.areasInvestigacao = areasInvestigacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public List<Artigo> getHistoricoArtigos() {
        return historicoArtigos;
    }

    public void setHistoricoArtigos(List<Artigo> historicoArtigos) {
        this.historicoArtigos = historicoArtigos;
    }




    // Método para adicionar artigo ao histórico de artigos do autor
    public void adicionarArtigo(Artigo artigo) {
        historicoArtigos.add(artigo);
    }

    // Método para remover artigo do histórico de artigos do autor
    public void removerArtigo(Artigo artigo) {
        historicoArtigos.remove(artigo);
    }
}

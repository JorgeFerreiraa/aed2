import java.util.*;
public class Main {
    public static void main(String[] args) {
        BaseDeDados bd =  new BaseDeDados();

        Conferencia conferencia1 = new Conferencia("Conferencia1", new Date(),1,"Local1");
        Conferencia conferencia2 = new Conferencia("Conferencia2", new Date(),2,"Local2");

        Journal journal1 = new Journal("Journal1", "Publisher1",new Date(),"Periodiciade1",1,1);
        Journal journal2 = new Journal("Journal2", "Publisher2",new Date(),"Periodiciade2",2,2);



        List<String> areas1 = new ArrayList<>(Arrays.asList("AreaA1", "AreaB1"));
        List<String> areas2 = new ArrayList<>(Arrays.asList("AreaA2", "AreaB2"));

        Autor autor1 = new Autor("Nome1","NomeCurt1","Filiacao1","1","1","1","1",areas1,"Formacao1");
        Autor autor2 = new Autor("Nome2","NomeCurto2","Filiacao2","2","1","1","1",areas2,"Formacao2");

        ArrayList<Autor> autores1 = new ArrayList<>();
        autores1.add(autor1);


        ArrayList<Autor> autores2 = new ArrayList<>();
        autores2.add(autor2);

        ArrayList<Artigo> artigos1 = new ArrayList<>();
        ArrayList<Artigo> artigos2 = new ArrayList<>();
        ArrayList<String> palavrachave1 = new ArrayList<>();
        palavrachave1.add("PalavrachaveA1");
        palavrachave1.add("PalavrachaveB1");

        ArrayList<String> palavrachave2 = new ArrayList<>();
        palavrachave2.add("PalavrachaveA2");
        palavrachave2.add("PalavrachaveB2");

        Artigo artigo1 = new Artigo("Titulo1",palavrachave1,"Journal",new Date(),1,1,1,autores1,artigos1,conferencia1,journal1);
        Artigo artigo2 = new Artigo("Titulo2",palavrachave2,"Conferencia", new Date(),2,2,2,autores2,artigos2,conferencia2,journal2);


        inserirArtigoTeste(bd,artigo1);
        inserirArtigoTeste(bd,artigo2);

        removerArtigoTeste(bd,artigo1);
        removerArtigoTeste(bd,artigo2);

        pesquisarArtigoTeste(bd,artigo1);
        pesquisarArtigoTeste(bd,artigo2);

        inserirAutorTeste(bd,autor1);
        inserirAutorTeste(bd,autor2);

        removerAutorTeste(bd,autor1);
        removerAutorTeste(bd,autor2);

        pesquisarAutorTeste(bd,autor1);
        pesquisarAutorTeste(bd,autor2);

        validarReferenciasAutores(bd);
    }
    static void inserirArtigoTeste(BaseDeDados bd,Artigo artigo){
        bd.inserirArtigo(artigo);
    }

    static void inserirAutorTeste(BaseDeDados bd,Autor autor){
        bd.inserirAutor(autor);
    }

    static void removerAutorTeste(BaseDeDados bd,Autor autor){
        bd.removerAutor(autor.getId());
    }
    static void removerArtigoTeste(BaseDeDados bd,Artigo artigo){
        bd.removerArtigo(artigo.getId());
    }
    static void pesquisarArtigoTeste(BaseDeDados bd, Artigo artigo){
        bd.pesquisarArtigo(artigo.getTitulo());
    }
    static void pesquisarAutorTeste(BaseDeDados bd, Autor autor){
        bd.pesquisarAutor(autor.getNome());
    }
    static void validarReferenciasAutores(BaseDeDados bd){
        bd.validarReferenciasAutores();
    }

    static void inserirPublicacaoTeste(BaseDeDados bd, Publicacao publicacao){
        bd.inserirPublicacao(publicacao);
    }
    static void removerPublicacaoTeste(BaseDeDados bd, Publicacao publicacao){
        bd.removerPublicacao(publicacao.getNome());
    }
    static void pesquisarPublicacaoTeste(BaseDeDados bd, Publicacao publicacao){
        bd.pesquisarPublicacao(publicacao.getNome());
    }
    static void encontrarArtigosPorAutorNoPeriodoTeste(BaseDeDados bd, String autor,int anoini,int anofim){
        bd.encontrarArtigosPorAutorNoPeriodo(autor,anofim,anofim);
    }
    static void encontrarArtigosNaoDescarregadosVisualizadosPeriodoTeste(BaseDeDados bd, int anoInicio, int anoFim){
        bd.encontrarArtigosNaoDescarregadosVisualizadosPeriodo(anoInicio, anoFim);
    }
    static void topArtigosMaisUsadosNumTempoTeste(BaseDeDados bd, int anoInicio, int anoFim){
        bd.topArtigosMaisUsadosNumTempo(anoInicio,anoFim);
    }
    static void gerarRelatorioTeste(BaseDeDados bd){
        bd.gerarRelatorioGlobal();
    }

    static void escreverArtigo(BaseDeDados bd){
        bd.escreverArtigo();
    }
    static void lerArtigo(BaseDeDados bd){
        bd.lerArtigo();
    }
    static void escreverArtigoBinario(BaseDeDados bd){
        bd.escreverBinarioArtigo();
    }

    static void lerArtigoBinario(BaseDeDados bd){
        bd.lerBinarioArtigo();
    }
    static void listarArtigosPorJournalConferenciaEPeriodo(BaseDeDados bd, String tipo,Date inicio,Date fim){
        bd.listarArtigosPorJournalConferenciaEPeriodo(tipo,inicio,fim);
    }
    static void calcularAutoCitacao(BaseDeDados bd,Artigo artigo){
        bd.calcularAutoCitacao(artigo);
    }
    static void subGrafoPorJournalConferencia(BaseDeDados bd, String tipo){
        bd.subGrafoPorJournalConferencia(tipo);
    }
}


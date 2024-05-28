package Projeto;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um Autor.
 */
public class Autor {
    private String nome;
    private String nomeCientifico;
    private String filiacao;
    private String orcid;
    private String cienciaID;
    private String googleScholarID;
    private String scopusAutorID;
    private List<Artigo> artigos;
    /**
     * Construtor para a classe Autor.
     *
     * @param nome              O nome do autor.
     * @param nomeCientifico    O nome científico do autor.
     * @param filiacao          A filiação do autor.
     * @param orcid             O ORCID do autor.
     * @param cienciaID         O ID Ciência do autor.
     * @param googleScholarID   O ID do Google Scholar do autor.
     * @param scopusAutorID    O ID do Scopus Author do autor.
     */
    public Autor(String nome, String nomeCientifico, String filiacao, String orcid, String cienciaID, String googleScholarID, String scopusAutorID) {
        this.nome = nome;
        this.nomeCientifico = nomeCientifico;
        this.filiacao = filiacao;
        this.orcid = orcid;
        this.cienciaID = cienciaID;
        this.googleScholarID = googleScholarID;
        this.scopusAutorID = scopusAutorID;
        this.artigos = new ArrayList<>();
    }
    /**
     * Obtém o nome do autor.
     *
     * @return O nome do autor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do autor.
     *
     * @param nome O novo nome do autor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome científico do autor.
     *
     * @return O nome científico do autor.
     */
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    /**
     * Define o nome científico do autor.
     *
     * @param nomeCientifico O novo nome científico do autor.
     */
    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    /**
     * Obtém a filiação do autor.
     *
     * @return A filiação do autor.
     */
    public String getFiliacao() {
        return filiacao;
    }

    /**
     * Define a filiação do autor.
     *
     * @param filiacao A nova filiação do autor.
     */
    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    /**
     * Obtém o ORCID do autor.
     *
     * @return O ORCID do autor.
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * Define o ORCID do autor.
     *
     * @param orcid O novo ORCID do autor.
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    /**
     * Obtém o ID Ciência do autor.
     *
     * @return O ID Ciência do autor.
     */
    public String getCienciaID() {
        return cienciaID;
    }

    /**
     * Define o ID Ciência do autor.
     *
     * @param cienciaID O novo ID Ciência do autor.
     */
    public void setCienciaID(String cienciaID) {
        this.cienciaID = cienciaID;
    }

    /**
     * Obtém o ID do Google Scholar do autor.
     *
     * @return O ID do Google Scholar do autor.
     */
    public String getGoogleScholarID() {
        return googleScholarID;
    }

    /**
     * Define o ID do Google Scholar do autor.
     *
     * @param googleScholarID O novo ID do Google Scholar do autor.
     */
    public void setGoogleScholarID(String googleScholarID) {
        this.googleScholarID = googleScholarID;
    }

    /**
     * Obtém o ID do Scopus Author do autor.
     *
     * @return O ID do Scopus Author do autor.
     */
    public String getScopusAuthorID() {
        return scopusAutorID;
    }

    /**
     * Define o ID do Scopus Autor do autor.
     *
     * @param scopusAutorID O novo ID do Scopus Author do autor.
     */
    public void setScopusAutorID(String scopusAutorID) {
        this.scopusAutorID = scopusAutorID;
    }

    /**
     * Obtém a lista de artigos do autor.
     *
     * @return A lista de artigos do autor.
     */
    public List<Artigo> getArtigos() {
        return artigos;
    }

    /**
     * Define a lista de artigos do autor.
     *
     * @param artigos A nova lista de artigos do autor.
     */
    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    /**
     * Adiciona um artigo à lista de artigos do autor.
     *
     * @param artigo O artigo a ser adicionado.
     */
    public void adicionarArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    /**
     * Remove um artigo da lista de artigos do autor.
     *
     * @param artigo o artigo a ser removido
     */
    public void removerAutor(Artigo artigo) {
        this.artigos.remove(artigo);
    }

    /**
     * Retorna uma representação em string do autor.
     *
     * @return Uma string que representa o autor.
     */
    @Override
    public String toString() {
        return "Autor{" + "nome:" + nome + "\t" + "filiacao:" + filiacao + '}';
    }

}

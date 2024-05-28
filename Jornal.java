package Projeto;
/**
 * Representa um jornal, que é um tipo de publicação.
 * Inclui informações sobre a periodicidade e fatores de impacto JCR e Scopus.
 */
public class Jornal extends Publicacao{
    private String periodicidade;
    private float jcrIF;
    private float scopusIF;

    /**
     * Construtor da classe Jornal.
     *
     * @param nome o nome do jornal
     * @param publisher o editor do jornal
     * @param ano o ano de publicação do jornal
     * @param periodicidade a periodicidade do jornal (ex: mensal, trimestral)
     * @param jcrIF o fator de impacto JCR do jornal
     * @param scopusIF o fator de impacto Scopus do jornal
     */
    public Jornal(String nome, String publisher, int ano, String periodicidade, float jcrIF, float scopusIF) {
        super(nome, publisher, ano);
        this.periodicidade = periodicidade;
        this.jcrIF = jcrIF;
        this.scopusIF = scopusIF;
    }

    /**
     * Obtém a periodicidade do jornal.
     *
     * @return a periodicidade do jornal
     */
    public String getPeriodicidade() {
        return periodicidade;
    }

    /**
     * Define a periodicidade do jornal.
     *
     * @param periodicidade a nova periodicidade do jornal
     */
    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    /**
     * Obtém o IF JCR do jornal.
     *
     * @return o IF JCR do jornal
     */
    public float getJcrIF() {
        return jcrIF;
    }

    /**
     * Define o IF JCR do jornal.
     *
     * @param jcrIF o novo IF JCR do jornal
     */
    public void setJcrIF(float jcrIF) {
        this.jcrIF = jcrIF;
    }

    /**
     * Obtém o IF Scopus do jornal.
     *
     * @return o IF Scopus do jornal
     */
    public float getScopusIF() {
        return scopusIF;
    }

    /**
     * Define o IF Scopus do jornal.
     *
     * @param scopusIF o novo IF Scopus do jornal
     */
    public void setScopusIF(float scopusIF) {
        this.scopusIF = scopusIF;
    }
}

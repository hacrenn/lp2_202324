package Projeto;
/**
 * Representa uma publicação genérica.
 * Contém informações básicas como nome, editor  e ano de publicação.
 */
public class Publicacao {
    protected String nome;
    protected String editor;
    protected int ano;

    /**
     * Construtor da classe Publicacao.
     *
     * @param nome o nome da publicação
     * @param editor o editor da publicação
     * @param ano o ano de publicação
     */
    public Publicacao(String nome, String editor, int ano) {
        this.nome = nome;
        this.editor = editor;
        this.ano = ano;
    }

    /**
     * Obtém o nome da publicação.
     *
     * @return o nome da publicação
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da publicação.
     *
     * @param nome o novo nome da publicação
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o editor da publicação.
     *
     * @return o editor da publicação
     */
    public String getPublisher() {
        return editor;
    }

    /**
     * Define o editor da publicação.
     *
     * @param editor o novo editor da publicação
     */
    public void setPublisher(String editor) {
        this.editor = editor;
    }

    /**
     * Obtém o ano de publicação.
     *
     * @return o ano de publicação
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano de publicação.
     *
     * @param ano o novo ano de publicação
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
}

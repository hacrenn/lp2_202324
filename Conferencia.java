package Projeto;
/**
 * Representa uma conferência, que é um tipo de publicação.
 * Inclui informações sobre o número da edição e o local da conferência.
 */
public class Conferencia extends Publicacao{
    private int numeroEdicao;
    private String local;

    /**
     * Construtor da classe Conferencia.
     *
     * @param nome o nome da conferência
     * @param publisher o editor da conferência
     * @param ano o ano da conferência
     * @param numeroEdicao o número da edição da conferência
     * @param local o local onde a conferência foi realizada
     */
    public Conferencia(String nome, String publisher, int ano, int numeroEdicao, String local) {
        super(nome, publisher, ano);
        this.numeroEdicao = numeroEdicao;
        this.local = local;
    }

    /**
     * Obtém o número da edição da conferência.
     *
     * @return o número da edição da conferência
     */
    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    /**
     * Define o número da edição da conferência.
     *
     * @param numeroEdicao o novo número da edição da conferência
     */
    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    /**
     * Obtém o local da conferência.
     *
     * @return o local da conferência
     */
    public String getLocal() {
        return local;
    }

    /**
     * Define o local da conferência.
     *
     * @param local o novo local da conferência
     */
    public void setLocal(String local) {
        this.local = local;
    }
}

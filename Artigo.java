package Projeto;

import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Classe que representa um Artigo.
 */
public class Artigo {
    private String titulo;
    private List<String> palavrasChave;
    private String resumo;
    private TipoPublicacao tipo;
    private Date data;
    private int downloads;
    private Map<Date, Integer> visualizacoes;
    private Map<Date, Integer> likes;
    private List<Autor> autores;
    private List<Artigo> referencias;

    /**
     * Construtor da classe Artigo.
     *
     * @param titulo        o título do artigo
     * @param palavrasChave a lista de palavras-chave associadas ao artigo
     * @param resumo        o resumo do artigo
     * @param tipo          o tipo de publicação do artigo
     * @param data          a data de publicação do artigo
     */
    public Artigo(String titulo, List<String> palavrasChave, String resumo, TipoPublicacao tipo, Date data)  {
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.tipo = tipo;
        this.data = data;
        this.downloads = 0;
        this.visualizacoes = new HashMap<>();
        this.likes = new HashMap<>();
        this.autores = new ArrayList<>();
        this.referencias = new ArrayList<>();
    }

    /**
     * Obtém o título do artigo.
     *
     * @return o título do artigo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do artigo.
     *
     * @param titulo o novo título do artigo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém as palavras-chave do artigo.
     *
     * @return uma lista de palavras-chave do artigo
     */
    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    /**
     * Define as palavras-chave do artigo.
     *
     * @param palavrasChave uma nova lista de palavras-chave do artigo
     */
    public void setPalavrasChave(List<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    /**
     * Obtém o resumo do artigo.
     *
     * @return o resumo do artigo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * Define o resumo do artigo.
     *
     * @param resumo o novo resumo do artigo
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * Obtém o tipo de publicação do artigo.
     *
     * @return o tipo de publicação do artigo
     */
    public TipoPublicacao getTipo() {
        return tipo;
    }

    /**
     * Define o tipo de publicação do artigo.
     *
     * @param tipo o novo tipo de publicação do artigo
     */
    public void setTipo(TipoPublicacao tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém a data de publicação do artigo.
     *
     * @return a data de publicação do artigo
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data de publicação do artigo.
     *
     * @param data a nova data de publicação do artigo
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém o número de downloads do artigo.
     *
     * @return o número de downloads do artigo
     */
    public int getDownloads() {
        return downloads;
    }

    /**
     * Define o número de downloads do artigo.
     *
     * @param downloads o novo número de downloads do artigo
     */
    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    /**
     * Obtém o mapa de visualizações do artigo por data.
     *
     * @return um mapa de datas e o número de visualizações correspondentes
     */
    public Map<Date, Integer> getVisualizacoes() {
        return visualizacoes;
    }

    /**
     * Define o mapa de visualizações do artigo por data.
     *
     * @param visualizacoes um novo mapa de datas e o número de visualizações correspondentes
     */
    public void setVisualizacoes(Map<Date, Integer> visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    /**
     * Obtém o mapa de likes do artigo por data.
     *
     * @return um mapa de datas e o número de likes correspondentes
     */
    public Map<Date, Integer> getLikes() {
        return likes;
    }

    /**
     * Define o mapa de likes do artigo por data.
     *
     * @param likes um novo mapa de datas e o número de likes correspondentes
     */
    public void setLikes(Map<Date, Integer> likes) {
        this.likes = likes;
    }

    /**
     * Obtém a lista de autores do artigo.
     *
     * @return uma lista de autores do artigo
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * Define a lista de autores do artigo.
     *
     * @param autores uma nova lista de autores do artigo
     */
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    /**
     * Obtém a lista de referências do artigo.
     *
     * @return uma lista de referências do artigo
     */
    public List<Artigo> getReferencias() {
        return referencias;
    }

    /**
     * Define a lista de referências do artigo.
     *
     * @param referencias uma nova lista de referências do artigo
     */
    public void setReferencias(List<Artigo> referencias) {
        this.referencias = referencias;
    }

    /**
     * Adiciona um autor à lista de autores do artigo.
     *
     * @param autor o autor a ser adicionado
     */
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
        autor.adicionarArtigo(this);
    }

    /**
     * Remove um autor da lista de autores do artigo.
     *
     * @param autor o autor a ser removido
     */
    public void removerAutor(Autor autor) {
        this.autores.remove(autor);
    }

    /**
     * Retorna uma representação em string do artigo.
     *
     * @return uma string contendo o título, data, tipo e resumo do artigo
     */
    @Override
    public String toString() {
        return "Artigo{" + "titulo:" + titulo + "\t" + "data:" + data + "\t" +"tipo:" + tipo + "\t" +"resumo:" + resumo + '}';
    }

}

package Projeto;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Queue;

import java.util.*;

/**
 * Representa um grafo direcionado de artigos, onde os nós são artigos e as arestas representam citações entre artigos.
 */
class GrafoArtigos {
    private Digraph grafo;
    private Map<Artigo, Integer> indices;
    private List<Artigo> artigos;

    /**
     * Construtor da classe GrafoArtigos.
     * Inicializa um grafo vazio, um mapa de índices e uma lista de artigos.
     */
    public GrafoArtigos() {
        this.grafo = new Digraph(0);
        this.indices = new HashMap<>();
        this.artigos = new ArrayList<>();
    }

    /**
     * Adiciona um artigo ao grafo. Se o artigo já estiver no grafo, não faz nada.
     *
     * @param artigo o artigo a ser adicionado
     */
    public void adicionarArtigo(Artigo artigo) {
        if (!indices.containsKey(artigo)) {
            int index = artigos.size();
            artigos.add(artigo);
            indices.put(artigo, index);
            Digraph novoGrafo = new Digraph(artigos.size());
            for (int v = 0; v < grafo.V(); v++) {
                for (int w : grafo.adj(v)) {
                    novoGrafo.addEdge(v, w);
                }
            }
            this.grafo = novoGrafo;
        }
    }

    /**
     * Adiciona uma citação de um artigo para outro no grafo.
     *
     * @param de o artigo que faz a citação
     * @param para o artigo citado
     */
    public void adicionarCitacao(Artigo de, Artigo para) {
        if (indices.containsKey(de) && indices.containsKey(para)) {
            grafo.addEdge(indices.get(de), indices.get(para));
        }
    }

    /**
     * Obtém a lista de artigos que citam um determinado artigo.
     *
     * @param artigo o artigo cujas citações serão obtidas
     * @return a lista de artigos que citam o artigo especificado
     */
    public List<Artigo> getCitacoes(Artigo artigo) {
        List<Artigo> citacoes = new ArrayList<>();
        int index = indices.get(artigo);
        for (int v = 0; v < grafo.V(); v++) {
            for (int w : grafo.adj(v)) {
                if (w == index) {
                    citacoes.add(artigos.get(v));
                }
            }
        }
        return citacoes;
    }

    /**
     * Obtém as citacoes de primeira ordem um determinado artigo.
     *
     * @param artigo o artigo cujas citações de primeira ordem serão obtidas
     * @return o numero de citacoes de primeira ordem do artigo
     */
    public int contarCitacoesDePrimeiraOrdem(Artigo artigo) {
        return getCitacoes(artigo).size();
    }

    /**
     * Obtém as citacoes de segunda ordem um determinado artigo.
     *
     * @param artigo o artigo cujas citações de segunda ordem serão obtidas
     * @return o numero de citacoes de segunda ordem do artigo
     */
    public int contarCitacoesDeSegundaOrdem(Artigo artigo) {
        int count = 0;
        List<Artigo> citacoesPrimeiraOrdem = getCitacoes(artigo);
        for (Artigo citado : citacoesPrimeiraOrdem) {
            count += getCitacoes(citado).size();
        }
        return count;
    }

    /**
     * Obtém as autocitacoes de um determinado artigo.
     *
     * @param artigo o artigo cujas autocitações serão obtidas
     * @return o numero de autocitacoes do artigo
     */
    public int contarAutocitacoes(Artigo artigo) {
        int count = 0;
        List<Autor> autores = artigo.getAutores();
        for (Artigo citado : getCitacoes(artigo)) {
            for (Autor autor : autores) {
                if (citado.getAutores().contains(autor)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Obtém os artigos de um determinado tipo.
     *
     * @param tipo o tipo de publicação
     * @return o subgrafo de artigos de um determinado tipo
     */
    public GrafoArtigos subGrafoPorTipo(TipoPublicacao tipo) {
        GrafoArtigos subGrafo = new GrafoArtigos();
        for (Artigo artigo : artigos) {
            if (artigo.getTipo() == tipo) {
                subGrafo.adicionarArtigo(artigo);
            }
        }
        for (Artigo artigo : subGrafo.artigos) {
            for (Artigo citado : getCitacoes(artigo)) {
                if (subGrafo.indices.containsKey(citado)) {
                    subGrafo.adicionarCitacao(artigo, citado);
                }
            }
        }
        return subGrafo;
    }

    /**
     * Verifica se um grafo é conexo.
     *
     * @return true se for conexo, false se não for conexo
     */
    public boolean Conexo() {
        if (grafo.V() == 0) return true;

        boolean[] marked = new boolean[grafo.V()];
        dfs(0, marked);

        for (boolean mark : marked) {
            if (!mark) return false;
        }
        return true;
    }

    private void dfs(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : grafo.adj(v)) {
            if (!marked[w]) {
                dfs(w, marked);
            }
        }
    }

    /**
     * Retorna uma representação em string do do grafo.
     *
     * @return Uma string que representa o grafo.
     */
    @Override
    public String toString() {
        return "GrafoArtigos{" + "artigos:" + artigos + '}';
    }
}

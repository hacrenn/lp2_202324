package Projeto;

import edu.princeton.cs.algs4.*;

import java.util.*;

/**
 * Representa um grafo não direcionado de autores, onde os nós são autores e as arestas representam colaborações entre autores.
 */
class GrafoAutores {
    private Graph grafo;
    private Map<Autor, Integer> indices;
    private List<Autor> autores;

    /**
     * Construtor da classe GrafoAutores.
     * Inicializa um grafo vazio, um mapa de índices e uma lista de autores.
     */
    public GrafoAutores() {
        this.grafo = new Graph(0);
        this.indices = new HashMap<>();
        this.autores = new ArrayList<>();
    }

    /**
     * Adiciona um autor ao grafo. Se o autor já estiver no grafo, não faz nada.
     *
     * @param autor o autor a ser adicionado
     */
    public void adicionarAutor(Autor autor) {
        if (!indices.containsKey(autor)) {
            int index = autores.size();
            autores.add(autor);
            indices.put(autor, index);
            Graph novoGrafo = new Graph(autores.size());
            for (int v = 0; v < grafo.V(); v++) {
                for (int w : grafo.adj(v)) {
                    novoGrafo.addEdge(v, w);
                }
            }
            this.grafo = novoGrafo;
        }
    }

    /**
     * Adiciona uma colaboração entre dois autores no grafo.
     *
     * @param autor1 o primeiro autor da colaboração
     * @param autor2 o segundo autor da colaboração
     */
    public void adicionarColaboracao(Autor autor1, Autor autor2) {
        if (indices.containsKey(autor1) && indices.containsKey(autor2)) {
            grafo.addEdge(indices.get(autor1), indices.get(autor2));
        }
    }

    /**
     * Obtém a lista de colaboradores de um determinado autor.
     *
     * @param autor o autor cujos colaboradores serão obtidos
     * @return a lista de colaboradores do autor especificado
     */
    public List<Autor> getColaboradores(Autor autor) {
        List<Autor> colaboradores = new ArrayList<>();
        int index = indices.get(autor);
        for (int w : grafo.adj(index)) {
            colaboradores.add(autores.get(w));
        }
        return colaboradores;
    }

    /**
     * Lista os autores que estão afiliados a qualquer uma das instituições fornecidas.
     *
     * @param instituicoes uma lista de nomes de instituições para filtrar os autores.
     * @return uma lista de autores que estão afiliados a pelo menos uma das instituições especificadas.
     */
    public List<Autor> listarAutoresPorInstituicoes(List<String> instituicoes) {
        List<Autor> resultado = new ArrayList<>();
        for (Autor autor : autores) {
            for (String instituicao : instituicoes) {
                if (autor.getFiliacao().contains(instituicao)) {
                    resultado.add(autor);
                    break;
                }
            }
        }
        return resultado;
    }

    /**
     * Obtém o número de colaboradores de um determinado autor.
     *
     * @param autor o autor cujo número de colaboradores será obtido
     * @return o número de colaboradores do autor especificado
     */
    public int getNColaboradores(Autor autor) {
        int numero = 0;
        int index = indices.get(autor);
        for (int w : grafo.adj(index)) {
            numero++;
        }
        return numero;
    }

    /**
     * Conta o número de artigos em que dois autores colaboraram juntos.
     *
     * @param autor1 o primeiro autor.
     * @param autor2 o segundo autor.
     * @return o número de artigos em que os dois autores colaboraram.
     */
    public int numeroDeArtigosEntreAutores(Autor autor1, Autor autor2) {
        int count = 0;
        for (Artigo artigo : autor1.getArtigos()){
            if (artigo.getAutores().contains(autor2)){
                count++;
            }
        }
        return count;
    }


    /**
     * Cria um subgrafo contendo apenas os autores afiliados à filiação especificada.
     *
     * @param filiacao o nome da filiação para a qual o subgrafo será criado.
     * @return um subgrafo contendo apenas os autores afiliados à filiação especificada.
     */
    public GrafoAutores subGrafoPorFiliacao(String filiacao) {
        GrafoAutores subGrafo = new GrafoAutores();
        for (Autor autor : autores) {
            if (Objects.equals(autor.getFiliacao(), filiacao)) {
                subGrafo.adicionarAutor(autor);
            }
        }
        return subGrafo;
    }


    /**
     * Retorna uma representação em formato de string do objeto GrafoAutores.
     *
     * @return uma representação em formato de string do grafo, incluindo uma lista de autores.
     */
    @Override
    public String toString() {
        return "GrafoAutores{" +"autores:" + autores + '}';
    }
}

package Projeto;

import edu.princeton.cs.algs4.*;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Classe que representa uma base de dados de artigos e autores.
 * Utiliza diferentes estruturas de dados para organizar e gerenciar os artigos e autores.
 */
public class BaseDeDados {
    private RedBlackBST<Date, Artigo> artigosPorData;
    private RedBlackBST<String, Autor> autoresPorNome;
    private HashMap<String, Artigo> artigosPorTitulo;
    private HashMap<String, Autor> autoresPorID;
    private HashMap<String, String> autoresArquivados;

    /**
     * Construtor da classe BaseDeDados.
     * Inicializa as estruturas de dados utilizadas para armazenar artigos e autores.
     */
    public BaseDeDados() {
        this.artigosPorData = new RedBlackBST<>();
        this.autoresPorNome = new RedBlackBST<>();
        this.artigosPorTitulo = new HashMap<>();
        this.autoresPorID = new HashMap<>();
        this.autoresArquivados = new HashMap<>();
    }

    /**
     * Adiciona um artigo à base de dados.
     *
     * @param artigo o artigo a ser adicionado
     */
    public void adicionarArtigo(Artigo artigo){
        artigosPorData.put(artigo.getData(),artigo);
        artigosPorTitulo.put(artigo.getTitulo(),artigo);
    }

    /**
     * Remove um artigo da base de dados pelo seu título.
     *
     * @param titulo o título do artigo a ser removido
     */
    public void removerArtigo(String titulo){
        Artigo artigo = artigosPorTitulo.remove(titulo);
        if (artigo != null) {
            artigosPorData.delete(artigo.getData());
        }
    }

    /**
     * Edita um artigo na base de dados.
     *
     * @param titulo o título do artigo a ser editado
     * @param novoArtigo o novo artigo que substituirá o artigo existente
     */
    public void editarArtigo(String titulo, Artigo novoArtigo) {
        removerArtigo(titulo);
        adicionarArtigo(novoArtigo);
    }

    /**
     * Lista todos os artigos presentes na base de dados.
     *
     * @return uma lista que contém todos os artigos
     */
    public List<Artigo> listarArtigos() {
        List<Artigo> lista = new ArrayList<>();
        for (Date data : artigosPorData.keys()) {
            lista.add(artigosPorData.get(data));
        }
        return lista;
    }

    /**
     * Adiciona um autor à base de dados.
     *
     * @param autor o autor a ser adicionado
     */
    public void adicionarAutor(Autor autor) {
        autoresPorNome.put(autor.getNome(), autor);
        autoresPorID.put(autor.getOrcid(), autor);
    }

    /**
     * Remove um autor da base de dados pelo seu ORCID.
     *
     * @param orcid o ORCID do autor a ser removido
     */
    public void removerAutor(String orcid) {
        Autor autor = autoresPorID.remove(orcid);
        if (autor != null) {
            autoresPorNome.delete(autor.getNome());
            arquivarAutor(autor);
            atualizarArtigosRemocaoAutor(autor);
        }
    }

    /**
     * Arquiva um autor removido.
     *
     * @param autor o autor a ser arquivado
     */
    public void arquivarAutor(Autor autor){
        autoresArquivados.put(autor.getOrcid(),autor.getNomeCientifico());
    }

    /**
     * Atualiza os artigos removendo a referência a um autor removido.
     *
     * @param autor o autor removido
     */
    private void atualizarArtigosRemocaoAutor(Autor autor) {
        for (Artigo artigo : listarArtigos()) {
            if (artigo.getAutores().contains(autor)) {
                artigo.removerAutor(autor);
            }
        }
    }

    /**
     * Edita um autor na base de dados.
     *
     * @param orcid o ORCID do autor a ser editado
     * @param novoAutor o novo autor que substituirá o autor existente
     */
    public void editarAutor(String orcid, Autor novoAutor) {
        removerAutor(orcid);
        adicionarAutor(novoAutor);
    }

    /**
     * Lista todos os autores presentes na base de dados.
     *
     * @return uma lista que contém todos os autores
     */
    public List<Autor> listarAutores() {
        List<Autor> lista = new ArrayList<>();
        for (String nome : autoresPorNome.keys()) {
            lista.add(autoresPorNome.get(nome));
        }
        return lista;
    }

    /**
     * Procura um artigo pelo seu título.
     *
     * @param titulo o título do artigo a ser procurado
     * @return o artigo encontrado ou null se não encontrado
     */
    public Artigo procurarArtigoPorTitulo(String titulo) {
        return artigosPorTitulo.get(titulo);
    }

    /**
     * Procura um autor pelo seu ORCID.
     *
     * @param orcid o ORCID do autor a ser procurado
     * @return o autor encontrado ou null se não encontrado
     */
    public Autor procurarAutorPorID(String orcid) {
        return autoresPorID.get(orcid);
    }

    /**
     * Valida a consistência da base de dados, verificando se todos os autores referenciados em artigos
     * estão presentes na base de dados.
     *
     * @return true se a base de dados for consistente, false caso contrário
     */
    public boolean validarConsistencia() {
        for (Artigo artigo : listarArtigos()) {
            for (Autor autor : artigo.getAutores()) {
                if (!autoresPorID.containsKey(autor.getOrcid())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Busca todos os artigos escritos por um autor em um dado período.
     *
     * @param orcid  ORCID do autor.
     * @param inicio Data de início do período.
     * @param fim    Data de fim do período.
     * @return Lista de artigos escritos pelo autor no período especificado.
     */

    public List<Artigo> artigosAutorPorPeriodo(String orcid, Date inicio, Date fim) {
        List<Artigo> resultado = new ArrayList<>();
        for (Date data : artigosPorData.keys(inicio, fim)) {
            Artigo artigo = artigosPorData.get(data);
            for (Autor autor : artigo.getAutores()) {
                if (autor.getOrcid().equals(orcid)) {
                    resultado.add(artigo);
                    break;
                }
            }
        }
        return resultado;
    }

    /**
     * Retorna uma lista de artigos que não foram visualizados nem descarregados durante o período especificado.
     *
     * @param inicio a data de início do período.
     * @param fim a data de término do período.
     * @return uma lista de artigos que não foram visualizados nem descarregados no período especificado.
     */
    public List<Artigo> artigosNaoDescarregadosVizualizadosPorPeriodo(Date inicio,Date fim){
        List<Artigo> resultado = new ArrayList<>();
        for (Date data : artigosPorData.keys(inicio,fim)){
            Artigo artigo = artigosPorData.get(data);
            boolean foiVisualizadoNoPeriodo = false;
            boolean foiDescarregadoNoPeriodo = false;

            for (Map.Entry<Date, Integer> visualizacaoEntry : artigo.getVisualizacoes().entrySet()) {
                Date dataVisualizacao = visualizacaoEntry.getKey();
                if (!dataVisualizacao.before(inicio) && !dataVisualizacao.after(fim)) {
                    foiVisualizadoNoPeriodo = true;
                    break;
                }
            }

            for (Map.Entry<Date, Integer> downloadEntry : artigo.getDownloads().entrySet()) {
                Date dataDownload = downloadEntry.getKey();
                if (!dataDownload.before(inicio) && !dataDownload.after(fim)) {
                    foiDescarregadoNoPeriodo = true;
                    break;
                }
            }

            if (!foiVisualizadoNoPeriodo && !foiDescarregadoNoPeriodo) {
                resultado.add(artigo);
            }
        }

        return resultado;
    }

    /**
     * Este método retorna os três artigos mais utilizados durante um período específico, considerando visualizações
     * e downloads desses artigos.
     *
     * @param inicio data de início do período
     * @param fim data de fim do período
     * @return uma lista contendo os três artigos mais utilizados durante o período especificado
     */
    public List<Artigo> top3ArtigosMaisUsadosPorPeriodo(Date inicio, Date fim) {
        Map<Artigo, Integer> usoArtigos = new HashMap<>();

        for (Date data : artigosPorData.keys(inicio,fim)){
            Artigo artigo = artigosPorData.get(data);
            int totalUso = 0;

            for (Map.Entry<Date, Integer> visualizacaoEntry : artigo.getVisualizacoes().entrySet()) {
                Date dataVisualizacao = visualizacaoEntry.getKey();
                if (!dataVisualizacao.before(inicio) && !dataVisualizacao.after(fim)) {
                    totalUso += visualizacaoEntry.getValue();
                }
            }

            for (Map.Entry<Date, Integer> downloadEntry : artigo.getDownloads().entrySet()) {
                Date dataDownload = downloadEntry.getKey();
                if (!dataDownload.before(inicio) && !dataDownload.after(fim)) {
                    totalUso += downloadEntry.getValue();
                }
            }

            if (totalUso > 0) {
                usoArtigos.put(artigo, totalUso);
            }
        }


        // Ordena os artigos pelo total de uso (em ordem decrescente)
        List<Map.Entry<Artigo, Integer>> listaOrdenada = new ArrayList<>(usoArtigos.entrySet());
        listaOrdenada.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Seleciona os Top-3
        List<Artigo> top3Artigos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            top3Artigos.add(listaOrdenada.get(i).getKey());
        }

        return top3Artigos;
    }

    /**
     * Escreve todos os dados no ficheiro "Output.txt".
     */
    public void escreverDadosNoFicheiro() {
        String ficheiro = "Output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheiro))) {
            for (Artigo artigo : listarArtigos()){
                writer.write(artigo.getTitulo());
                writer.newLine(); // Adiciona uma nova linha ao final dos dados, se desejado
            }
            for (Autor autor : listarAutores()){
                writer.write(autor.getNome());
                writer.newLine(); // Adiciona uma nova linha ao final dos dados, se desejado
            }
            System.out.println("Dados escritos com sucesso no ficheiro: " + ficheiro);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever no ficheiro: " + e.getMessage());
        }
    }
}

package br.com.dio.desafio.dominio;

public abstract class Conteudo {
    
    protected static final double XP_PADRAO = 10d;
    
    private String titulo;
    private String descricao;
    private Boolean concluido;
    
    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = false;
    }

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() +", Descrição: " + getDescricao();
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void concluir() {
        this.concluido = true;
    }
}

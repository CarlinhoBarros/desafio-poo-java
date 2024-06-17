package br.com.dio.desafio.dominio;

import java.util.*;

public class Aluno {
    
    private Integer id;
    private String nome;
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    
    public Aluno(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudos.addAll(bootcamp.getConteudos());
        bootcamp.getAlunos().add(this);
    }

    public double calcularXpTotal(){
        double soma = 0;
        
        for (Conteudo item : conteudos) {
            if(item.getConcluido())
            soma += item.calcularXp();
        }
        
        return soma;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Conteudo> getConteudos() {
        return conteudos;
    }
    
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((conteudos == null) ? 0 : conteudos.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (conteudos == null) {
            if (other.conteudos != null)
                return false;
        } else if (!conteudos.equals(other.conteudos))
            return false;
        return true;
    }
}

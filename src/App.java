import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.dio.desafio.dominio.*;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno ana = new Aluno(1, "Ana");
        Aluno paulo = new Aluno(2, "Paulo");
        Aluno marcia = new Aluno(3, "Marcia");
        
        Conteudo java = new Curso("Curso Java", "Conceitos da linguagem Java", 60);
        Conteudo c = new Curso("Curso C", "Conceitos da linguagem C", 40);
        Conteudo python = new Curso("Curso Python", "Conceitos da linguagem python", 60);
        Conteudo javaScript = new Curso("Curso JavaScript", "Conceitos da linguagem JavaScript", 30);
        
        Conteudo mentoriaJava = new Mentoria("Mentoria Java", "Conceitos da linguagem Java", LocalDate.now());
        Conteudo mentoriaJavaScript = new Mentoria("Mentoria JavaScript", "Conceitos da linguagem Java", LocalDate.now());
        
        Bootcamp desktop = new Bootcamp("Desktop", 
                            "Conceitos de linguagens desktop", 
                            new LinkedHashSet<>(){{
                                add(c);
                                add(java);
                                add(mentoriaJava);
                            }});
        
        Bootcamp web = new Bootcamp("WEB", "Conceitos de linguagens WEB",
                            new LinkedHashSet<>(){{
                                add(java);
                                add(python);
                                add(javaScript);
                                add(mentoriaJava);
                                add(mentoriaJavaScript);
                            }});
        
        ana.inscreverBootcamp(desktop);
        System.out.println("Conteúdos Inscritos: ");
        ana.getConteudos().forEach(System.out::println);
        
        paulo.inscreverBootcamp(desktop);
        System.out.println("Paulo");
        System.out.println("Conteúdos Inscritos: ");
        paulo.getConteudos().forEach(System.out::println);
        
        System.out.println("\nConteúdos Concluídos: ");
        for (Conteudo item : paulo.getConteudos()) {
            if(item.equals(java) || item.equals(mentoriaJava))
                item.concluir();
        }

        for (Conteudo item : paulo.getConteudos()) {
            if(item.getConcluido())
                System.out.println(item);
        }        
        
        marcia.inscreverBootcamp(web);

        System.out.println("Alunos do bootcamp desktop: ");
        for (Aluno item : desktop.getAlunos()) {
            System.out.println(item.getNome());
        }
        
        
    }
}

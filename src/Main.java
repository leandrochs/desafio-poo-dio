import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nDigite uma opção: \n" +
                    "1 - Ver cursos \n" +
                    "2 - Ver Mentorias \n" +
                    "3 - Ver devs \n" +
                    "0 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    getCursos(bootcamp.getConteudos());
                    break;
                case 2:
                    getMentorias(bootcamp.getConteudos());
                    break;
                case 3:
                    System.out.println("escolheu 3");
                    break;
                case 0:
                    System.out.println("Good By!");
                    break;
                default:
                    System.out.println("Escolha inválida");
            }
        } while (option != 0);
    }

    public static void getCursos(Set conteudos) {
        System.out.println("\nOs cursos disponíveis são os seguintes:");
        for (Object conteudo : conteudos) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                System.out.println("Título: " + curso.getTitulo() +
                        "\nDescição: " + curso.getDescricao() +
                        "\nData: " + curso.getCargaHoraria() + "\n");
            }
        }
    }

    public static void getMentorias(Set conteudos) {
        System.out.println("\nAs Mentorias disponíveis são as seguintes:");
        for (Object conteudo : conteudos) {
            if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                System.out.println("Título: " + mentoria.getTitulo() +
                        "\nDescição: " + mentoria.getDescricao() +
                        "\nCarga Horária: " + mentoria.getData() + "\n");
            }
        }
    }
}

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final int OP_VER_CURSOS = 1;
    private static final int OP_VER_MENTORIAS = 2;
    private static final int OP_VER_DEVS = 3;
    private static final int OP_SAIR = 0;

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

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        int option = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n______________________________________________ \n" +
                        "\nDigite uma opção: \n" +
                        OP_VER_CURSOS + " - Ver cursos \n" +
                        OP_VER_MENTORIAS + " - Ver Mentorias \n" +
                        OP_VER_DEVS + " - Ver devs \n" +
                        OP_SAIR + " - Sair");

                option = scanner.nextInt();
                switch (option) {
                    case OP_VER_CURSOS:
                        processarOpcaoVerCursos(bootcamp.getConteudos());
                        break;
                    case OP_VER_MENTORIAS:
                        processarOpcaoVerMentorias(bootcamp.getConteudos());
                        break;
                    case OP_VER_DEVS:
                        processarOpcaoVerDevs(bootcamp.getDevsInscritos());
                        break;
                    case OP_SAIR:
                        processarOpcaoSair();
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
            }
        } while (option != OP_SAIR);
    }

    private static void processarOpcaoVerCursos(Set conteudos) {
        System.out.println("\nOs cursos disponíveis são os seguintes:");
        for (Object conteudo : conteudos) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                System.out.println("Título: " + curso.getTitulo() +
                        "\nDescição: " + curso.getDescricao() +
                        "\nCarga Horária: " + curso.getCargaHoraria() + "h\n");
            }
        }
    }

    public static void processarOpcaoVerMentorias(Set conteudos) {
        System.out.println("\nAs Mentorias disponíveis são as seguintes:");
        for (Object conteudo : conteudos) {
            if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                System.out.println("Título: " + mentoria.getTitulo() +
                        "\nDescição: " + mentoria.getDescricao() +
                        "\nData: " + mentoria.getData() + "\n");
            }
        }
    }

    public static void processarOpcaoVerDevs(Set<Dev> devsInscritos) {
        System.out.println("\nOs Devs inscritos são os seguintes:");
        for (Dev dev : devsInscritos) {
            System.out.println("Nome: " + dev.getNome() +
                    "\nConteúdos inscritos: " + getTitulos(dev.getConteudosInscritos()) +
                    "\nConteúdos concluídos: " + getTitulos(dev.getConteudosConcluidos()) +
                    "\nTotal XP: " + dev.calcularTotalXp() + "\n");
        }
    }

    public static void processarOpcaoSair() {
        System.out.println("Good By!");
    }

    public static String getTitulos(Set conteudos) {
        String message = "";
        for (Object conteudo : conteudos) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                message += curso.getTitulo() + ", ";
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                message += mentoria.getTitulo() + ", ";
            }
        }
        return (message.equals("")) ? "Nenhum conteúdo." : message.substring(0, message.length() - 2) + ".";
    }
}

package trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void main() {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int opcao;
        String nome;
        Integer idade;
        String cpf;
        String tel;
        String titulo;
        String id;
        String pesquisaUsuario;
        String pesquisaAluguelLivro;
        Usuario usuarioEncontrado;
        Livro livroEncontrado;

        do {

            System.out.println("[1] Cadastrar usuário");
            System.out.println("[2] Cadastrar livro");
            System.out.println("[3] Listar usuários");
            System.out.println("[4] Listar livros");
            System.out.println("[5] Realizar aluguel");
            System.out.println("[6] Realizar devolução");
            System.out.println("[7] Consultar se um livro está disponível");
            System.out.println("[8] Exibir livros alugados por um usuário");
            System.out.println("[0] Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o Enter que o nextInt deixa para trás

            switch (opcao) {

                case 1:
                    System.out.println("Nome:");
                    nome = scanner.nextLine();
                    System.out.println("Idade:");
                    idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("CPF:");
                    cpf = scanner.nextLine();
                    System.out.println("Telefone:");
                    tel = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(nome, idade, cpf, tel);
                    novoUsuario.cadastrarUsuario(usuarios);
                    break;

                case 2:
                    System.out.println("Título:");
                    titulo = scanner.nextLine();
                    System.out.println("ID:");
                    id = scanner.nextLine();

                    Livro novoLivro = new Livro(titulo, id);
                    novoLivro.cadastrarLivro(livros);
                    break;

                case 3:
                    Usuario.listarUsuarios(usuarios);
                    break;

                case 4:
                    Livro.listarLivro(livros);
                    break;

                case 5:
                    System.out.println("Digite o nome do usuário:");
                    pesquisaUsuario = scanner.nextLine();
                    usuarioEncontrado = Usuario.buscarUsuario(usuarios, pesquisaUsuario);

                    System.out.println("Digite o título do livro:");
                    pesquisaAluguelLivro = scanner.nextLine();
                    livroEncontrado = Livro.buscarLivro(livros, pesquisaAluguelLivro);

                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado!");
                    } else if (livroEncontrado == null) {
                        System.out.println("Livro não encontrado!");
                    } else {
                        usuarioEncontrado.realizarAluguel(livroEncontrado);
                    }
                    break;

                case 6:
                    System.out.println("Digite o nome do usuário:");
                    pesquisaUsuario = scanner.nextLine();
                    usuarioEncontrado = Usuario.buscarUsuario(usuarios, pesquisaUsuario);

                    System.out.println("Digite o título do livro:");
                    pesquisaAluguelLivro = scanner.nextLine();
                    livroEncontrado = Livro.buscarLivro(livros, pesquisaAluguelLivro);

                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado!");
                    } else if (livroEncontrado == null) {
                        System.out.println("Livro não encontrado!");
                    } else {
                        usuarioEncontrado.realizarDevolucao(livroEncontrado);
                    }
                    break;

                case 7:
                    System.out.println("Digite o título do livro:");
                    pesquisaAluguelLivro = scanner.nextLine();
                    livroEncontrado = Livro.buscarLivro(livros, pesquisaAluguelLivro);

                    if (livroEncontrado == null) {
                        System.out.println("Livro não encontrado!");
                    } else {
                        livroEncontrado.consultarDisponibilidade();
                    }
                    break;

                case 8:
                    System.out.println("Digite o nome do usuário:");
                    pesquisaUsuario = scanner.nextLine();
                    usuarioEncontrado = Usuario.buscarUsuario(usuarios, pesquisaUsuario);

                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado!");
                    } else {
                        usuarioEncontrado.exibirLivro();
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
            }
        } while (opcao != 0);
    }
}

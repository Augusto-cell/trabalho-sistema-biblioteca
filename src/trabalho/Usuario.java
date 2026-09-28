package trabalho;

import java.util.ArrayList;

public class Usuario {

    String nome;
    Integer idade;
    String cpf;
    String tel;
    ArrayList<Livro> livrosAlugados = new ArrayList<>();

    public Usuario(String nome, Integer idade, String cpf, String tel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.tel = tel;
    }

    void cadastrarUsuario(ArrayList<Usuario> usuarios) {
        usuarios.add(this);
        System.out.println("Usuário cadastrado: " + nome);
    }

    @Override
    public String toString() {
        return "Usuario - " +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nCPF: " + cpf +
                "\nTel: " + tel;
    }

    static void listarUsuarios(ArrayList<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        }
        for (Usuario listagemUsuarios : usuarios) {
            System.out.println(listagemUsuarios);
        }
    }

    static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String pesquisaUsuario) {
        for (Usuario listagemUsuarios : usuarios) {
            if (listagemUsuarios.nome.equalsIgnoreCase(pesquisaUsuario)) {
                return listagemUsuarios;
            }
        }
        return null;
    }

    void realizarAluguel(Livro livro) {
        if (livro.estaDisponivel()) {
            livro.dono = this;
            livrosAlugados.add(livro);
            System.out.println(nome + " alugou o livro: " + livro.titulo);
        } else {
            System.out.println("O livro " + livro.titulo + " não está disponível, está alugado para " + livro.dono.nome + ".");
        }
    }

    void realizarDevolucao(Livro livro) {
        if (livro.dono == this) {
            livro.dono = null;
            livrosAlugados.remove(livro);
            System.out.println(nome + " devolveu o livro: " + livro.titulo);
        } else {
            System.out.println(nome + " não está com o livro " + livro.titulo + " alugado.");
        }
    }

    void exibirLivro() {
        System.out.println("Livros alugados por " + nome + ":");
        if (livrosAlugados.isEmpty()) {
            System.out.println("Nenhum livro alugado.");
        }
        for (Livro listagemLivros : livrosAlugados) {
            System.out.println("- " + listagemLivros.titulo);
        }
    }
}


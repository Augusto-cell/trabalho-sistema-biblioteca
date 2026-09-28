package trabalho;

import java.util.ArrayList;

public class Livro {

    String titulo;
    String id;
    Usuario dono;

    public Livro(String titulo, String id) {
        this.titulo = titulo;
        this.id = id;
    }

    void cadastrarLivro(ArrayList<Livro> livros) {
        livros.add(this);
        System.out.println("Livro cadastrado: " + titulo);
    }

    @Override
    public String toString() {
        String disponibilidade;
        if (estaDisponivel()) {
            disponibilidade = "Disponível";
        } else {
            disponibilidade = "Alugado";
        }
        return "Livro - " + "\nTitulo: " + titulo + "\nID: " + id + "\nDiponibilidae: " + disponibilidade + "\n";
    }

    static void listarLivro(ArrayList<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }
        for (Livro listagemLivros : livros) {
            System.out.println(listagemLivros);
        }
    }

    static Livro buscarLivro(ArrayList<Livro> livros, String pesquisaAluguelLivro) {
        for (Livro listagemLivros : livros) {
            if (listagemLivros.titulo.equalsIgnoreCase(pesquisaAluguelLivro)) {
                return listagemLivros;
            }
        }
        return null;
    }

    boolean estaDisponivel() {
        return dono == null;
    }

    void consultarDisponibilidade() {
        if (estaDisponivel()) {
            System.out.println("O livro " + titulo + " está disponível.");
        } else {
            System.out.println("O livro " + titulo + " está alugado para " + dono.nome + ".");
        }
    }
}


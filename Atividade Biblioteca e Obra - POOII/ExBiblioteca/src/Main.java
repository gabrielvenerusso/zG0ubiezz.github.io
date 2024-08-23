import java.util.List;
import dao.*;
import entity.*;

public class Main {
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorDAO();
        LivroDAO livroDAO = new LivroDAO();

        autorDAO.criarTabelaAutor();
        livroDAO.criarTabelaLivro();
        // Inserir Autor
        Autor autor1 = new Autor(0, "Machado de Assis", "Brasileira");
        autorDAO.inserirAutor(autor1);

        // Inserir Livro
        Livro livro1 = new Livro(0, "Dom Casmurro", 1899, 1);
        livroDAO.inserirLivro(livro1);

        // Listar Autores
        List<Autor> autores = autorDAO.listarAutores();
        for (Autor autor : autores) {
            System.out.println("Autor: " + autor.getNome());
        }

        // Listar Livros por Autor
        List<Livro> livrosPorAutor = livroDAO.listarLivrosPorAutor(1);
        for (Livro livro : livrosPorAutor) {
            System.out.println("Livro: " + livro.getTitulo());
        }
    }
}
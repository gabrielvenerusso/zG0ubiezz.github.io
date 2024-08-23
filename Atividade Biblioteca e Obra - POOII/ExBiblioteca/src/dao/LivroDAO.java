package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.*;

public class LivroDAO extends BaseDAO{
    public void criarTabelaLivro() {
        String sql = "CREATE TABLE IF NOT EXISTS Livro (ID_Livro INTEGER PRIMARY KEY AUTOINCREMENT, Titulo VARCHAR(200), Ano_Publicacao INT, ID_Autor INT, FOREIGN KEY (ID_Autor) REFERENCES Autor(ID_Autor));";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inserirLivro(Livro livro) {
        String sql = "INSERT INTO Livro (Titulo, Ano_Publicacao, ID_Autor) VALUES (?, ?, ?)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setInt(3, livro.getIdAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE Livro SET Titulo = ?, Ano_Publicacao = ?, ID_Autor = ? WHERE ID_Livro = ?";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setInt(3, livro.getIdAutor());
            stmt.setInt(4, livro.getIdLivro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirLivro(int idLivro) {
        String sql = "DELETE FROM Livro WHERE ID_Livro = ?";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";
        try (Connection conn = con();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("ID_Livro"),
                        rs.getString("Titulo"),
                        rs.getInt("Ano_Publicacao"),
                        rs.getInt("ID_Autor")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public List<Livro> listarLivrosPorAutor(int idAutor) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro WHERE ID_Autor = ?";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                livros.add(new Livro(rs.getInt("ID_Livro"),
                        rs.getString("Titulo"),
                        rs.getInt("Ano_Publicacao"),
                        rs.getInt("ID_Autor")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }
}
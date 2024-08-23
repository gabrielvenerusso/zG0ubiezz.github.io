package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.*;

public class AutorDAO extends BaseDAO{
    public void criarTabelaAutor() {
        String sql = "CREATE TABLE IF NOT EXISTS Autor ( ID_Autor INT PRIMARY KEY AUTOINCREMENT, Nome VARCHAR(100), Nacionalidade VARCHAR(50))";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inserirAutor(Autor autor) {
        String sql = "INSERT INTO Autor (Nome, Nacionalidade) VALUES (?, ?)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAutor(Autor autor) {
        String sql = "UPDATE Autor SET Nome = ?, Nacionalidade = ? WHERE ID_Autor = ?";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setInt(3, autor.getIdAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirAutor(int idAutor) {
        String sql = "DELETE FROM Autor WHERE ID_Autor = ?";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        try (Connection conn = con();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autores.add(new Autor(rs.getInt("ID_Autor"),
                        rs.getString("Nome"),
                        rs.getString("Nacionalidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }
}

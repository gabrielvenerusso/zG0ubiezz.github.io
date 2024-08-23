package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO extends BaseDAO{
    private Connection conexao;

    public EngenheiroDAO() {
        try {
            this.conexao = con();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaEngenheiro() {
        String sql = "CREATE TABLE IF NOT EXISTS Engenheiro ( ID_Engenheiro INTEGER AUTOINCREMENT PRIMARY KEY, Nome_Engenheiro VARCHAR(255) NOT NULL, Especialidade VARCHAR(255) NOT NULL)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um novo engenheiro
    public void inserirEngenheiro(Engenheiro engenheiro) {
        String sql = "INSERT INTO Engenheiro (Nome_Engenheiro, Especialidade) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um engenheiro existente
    public void atualizarEngenheiro(Engenheiro engenheiro) {
        String sql = "UPDATE Engenheiro SET Nome_Engenheiro = ?, Especialidade = ? WHERE ID_Engenheiro = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.setInt(3, engenheiro.getIdEngenheiro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um engenheiro pelo ID
    public void excluirEngenheiro(int idEngenheiro) {
        String sql = "DELETE FROM Engenheiro WHERE ID_Engenheiro = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEngenheiro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os engenheiros
    public List<Engenheiro> listarEngenheiros() {
        String sql = "SELECT * FROM Engenheiro";
        List<Engenheiro> engenheiros = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Engenheiro engenheiro = new Engenheiro();
                engenheiro.setIdEngenheiro(rs.getInt("ID_Engenheiro"));
                engenheiro.setNomeEngenheiro(rs.getString("Nome_Engenheiro"));
                engenheiro.setEspecialidade(rs.getString("Especialidade"));
                engenheiros.add(engenheiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engenheiros;
    }

    // Método para buscar um engenheiro pelo ID
    public Engenheiro buscarEngenheiroPorId(int idEngenheiro) {
        String sql = "SELECT * FROM Engenheiro WHERE ID_Engenheiro = ?";
        Engenheiro engenheiro = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEngenheiro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                engenheiro = new Engenheiro();
                engenheiro.setIdEngenheiro(rs.getInt("ID_Engenheiro"));
                engenheiro.setNomeEngenheiro(rs.getString("Nome_Engenheiro"));
                engenheiro.setEspecialidade(rs.getString("Especialidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return engenheiro;
    }
}
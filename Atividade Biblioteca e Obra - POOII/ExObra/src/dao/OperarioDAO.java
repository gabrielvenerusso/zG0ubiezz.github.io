package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO extends BaseDAO {
    private Connection conexao;

    public OperarioDAO() {
        try {
            this.conexao = con();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaOperario() {
        String sql = "CREATE TABLE IF NOT EXISTS Operario (ID_Operario INTEGER AUTOINCREMENT PRIMARY KEY, Nome_Operario VARCHAR(255) NOT NULL, Funcao VARCHAR(255) NOT NULL)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um novo operário
    public void inserirOperario(Operario operario) {
        String sql = "INSERT INTO Operario (Nome_Operario, Funcao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um operário existente
    public void atualizarOperario(Operario operario) {
        String sql = "UPDATE Operario SET Nome_Operario = ?, Funcao = ? WHERE ID_Operario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, operario.getNomeOperario());
            stmt.setString(2, operario.getFuncao());
            stmt.setInt(3, operario.getIdOperario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um operário pelo ID
    public void excluirOperario(int idOperario) {
        String sql = "DELETE FROM Operario WHERE ID_Operario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idOperario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os operários
    public List<Operario> listarOperarios() {
        String sql = "SELECT * FROM Operario";
        List<Operario> operarios = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Operario operario = new Operario();
                operario.setIdOperario(rs.getInt("ID_Operario"));
                operario.setNomeOperario(rs.getString("Nome_Operario"));
                operario.setFuncao(rs.getString("Funcao"));
                operarios.add(operario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operarios;
    }

    // Método para buscar um operário pelo ID
    public Operario buscarOperarioPorId(int idOperario) {
        String sql = "SELECT * FROM Operario WHERE ID_Operario = ?";
        Operario operario = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idOperario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                operario = new Operario();
                operario.setIdOperario(rs.getInt("ID_Operario"));
                operario.setNomeOperario(rs.getString("Nome_Operario"));
                operario.setFuncao(rs.getString("Funcao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operario;
    }
}
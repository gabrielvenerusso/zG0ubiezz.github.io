package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO extends BaseDAO {
    private Connection conexao;

    public EquipamentoDAO() {
        try {
            this.conexao = con();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaEquipamento() {
        String sql = "CREATE TABLE IF NOT EXISTS Equipamento (ID_Equipamento INTEGER AUTOINCREMENT PRIMARY KEY,  Nome_Equipamento VARCHAR(255) NOT NULL, Tipo VARCHAR(255) NOT NULL)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para inserir um novo equipamento
    public void inserirEquipamento(Equipamento equipamento) {
        String sql = "INSERT INTO Equipamento (Nome_Equipamento, Tipo) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um equipamento existente
    public void atualizarEquipamento(Equipamento equipamento) {
        String sql = "UPDATE Equipamento SET Nome_Equipamento = ?, Tipo = ? WHERE ID_Equipamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.setInt(3, equipamento.getIdEquipamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um equipamento pelo ID
    public void excluirEquipamento(int idEquipamento) {
        String sql = "DELETE FROM Equipamento WHERE ID_Equipamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os equipamentos
    public List<Equipamento> listarEquipamentos() {
        String sql = "SELECT * FROM Equipamento";
        List<Equipamento> equipamentos = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setIdEquipamento(rs.getInt("ID_Equipamento"));
                equipamento.setNomeEquipamento(rs.getString("Nome_Equipamento"));
                equipamento.setTipo(rs.getString("Tipo"));
                equipamentos.add(equipamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

    // Método para buscar um equipamento pelo ID
    public Equipamento buscarEquipamentoPorId(int idEquipamento) {
        String sql = "SELECT * FROM Equipamento WHERE ID_Equipamento = ?";
        Equipamento equipamento = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                equipamento = new Equipamento();
                equipamento.setIdEquipamento(rs.getInt("ID_Equipamento"));
                equipamento.setNomeEquipamento(rs.getString("Nome_Equipamento"));
                equipamento.setTipo(rs.getString("Tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipamento;
    }
}
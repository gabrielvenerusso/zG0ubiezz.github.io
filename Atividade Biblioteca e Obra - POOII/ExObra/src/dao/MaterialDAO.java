package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO extends BaseDAO {
    private Connection conexao;


    public MaterialDAO() {
        try {
            this.conexao = con();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void criarTabelaMaterial() {
        String sql = "CREATE TABLE IF NOT EXISTS Material (ID_Material INTEGER AUTOINCREMENT PRIMARY KEY, Nome_Material VARCHAR(255) NOT NULL, Quantidade INT NOT NULL)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um novo material
    public void inserirMaterial(Material material) {
        String sql = "INSERT INTO Material (Nome_Material, Quantidade) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, material.getNomeMaterial());
            stmt.setInt(2, material.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um material existente
    public void atualizarMaterial(Material material) {
        String sql = "UPDATE Material SET Nome_Material = ?, Quantidade = ? WHERE ID_Material = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, material.getNomeMaterial());
            stmt.setInt(2, material.getQuantidade());
            stmt.setInt(3, material.getIdMaterial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um material pelo ID
    public void excluirMaterial(int idMaterial) {
        String sql = "DELETE FROM Material WHERE ID_Material = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os materiais
    public List<Material> listarMateriais() {
        String sql = "SELECT * FROM Material";
        List<Material> materiais = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Material material = new Material();
                material.setIdMaterial(rs.getInt("ID_Material"));
                material.setNomeMaterial(rs.getString("Nome_Material"));
                material.setQuantidade(rs.getInt("Quantidade"));
                materiais.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiais;
    }

    // Método para buscar um material pelo ID
    public Material buscarMaterialPorId(int idMaterial) {
        String sql = "SELECT * FROM Material WHERE ID_Material = ?";
        Material material = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                material = new Material();
                material.setIdMaterial(rs.getInt("ID_Material"));
                material.setNomeMaterial(rs.getString("Nome_Material"));
                material.setQuantidade(rs.getInt("Quantidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }
}
package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO extends BaseDAO {
    private Connection conexao;

    public ProjetoDAO() {
        try {
            this.conexao = con();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaProjeto() {
        String sql = "CREATE TABLE IF NOT EXISTS Projeto (ID_Projeto INTEGER AUTOINCREMENT PRIMARY KEY, Nome_Projeto VARCHAR(255) NOT NULL, Local VARCHAR(255) NOT NULL, Data_Inicio DATE NOT NULL, Data_Termino DATE NOT NULL)";
        try (Connection conn = con();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um novo projeto
    public void inserirProjeto(Projeto projeto) {
        String sql = "INSERT INTO Projeto (Nome_Projeto, Local, Data_Inicio, Data_Termino) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setString(3, projeto.getDataInicio());
            stmt.setString(4, projeto.getDataTermino());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um projeto existente
    public void atualizarProjeto(Projeto projeto) {
        String sql = "UPDATE Projeto SET Nome_Projeto = ?, Local = ?, Data_Inicio = ?, Data_Termino = ? WHERE ID_Projeto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setString(3, projeto.getDataInicio());
            stmt.setString(4, projeto.getDataTermino());
            stmt.setInt(5, projeto.getIdProjeto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um projeto pelo ID
    public void excluirProjeto(int idProjeto) {
        String sql = "DELETE FROM Projeto WHERE ID_Projeto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os projetos
    public List<Projeto> listarProjetos() {
        String sql = "SELECT * FROM Projeto";
        List<Projeto> projetos = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setIdProjeto(rs.getInt("ID_Projeto"));
                projeto.setNomeProjeto(rs.getString("Nome_Projeto"));
                projeto.setLocal(rs.getString("Local"));
                projeto.setDataInicio(rs.getString("Data_Inicio"));
                projeto.setDataTermino(rs.getString("Data_Termino"));
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    // Método para buscar um projeto pelo ID
    public Projeto buscarProjetoPorId(int idProjeto) {
        String sql = "SELECT * FROM Projeto WHERE ID_Projeto = ?";
        Projeto projeto = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                projeto = new Projeto();
                projeto.setIdProjeto(rs.getInt("ID_Projeto"));
                projeto.setNomeProjeto(rs.getString("Nome_Projeto"));
                projeto.setLocal(rs.getString("Local"));
                projeto.setDataInicio(rs.getString("Data_Inicio"));
                projeto.setDataTermino(rs.getString("Data_Termino"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projeto;
    }
}
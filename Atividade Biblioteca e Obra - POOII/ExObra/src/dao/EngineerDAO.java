package dao;

import model.Engineer;
import model.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineerDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists engineer(id_engineer integer primary key autoincrement, name varchar(255), specialty varchar(255));
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Engineer engineer) {
        String sql = """
                insert into engineer(name, specialty) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, engineer.getName());
            pre.setString(2, engineer.getSpecialty());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Engineer engineer) {
        String sql = """
                update engineer set name = ? where id_engineer = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, engineer.getName());
            pre.setInt(2, engineer.getId_engineer());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Engineer engineer) {
        String sql = """
                delete from engineer where id_engineer = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, engineer.getId_engineer());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Engineer> getAll() {
        List<Engineer> list = new ArrayList<>();
        String sql = """
                select * from engineer;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Engineer engineer = new Engineer();
                engineer.setId_engineer(rs.getInt("id_engineer"));
                engineer.setName(rs.getString("name"));
                engineer.setSpecialty(rs.getString("specialty"));
                list.add(engineer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Engineer> engineersPerProject(Project project) throws SQLException {
        List<Engineer> list = new ArrayList<>();
        String sql = """
                select e.* from engineer e join engineer_allocation ea on e.id_engineer = ea.id_engineer where ea.id_project = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            pre.setInt(1, project.getId_project());
            try (ResultSet rs2 = pre.executeQuery()) {
                while (rs2.next()) {
                    Engineer engineer = new Engineer();
                    engineer.setId_engineer(rs.getInt("id_engineer"));
                    engineer.setName(rs.getString("name"));
                    engineer.setSpecialty(rs.getString("specialty"));
                    list.add(engineer);
                }
            }
        }
        return list;
    }
}

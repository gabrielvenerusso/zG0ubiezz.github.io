package dao;

import model.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists project(id_project integer primary key autoincrement, name varchar(255), location varchar(255), start_date date, end_date date);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Project project) {
        String sql = """
                insert into project(name, location, start_date, end_date) values(?, ?, ?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pre.setString(1, project.getName());
            pre.setString(2, project.getLocation());
            pre.setDate(3, java.sql.Date.valueOf(project.getStart_date()));
            pre.setDate(4, java.sql.Date.valueOf(project.getEnd_date()));
            pre.execute();
            ResultSet rs = pre.getGeneratedKeys();
            if (rs.next()) {
                project.setId_project(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql2 = """
                insert into engineer_allocation(id_project, id_engineer) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql2)) {
            for (var engineer : project.getEngineers()) {
                pre.setInt(1, project.getId_project());
                pre.setInt(2, engineer.getId_engineer());
                pre.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql3 = """
                insert into use_equipment(id_project, id_equipment) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql3)) {
            for (var equipment : project.getEquipment()) {
                pre.setInt(1, project.getId_project());
                pre.setInt(2, equipment.getId_equipment());
                pre.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql4 = """
                insert into material_consumption(id_project, id_material) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql4)) {
            for (var material : project.getMaterials()) {
                pre.setInt(1, project.getId_project());
                pre.setInt(2, material.getId_material());
                pre.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql5 = """
                insert into worker_allocation(id_project, id_worker) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql5)) {
            for (var worker : project.getWorkers()) {
                pre.setInt(1, project.getId_project());
                pre.setInt(2, worker.getId_worker());
                pre.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Project project) {
        String sql = """
                update project set name = ? where id_project = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, project.getId_project());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Project project) {
        String sql = """
                delete from project where id_project = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, project.getId_project());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> getAll() {
        List<Project> list = new ArrayList<>();
        String sql = """
                select * from project;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Project project = new Project();
                project.setId_project(rs.getInt("id_project"));
                project.setName(rs.getString("name"));
                project.setLocation(rs.getString("location"));
                project.setStart_date(rs.getDate("start_date").toLocalDate().toString());
                project.setEnd_date(rs.getDate("end_date").toLocalDate().toString());
                list.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

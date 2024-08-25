package dao;

import model.Equipment;
import model.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists equipment(id_equipment integer primary key autoincrement, name varchar(255), type varchar(255));
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Equipment equipment) {
        String sql = """
                insert into equipment(name, type) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, equipment.getName());
            pre.setString(2, equipment.getType());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Equipment equipment) {
        String sql = """
                update equipment set name = ? where id_equipment = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, equipment.getName());
            pre.setInt(2, equipment.getId_equipment());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Equipment equipment) {
        String sql = """
                delete from equipment where id_equipment = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, equipment.getId_equipment());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipment> getAll() {
        List<Equipment> list = new ArrayList<>();
        String sql = """
                select * from equipment;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Equipment equipment = new Equipment();
                equipment.setId_equipment(rs.getInt("id_equipment"));
                equipment.setName(rs.getString("name"));
                equipment.setType(rs.getString("type"));
                list.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Equipment> equipmentPerProject(Project project) throws SQLException {
        List<Equipment> list = new ArrayList<>();
        String sql = """
                select e.* from equipment e join use_equipment ue on e.id_equipment = ue.id_equipment where ue.id_project = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            pre.setInt(1, project.getId_project());
            try (ResultSet rs2 = pre.executeQuery()) {
                while (rs2.next()) {
                    Equipment equipment = new Equipment();
                    equipment.setId_equipment(rs.getInt("id_equipment"));
                    equipment.setName(rs.getString("name"));
                    equipment.setType(rs.getString("type"));
                    list.add(equipment);
                }
            }
        }
        return list;
    }
}

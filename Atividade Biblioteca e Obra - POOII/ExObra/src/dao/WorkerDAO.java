package dao;

import model.Project;
import model.Worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists worker(id_worker integer primary key autoincrement, name varchar(255), function varchar(255));
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Worker worker) {
        String sql = """
                insert into worker(name, function) values (?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, worker.getName());
            pre.setString(2, worker.getFunction());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Worker worker) {
        String sql = """
                update worker set name where id_worker = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, worker.getId_worker());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Worker worker) {
        String sql = """
                delete from worker where id_worker = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, worker.getId_worker());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Worker> getAll() {
        List<Worker> list = new ArrayList<>();
        String sql = """
                select * from worker;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId_worker(rs.getInt("id_worker"));
                worker.setName(rs.getString("name"));
                worker.setFunction(rs.getString("function"));
                list.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Worker> workersPerProject(Project project) throws SQLException {
        List<Worker> list = new ArrayList<>();
        String sql = """
                select w.* from worker w join worker_allocation wa on w.id_worker = wa.id_Worker where wa.id_project = ?
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            pre.setInt(1, project.getId_project());
            try (ResultSet rs2 = pre.executeQuery()) {
                while (rs2.next()) {
                    Worker worker = new Worker();
                    worker.setId_worker(rs.getInt("id_worker"));
                    worker.setName(rs.getString("name"));
                    worker.setFunction(rs.getString("function"));
                    list.add(worker);
                }
            }
        }
        return list;
    }
}

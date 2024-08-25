import dao.*;
import model.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Engineer engineer = new Engineer("Chris", "Civil");
        Equipment equipment = new Equipment("Concrete Mixer", "Construction");
        Material material = new Material("Concrete", 50);
        Project project = new Project("Big Tower", "New York", "2024-08-22", "2024-08-30");
        Worker worker = new Worker("John", "Put Glass");

        EngineerDAO engineerDAO = new EngineerDAO();
        engineerDAO.create();
        engineerDAO.insert(engineer);
        engineerDAO.update(engineer);
        engineerDAO.delete(engineer);
        for(var a : engineerDAO.getAll()) {
            System.out.println(a);
        }
        project.setId_project(2);
        for(var a : engineerDAO.engineersPerProject(project)) {
            System.out.println(a);
        }

        EquipmentDAO equipmentDAO = new EquipmentDAO();
        equipmentDAO.create();
        equipmentDAO.insert(equipment);
        equipmentDAO.update(equipment);
        equipmentDAO.delete(equipment);
        for(var a : equipmentDAO.getAll()) {
            System.out.println(a);
        }
        project.setId_project(2);
        for(var a : equipmentDAO.equipmentPerProject(project)) {
            System.out.println(a);
        }

        MaterialDAO materialDAO = new MaterialDAO();
        materialDAO.create();
        materialDAO.insert(material);
        materialDAO.update(material);
        materialDAO.delete(material);
        for(var a : materialDAO.getAll()) {
            System.out.println(a);
        }
        project.setId_project(2);
        for(var a : materialDAO.materialsPerProject(project)) {
            System.out.println(a);
        }

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.create();
        engineer.setId_engineer(1);
        project.getEngineers().add(engineer);
        equipment.setId_equipment(1);
        project.getEquipment().add(equipment);
        material.setId_material(1);
        project.getMaterials().add(material);
        worker.setId_worker(1);
        project.getWorkers().add(worker);
        projectDAO.insert(project);
        projectDAO.update(project);
        projectDAO.delete(project);
        for(var a : projectDAO.getAll()) {
            System.out.println(a);
        }

        WorkerDAO workerDAO = new WorkerDAO();
        workerDAO.create();
        workerDAO.insert(worker);
        workerDAO.update(worker);
        workerDAO.delete(worker);
        for(var a : workerDAO.getAll()) {
            System.out.println(a);
        }
        project.setId_project(2);
        for(var a : workerDAO.workersPerProject(project)) {
            System.out.println(a);
        }
    }
}

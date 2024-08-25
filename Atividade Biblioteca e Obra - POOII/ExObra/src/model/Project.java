package model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id_project;
    private String name;
    private String location;
    private String start_date;
    private String end_date;
    private List<Engineer> engineers = new ArrayList<>();
    private List<Equipment> equipment = new ArrayList<>();
    private List<Material> materials = new ArrayList<>();
    private List<model.Worker> workers = new ArrayList<>();

    public Project(String name, String location, String start_date, String end_date) {
        this.name = name;
        this.location = location;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Project() {

    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<Engineer> engineers) {
        this.engineers = engineers;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<model.Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<model.Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Project {" +
                "id_project = " + id_project +
                ", name = '" + name + "\'" +
                ", location = '" + location + "\'" +
                ", start_date = '" + start_date + "\'" +
                ", end_date = '" + end_date + "\'" +
                "}";
    }
}

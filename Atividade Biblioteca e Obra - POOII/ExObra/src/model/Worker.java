package model;

public class Worker {
    private int id_worker;
    private String name;
    private String function;

    public Worker(String name, String function) {
        this.name = name;
        this.function = function;
    }

    public Worker() {

    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Worker {" +
                "id_worker = " + id_worker +
                ", name = '" + name + "\'" +
                ", function = '" + function + "\'" +
                "}";
    }
}

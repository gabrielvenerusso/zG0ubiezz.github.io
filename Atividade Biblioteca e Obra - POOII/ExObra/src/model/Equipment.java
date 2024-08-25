package model;

public class Equipment {
    private int id_equipment;
    private String name;
    private String type;

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Equipment() {

    }

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Equipment {" +
                "id_equipment = " + id_equipment +
                ", name = '" + name + "\'" +
                ", type = '" + type + "\'" +
                "}";
    }
}

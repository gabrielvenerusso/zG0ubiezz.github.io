package model;

public class Material {
    private int id_material;
    private String name;
    private int quantity;

    public Material(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Material() {

    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Material {" +
                "id_material = " + id_material +
                ", name = '" + name + "\'" +
                ", quantity = " + quantity +
                "}";
    }
}

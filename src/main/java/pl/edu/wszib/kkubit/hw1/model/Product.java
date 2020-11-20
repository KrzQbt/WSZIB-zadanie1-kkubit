package pl.edu.wszib.kkubit.hw1.model;

public class Product {
    private String name;

    private String description;
    private int quantity;
    private int id;
    static int idCounter = 0; //idCounter increments everytime entity is created and is used to calc next id

    public Product(String name,String description) {
        this.name = name;
        this.description = description;

        idCounter++;
        this.id = idCounter;
        this.quantity=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }



    public int getId() {
        return id;
    }


    public static int getIdCounter() {
        return idCounter;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}
package org.example.models;

public class Aircraft {

    private final Long id;
    private String model;
    private int capacity;

    public Aircraft(Long id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public Long getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "Aircraft{" +
                "id=" + this.id +
                ", model='" + this.model + '\'' +
                ", capacity=" + this.capacity +
                '}';
    }
}

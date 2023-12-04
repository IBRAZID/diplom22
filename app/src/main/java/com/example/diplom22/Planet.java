package com.example.diplom22;

public class Planet {
    private String name;
    private String size;
    private String galaxy;
    private String description;

    public Planet() {
    }

    public Planet(String name, String size, String galaxy, String habitable) {
        this.name = name;
        this.size = size;
        this.galaxy = galaxy;
        this.description = habitable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String habitable) {
        this.description = habitable;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", galaxy='" + galaxy + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

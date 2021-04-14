package com.example.locationapp.model;

import java.io.Serializable;

public class Location implements Serializable {
    private int id;
    private String name;
    private String imageSource;
    private String description;
    private Double lat;
    private Double _long;

    public Location(int id, String name, String imageSource, String description, Double lat, Double _long) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.description = description;
        this.lat = lat;
        this._long = _long;
    }

    public Location(int id, String name, String imageSource, String description) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public Double get_long() {
        return _long;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

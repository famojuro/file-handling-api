package com.innovativeapps.filehandling.pojo;

import java.io.Serializable;
import java.util.Objects;

public class AppStudent implements Serializable {
    private int id;
    private String name;
    private String city;
    private String image;

    public AppStudent() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == o || o.getClass() != getClass()) return false;
        AppStudent appStudent = (AppStudent) o;
        return Objects.equals(id, appStudent.id) &&
                Objects.equals(name, appStudent.name) &&
                Objects.equals(city, appStudent.city) &&
                Objects.equals(image, appStudent.image);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, city, image); }
}

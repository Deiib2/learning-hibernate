package com.adham.hibernate;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int alien_id;
    private String name;
    private String tech;
    @OneToMany //(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getAlien_id() {
        return alien_id;
    }

    public void setAlien_id(int alien_id) {
        this.alien_id = alien_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alien_id=" + alien_id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}

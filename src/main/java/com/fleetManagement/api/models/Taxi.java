package com.fleetManagement.api.models;
// com.fleetManagement.api.models.Taxi.java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name="taxis")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Taxi {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String plate;
    public Taxi() {
    }

    public Taxi(Integer id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                '}';
    }
}

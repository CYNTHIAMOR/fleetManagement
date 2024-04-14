package com.fleetManagement.api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LastTrajectory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxi_id")
    private Taxi taxi;

    private LocalDateTime date;
    private Double latitude;
    private Double longitude;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LastTrajectory{" +
                "id=" + id +
                ", taxi=" + taxi +
                ", date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

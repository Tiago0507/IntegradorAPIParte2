package com.example.integradorapiparte2.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Readings readings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }
}

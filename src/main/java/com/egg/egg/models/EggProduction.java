package com.egg.egg.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

// Definisikan Entitas
public class EggProduction {
    @Id
    @Column(name = "egg_production_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eggProductionid;

    private LocalDate date;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_egg")
    private double pricePerEgg;

    @PrePersist
    public void onCreate() {
        this.date = LocalDate.now();
    }

}

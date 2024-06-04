package com.egg.egg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.egg.models.EggProduction;

// Definisikan repository sebagai penghubung Logic dengan db
public interface EggProductionRepository extends JpaRepository<EggProduction, Long> {
    
}

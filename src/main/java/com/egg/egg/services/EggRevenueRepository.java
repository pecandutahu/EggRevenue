package com.egg.egg.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.egg.models.EggProduction;
import com.egg.egg.repositories.EggProductionRepository;

@Service
// Definisiklan Service untuk revenue
public class EggRevenueRepository {
    @Autowired
    EggProductionRepository eggProductionRepository;

    public double calculateTotalRevenue() {
        List<EggProduction> productions = eggProductionRepository.findAll();
        // kembalikan nilai revenue
        // revenue adalah semua total price
        return productions.stream()
                .mapToDouble(prod -> prod.getQuantity() * prod.getPricePerEgg())
                .sum();
    }
}

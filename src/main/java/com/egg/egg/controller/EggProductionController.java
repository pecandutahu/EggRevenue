package com.egg.egg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.egg.models.EggProduction;
import com.egg.egg.services.EggProductionService;
import com.egg.egg.services.EggRevenueRepository;

@RestController
@RequestMapping("/egg")

// Definisikan Controller sebagai penghubung antara request user dengan service logic yang disediakan
public class EggProductionController {
    @Autowired
    private EggProductionService eggProductionService;

    @Autowired 
    private EggRevenueRepository eggRevenueRepository;

    @PostMapping
    public EggProduction creaEggProduction(@RequestBody EggProduction eggProduction) {
        return eggProductionService.savEggProduction(eggProduction);
    }

    @GetMapping
    public List<EggProduction> getAllEggProductions() {
        return eggProductionService.getAllEggProductions();
    }

    @GetMapping("/{id}")
    public EggProduction getEggProductionById(@PathVariable Long id) {
        return eggProductionService.getEggProductionById(id);
    }

    @GetMapping("/revenue")

    public ResponseEntity<String> getTotalRevenue() {
        double totalRevenue = eggRevenueRepository.calculateTotalRevenue();
        return new ResponseEntity<>("Total Revenue: " + totalRevenue, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEggProduction(@PathVariable Long id) {
        eggProductionService.deleteEggProduction(id);
        return new ResponseEntity<>("Data Berhasil dihapus.", HttpStatus.OK );
    }
}

package com.egg.egg.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.egg.models.EggProduction;
import com.egg.egg.repositories.EggProductionRepository;

@Service
public class EggProductionService {
    @Autowired
    EggProductionRepository eggProductionRepository;

    public EggProduction savEggProduction(EggProduction eggProduction) {
        return eggProductionRepository.save(eggProduction);
    }

    public List<EggProduction> getAllEggProductions() {
        return eggProductionRepository.findAll();
    }

    public EggProduction getEggProductionById(Long id) {
        return eggProductionRepository.findById(id).orElse(null);
    }

    public void deleteEggProduction(Long id) {
        eggProductionRepository.deleteById(id);
    }

}

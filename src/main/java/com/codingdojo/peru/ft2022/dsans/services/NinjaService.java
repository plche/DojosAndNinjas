package com.codingdojo.peru.ft2022.dsans.services;

import com.codingdojo.peru.ft2022.dsans.models.Ninja;
import com.codingdojo.peru.ft2022.dsans.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public Ninja findNinjaById(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) return optionalNinja.get();
        else return null;
    }
}

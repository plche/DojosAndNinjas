package com.codingdojo.peru.ft2022.dsans.repositories;

import com.codingdojo.peru.ft2022.dsans.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}

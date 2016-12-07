package com.example.controller;

import com.example.domain.Medalla;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medallas")
public class MedallaController {
    @Autowired
    private MedallaRepository medallaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medalla createMedalla(@RequestBody Medalla medalla){
        return medallaRepository.save(medalla);
    }

    @GetMapping
    public List<Medalla> getAllMedallas(){
        return medallaRepository.findAll();
    }

    @PutMapping
    public Medalla updateMedalla(@RequestBody Medalla medalla){
        return medallaRepository.save(medalla);
    }

    @DeleteMapping("/{id}")
    public void deleteMedallaID(@PathVariable Long id){
        Medalla medalla = medallaRepository.findOne(id);
        if(medalla != null ) medallaRepository.delete(id);
    }
}

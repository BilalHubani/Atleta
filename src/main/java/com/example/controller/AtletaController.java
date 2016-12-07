package com.example.controller;

import com.example.domain.Atleta;
import com.example.domain.TipoMedalla;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


@RestController
@RequestMapping("/atletas")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> getAllAtletas(){
        return atletaRepository.findAll();
    }

    @PutMapping
    public Atleta updateAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @DeleteMapping("/{id}")
    public void deleteAtletaID(@PathVariable Long id){
        Atleta atleta = atletaRepository.findOne(id);
        if(atleta != null ) atletaRepository.delete(id);
    }


    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atleta>> getAtletaGroupByNacionalidad(){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }

    @GetMapping("/GroupByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> getAtletaGroupByTipoMedalla(){

        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(atleta -> {
                    if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.ORO)){
                        return TipoMedalla.ORO;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.PLATA)){
                        return TipoMedalla.PLATA;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.BRONCE)){
                        return TipoMedalla.BRONCE;
                    }else {
                        return TipoMedalla.NADA;
                    }
                }));
    }



}

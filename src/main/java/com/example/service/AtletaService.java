package com.example.service;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;

    public void createAtleta(){
        Atleta atleta1 = new Atleta("Huni", "HoloHolo", "Luna", LocalDate.of(1962, 8, 1));
        atletaRepository.save(atleta1);
        Atleta atleta2 = new Atleta("Peanut", "Cacahuete", "Selva", LocalDate.of( 1963, 3, 1));
        atletaRepository.save(atleta2);
        Atleta atleta3 = new Atleta("Faker", "Dios", "Cielo", LocalDate.of( 1941, 3, 1));
        atletaRepository.save(atleta3);
        Atleta atleta4 = new Atleta("Bang", "Bala", "Ferrica", LocalDate.of(1965,5,1));
        atletaRepository.save(atleta4);
        Atleta atleta5 = new Atleta("Wolf", "Wolfie", "Bosque", LocalDate.of( 1964, 4, 1));
        atletaRepository.save(atleta5);

    }
    public void testAtleta(){
        System.out.println(atletaRepository.findByNacionalidadIs("Luna"));
        System.out.println(atletaRepository.findByFechaNacimientoBefore(LocalDate.of(1963, 12, 1)));
    }
}

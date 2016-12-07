package com.example.service;

import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedallaService {
    @Autowired
    private MedallaRepository medallaRepository;
    @Autowired
    private AtletaRepository atletaRepository;

    public void createMedalla(){
        Medalla medalla1 = new Medalla(TipoMedalla.ORO, "Best Mid Laner", "All Stars 2015");
        medalla1.setAtleta(atletaRepository.findByNombreIs("Faker"));
        medallaRepository.save(medalla1);
        Medalla medalla2= new Medalla(TipoMedalla.ORO, "Best Top Laner", "LCS 2015");
        medalla2.setAtleta(atletaRepository.findByNombreIs("Huni"));
        medallaRepository.save(medalla2);
        Medalla medalla3 = new Medalla(TipoMedalla.PLATA, "Best Mid Laner", "All Stars 2015");
        medalla3.setAtleta(atletaRepository.findByNombreIs("Peanut"));
        medallaRepository.save(medalla3);
        Medalla medalla4 = new Medalla(TipoMedalla.PLATA, "Best Top Laner", "LCS 2015");
        medalla4.setAtleta(atletaRepository.findByNombreIs("Bang"));
        medallaRepository.save(medalla4);
        Medalla medalla5 = new Medalla(TipoMedalla.BRONCE, "Best Mid Laner", "All Stars 2015");
        medalla5.setAtleta(atletaRepository.findByNombreIs("Wolf"));
        medallaRepository.save(medalla5);
        Medalla medalla6 = new Medalla(TipoMedalla.BRONCE, "Best Top Laner", "LCS 2015");
        medalla6.setAtleta(atletaRepository.findByNombreIs("Bang"));
        medallaRepository.save(medalla6);
    }
    public void testMedalla(){

    }
}

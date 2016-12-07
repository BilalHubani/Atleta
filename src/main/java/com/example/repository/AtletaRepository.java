package com.example.repository;

import com.example.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long>{
        List<Atleta> findByNacionalidadIs(String nacionalidad);
        List<Atleta> findByFechaNacimientoBefore(LocalDate fechaNacimiento);
        Atleta findByNombreIs(String nombre);
}

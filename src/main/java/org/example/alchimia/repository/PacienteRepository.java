package org.example.alchimia.repository;

import org.example.alchimia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByNome(String nome);
    Paciente findPatientByCpf(String CPF);

    Paciente findByCodigo(Long codigo);

    @Query("SELECT MAX(p.codigo) FROM Paciente p")
    String findMaxCodigo();
}

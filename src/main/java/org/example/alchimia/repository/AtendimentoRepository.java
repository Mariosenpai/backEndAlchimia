package org.example.alchimia.repository;

import org.example.alchimia.entity.Atendimento;
import org.example.alchimia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento,Long> {

    List<Atendimento> findAllByPaciente(Paciente paciente);

    @Query("SELECT MAX(p.codigo) FROM Paciente p")
    Long findMaxCodigo();

}

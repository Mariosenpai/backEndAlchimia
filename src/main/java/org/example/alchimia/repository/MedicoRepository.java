package org.example.alchimia.repository;

import org.example.alchimia.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    public Medico findMedicoByCrm(int id);

    public List<Medico> findMedicoByInativo(int inativo);

    List<Medico> findMedicoByEspecialidadeCodigoAndInativo(Integer especialidade, Integer inativo);
}

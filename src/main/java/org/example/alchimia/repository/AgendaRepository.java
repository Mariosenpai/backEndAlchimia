package org.example.alchimia.repository;

import org.example.alchimia.entity.Agenda;
import org.example.alchimia.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository< Agenda,Integer> {

    List<Agenda> findAllByInativoAndEspecialidade(Integer inativo ,Especialidade especialidade);

    List<Agenda> findAllByInativo(Integer inativo);

}

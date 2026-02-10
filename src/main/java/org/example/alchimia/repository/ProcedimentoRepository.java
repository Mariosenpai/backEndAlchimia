package org.example.alchimia.repository;

import org.example.alchimia.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {

    List<Procedimento> findProcedimentoByInativo(int inativo);
}

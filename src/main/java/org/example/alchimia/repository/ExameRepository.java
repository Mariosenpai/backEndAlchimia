package org.example.alchimia.repository;

import org.example.alchimia.entity.Exame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

    public Page<Exame> findByPriRealizante(Integer id, PageRequest page);

    public List<Exame> findExameByDataAndPriRealizanteCrmAndCancelado(LocalDate data ,int crm, int cancelado);

}

package org.example.alchimia.repository;

import io.swagger.models.auth.In;
import org.example.alchimia.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

    List<Especialidade> findEspecialidadeBySetorId(int setor_id);
}

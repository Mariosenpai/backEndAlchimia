package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.entity.Especialidade;
import org.example.alchimia.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecilidadeService {

    private final EspecialidadeRepository especialidadeRepository;


}

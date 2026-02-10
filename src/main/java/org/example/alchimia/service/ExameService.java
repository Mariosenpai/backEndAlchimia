package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.entity.Exame;
import org.example.alchimia.repository.ExameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository exameRepository;

    public Page<Exame> findAll(PageRequest pageRequest){
        return exameRepository.findAll(pageRequest);
    }

    public Page<Exame> findExamesMedico(int idMedico, PageRequest page){
        return exameRepository.findByPriRealizante(idMedico, page);
    }

}

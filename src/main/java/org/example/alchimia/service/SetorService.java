package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.entity.Setor;
import org.example.alchimia.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;


    public List<Setor> findAll(){
        return setorRepository.findAll();
    }

}

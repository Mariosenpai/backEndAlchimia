package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.entity.Agenda;
import org.example.alchimia.entity.Especialidade;
import org.example.alchimia.entity.Medico;
import org.example.alchimia.repository.AgendaRepository;
import org.example.alchimia.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public Agenda findById(int id){
        return agendaRepository.findById(id).get();
    }

    public List<Agenda> findAll(){
        return agendaRepository.findAllByInativo(1);
    }

    public List<Agenda> findByEspecialidade(int idEspecialidade){
        Especialidade especialidade = especialidadeRepository.findById(idEspecialidade).get();
        return agendaRepository.findAllByInativoAndEspecialidade(1,especialidade);

    }



}

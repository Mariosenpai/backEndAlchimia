package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.Procedure;
import org.example.alchimia.entity.Procedimento;
import org.example.alchimia.repository.ProcedimentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;


    public Procedimento findById(int id){
        return procedimentoRepository.getReferenceById(id);
    }

    public List<Procedure> findAll(){
        List<Procedimento> procedimentoList = procedimentoRepository.findProcedimentoByInativo(0);
        return fillProcedure(procedimentoList);
    }



    private List<Procedure> fillProcedure(List<Procedimento> procedimentoList){
        List<Procedure> finalList = new ArrayList<>();
        for(Procedimento procedimento: procedimentoList){

            Procedure procedure = new Procedure();
            procedure.setCode(procedimento.getCodigo());
            procedure.setName(procedimento.getNome());

            finalList.add(procedure);

        }

        return finalList;
    }

}

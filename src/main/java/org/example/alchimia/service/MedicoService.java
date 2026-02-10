package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.Doctor;
import org.example.alchimia.entity.Medico;
import org.example.alchimia.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Medico findbyCRMMedico(int id){
        return medicoRepository.findMedicoByCrm(id);
    }

    public List<Doctor> findbyActiveMedico(){
        List<Medico> listMedicos = medicoRepository.findMedicoByInativo(0);
        return fillDoctor(listMedicos);
    }

    public List<Doctor> findbyEspecialidadeMedico(String idEspecialidade){
        List<Medico> listMedicos =  medicoRepository.findMedicoByEspecialidadeAndInativo(idEspecialidade, 0);
        return fillDoctor(listMedicos);
    }

    private List<Doctor> fillDoctor(List<Medico> list){
        List<Doctor> listFinal = new ArrayList<>();

        for (Medico medico : list){
            Doctor doctor = new Doctor();
            doctor.setName(medico.getNome());
            doctor.setCrmId(medico.getCrm());
            doctor.setSpecialty(medico.getEspecialidade());

            listFinal.add(doctor);
        }
        return listFinal;
    }


}

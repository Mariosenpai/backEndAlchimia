package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.Doctor;
import org.example.alchimia.entity.Especialidade;
import org.example.alchimia.entity.Medico;
import org.example.alchimia.repository.EspecialidadeRepository;
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
    private final EspecialidadeRepository especialidadeRepository;

    public Medico findbyCRMMedico(int id){
        return medicoRepository.findMedicoByCrm(id);
    }

    public List<Doctor> findbyActiveMedico(){
        List<Medico> listMedicos = medicoRepository.findMedicoByInativo(0);
        return fillDoctor(listMedicos);
    }

    public List<Doctor> buscaTodosMedicoQueTrabalhamNoSetor(int idSetor) {

        // Pega todas as especilidades que trabalham naquela setor
        // Pega todos os medicos que tem aquela especilidade
        List<Especialidade> especialidadeList = especialidadeRepository.findEspecialidadeBySetorId(idSetor);

        List<Doctor> doctorList = new ArrayList<>();
        for (Especialidade especialidade: especialidadeList){

            doctorList.addAll(findbyEspecialidadeMedico(especialidade.getCodigo()));

        }

        return doctorList;


    }

    public List<Doctor> findbyEspecialidadeMedico(int idEspecialidade){
        List<Medico> listMedicos =  medicoRepository.findMedicoByEspecialidadeCodigoAndInativo(idEspecialidade, 0);
        return fillDoctor(listMedicos);
    }

    private List<Doctor> fillDoctor(List<Medico> list){
        List<Doctor> listFinal = new ArrayList<>();

        for (Medico medico : list){
            Doctor doctor = new Doctor();
            doctor.setName(medico.getNome());
            doctor.setCrmId(medico.getCrm());
            doctor.setSpecialty(medico.getEspecialidade().getCodigo());

            listFinal.add(doctor);
        }
        return listFinal;
    }


}

package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.AppointmentStatus;
import org.example.alchimia.dto.Doctor;
import org.example.alchimia.entity.Especialidade;
import org.example.alchimia.entity.Exame;
import org.example.alchimia.entity.Medico;
import org.example.alchimia.repository.EspecialidadeRepository;
import org.example.alchimia.repository.ExameRepository;
import org.example.alchimia.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;
    private final ExameRepository exameRepository;

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

        List<Integer> doctorList = new ArrayList<>();
        for (Especialidade especialidade: especialidadeList){
            doctorList.add(especialidade.getCodigo());
        }
        return fillDoctor(medicoRepository.findMedicosByEspecialidadeCodigoIn(doctorList));
    }

    public List<Doctor> findbyEspecialidadeMedico(int idEspecialidade){
        List<Medico> listMedicos =  medicoRepository.findMedicoByEspecialidadeCodigoAndInativo(idEspecialidade, 0);
        return fillDoctor(listMedicos);
    }

    public List<AppointmentStatus> horariosOcupadosMedico(LocalDate date, int idMedico){

        List<Exame> exameList = exameRepository.findExameByDataAndPriRealizanteCrmAndCancelado(date, idMedico,0);

        List<AppointmentStatus> appointmentStatusList = new ArrayList<>();
        for(Exame exame: exameList){

            AppointmentStatus appointmentStatus = new AppointmentStatus();
            appointmentStatus.setDateTime(exame.getHoraExame());
            appointmentStatus.setDoctorId(exame.getPriRealizante().getCrm());
            appointmentStatus.setPatientName("");
            appointmentStatus.setProcedureCode(exame.getMnemonico().getCodigo());

            appointmentStatusList.add(appointmentStatus);

        }

        return appointmentStatusList;
    }


    // -------------------------------- Private Function ------------------------------------
    private List<Doctor> fillDoctor(List<Medico> list){
        List<Doctor> listFinal = new ArrayList<>();

        for (Medico medico : list){
            Doctor doctor = new Doctor();
            doctor.setName(medico.getNome());
            doctor.setCrmId(medico.getCrm());
            doctor.setSpecialty(medico.getEspecialidade().getNome());

            listFinal.add(doctor);
        }
        return listFinal;
    }


}

package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.CadastroAtendimento;
import org.example.alchimia.entity.Atendimento;
import org.example.alchimia.entity.Paciente;
import org.example.alchimia.repository.AtendimentoRepository;
import org.example.alchimia.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final PacienteRepository pacienteRepository;

    public List<Atendimento> findByPacienteId(Long pacienteId){
        Paciente paciente = pacienteRepository.findByCodigo(pacienteId);
        return atendimentoRepository.findAllByPaciente(paciente);
    }

    public Atendimento registerNewAtendimento(CadastroAtendimento cadastroAtendimento){

        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(pacienteRepository.findByCodigo(cadastroAtendimento.getPaciente()));
        atendimento.setConvenio(cadastroAtendimento.getConvenio());
        atendimento.setMedico(cadastroAtendimento.getMedico());
        atendimento.setPlano(cadastroAtendimento.getPlano());
        atendimento.setMatricula(cadastroAtendimento.getMatricula());

        // Define id
        Long idCurrent = gerarProximoCodigo();
        atendimento.setRequisicao(idCurrent);

        atendimento.setStatus(0);

        // Horarios
        LocalDateTime now = LocalDateTime.now();
        atendimento.setDataReal(now);
        atendimento.setData(now);
        atendimento.setHora(now);
        atendimento.setDataCadastro(now);
        atendimento.setHoraCadastro(now);


        return atendimentoRepository.save(atendimento);

    }

    private Long gerarProximoCodigo() {
        Long ultimo = atendimentoRepository.findMaxCodigo();

        if (ultimo == null) {
            return 1L;
        }

        return ultimo + 1;
    }

}

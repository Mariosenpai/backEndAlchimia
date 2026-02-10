package org.example.alchimia.service;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.PacienteRegister;
import org.example.alchimia.entity.Paciente;
import org.example.alchimia.repository.PacienteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;



    public String registerPaciente(PacienteRegister user){

        Paciente userFomDataBase = pacienteRepository.findPatientByCpf(user.getCPF());

        if(userFomDataBase != null){
            return "Paciente Ja cadastrado";
        }

        Paciente paciente = new Paciente();

        String encodedPassword = new BCryptPasswordEncoder().encode(user.getSenha());
        paciente.setSenha(encodedPassword);
        paciente.setNome(user.getNome());
        paciente.setEmail(user.getEmail());
        paciente.setCpf(user.getCPF());
        paciente.setCodigo(gerarProximoCodigo());
        // Colunas not null
        paciente.setEnvioLGPD(0);
        paciente.setEstado(9);
        paciente.setNaoRecebeWhats(0);
//        user.setCreatedDate(Instant.now());
//        user.setRoles(Collections.singleton(Role.USER));

        pacienteRepository.save(paciente);
        return "Paciente cadastrado com sucesso!";

    }

    public String gerarProximoCodigo() {
        String ultimo = pacienteRepository.findMaxCodigo();

        if (ultimo == null) {
            return "1";
        }

        int proximo = Integer.parseInt(ultimo) + 1;
        return String.valueOf(proximo);
    }

}

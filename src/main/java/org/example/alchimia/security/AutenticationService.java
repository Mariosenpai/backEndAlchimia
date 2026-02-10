package org.example.alchimia.security;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.repository.PacienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticationService implements UserDetailsService {

    private final PacienteRepository pacienteRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return pacienteRepository.findPatientByCpf(cpf);
    }
}

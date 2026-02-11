package org.example.alchimia.controller;

import lombok.AllArgsConstructor;
import org.example.alchimia.dto.Doctor;
import org.example.alchimia.entity.Medico;
import org.example.alchimia.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping("/ativos")
    public ResponseEntity<List<Doctor>> buscaMedicosAtivos(){
        return new ResponseEntity<>( medicoService.findbyActiveMedico(), HttpStatus.OK);
    }

    @GetMapping("/setorId/{id}")
    public ResponseEntity<List<Doctor>> buscaMedicosPorSetor(@PathVariable int id){
        return new ResponseEntity<>(medicoService.buscaTodosMedicoQueTrabalhamNoSetor(id), HttpStatus.OK);
    }

    @GetMapping("/especilidade/{id}")
    public ResponseEntity<List<Doctor>> buscaMedicosEspecilidadeAtivo(@RequestParam("id") int idEspecilidade){
        return new ResponseEntity<>(medicoService.findbyEspecialidadeMedico(idEspecilidade), HttpStatus.OK);
    }

}

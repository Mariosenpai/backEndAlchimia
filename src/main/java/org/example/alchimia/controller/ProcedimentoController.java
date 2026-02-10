package org.example.alchimia.controller;

import lombok.RequiredArgsConstructor;
import org.example.alchimia.dto.Doctor;
import org.example.alchimia.dto.Procedure;
import org.example.alchimia.entity.Procedimento;
import org.example.alchimia.service.ProcedimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/procedimento")
public class ProcedimentoController {

    private final ProcedimentoService procedimentoService;

    @GetMapping("/all")
    public ResponseEntity<List<Procedure>> findAll(){
        return new ResponseEntity<>(procedimentoService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> findById(@RequestParam("id") int id){
        return new ResponseEntity<>(procedimentoService.findById(id), HttpStatus.OK);
    }


}

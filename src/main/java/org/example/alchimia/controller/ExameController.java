package org.example.alchimia.controller;

import lombok.AllArgsConstructor;
import org.example.alchimia.entity.Exame;
import org.example.alchimia.service.ExameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/exame")
@ResponseBody
public class ExameController {

    private final ExameService exameService;

    @GetMapping("/all")
    public ResponseEntity<Page<Exame>> allUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return new ResponseEntity<>(exameService.findAll(PageRequest.of(page,size)), HttpStatus.OK);
    }

    @GetMapping("/medico")
    public ResponseEntity<Page<Exame>> getIdMedico(
            @RequestParam int id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return new ResponseEntity<>(exameService.findExamesMedico(id, PageRequest.of(page,size)), HttpStatus.OK);
    }

}

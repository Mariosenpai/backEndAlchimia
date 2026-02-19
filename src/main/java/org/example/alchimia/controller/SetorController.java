package org.example.alchimia.controller;


import lombok.AllArgsConstructor;
import org.example.alchimia.entity.Setor;
import org.example.alchimia.service.SetorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("setor/")
public class SetorController {

    private final SetorService setorService;

    @GetMapping("/all")
    public ResponseEntity<List<Setor>> setorAll(){
        return new ResponseEntity<>(setorService.findAll(),HttpStatus.OK);
    }


}

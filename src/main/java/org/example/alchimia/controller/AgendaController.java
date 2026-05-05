package org.example.alchimia.controller;

import lombok.AllArgsConstructor;
import org.example.alchimia.dto.CadastroAtendimento;
import org.example.alchimia.entity.Agenda;
import org.example.alchimia.entity.Atendimento;
import org.example.alchimia.service.AgendaService;
import org.example.alchimia.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agenda")
@ResponseBody
public class AgendaController {

    private final AgendaService agendaService;
    private final AtendimentoService atendimentoService;


    @GetMapping("/codigo/{id}")
    public ResponseEntity<Agenda> allAgenda(@PathVariable int id){
        return new ResponseEntity<>(agendaService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agenda>> allAgenda(){
        return new ResponseEntity<>(agendaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/especialidade/{id}")
    public ResponseEntity<List<Agenda>> findByEspecilidadeId(@PathVariable int id){
        return new ResponseEntity<>(agendaService.findByEspecialidade(id), HttpStatus.OK);
    }

    @GetMapping("/Atendimento/paciente/{id}")
    public ResponseEntity<List<Atendimento>> findByAtendimentosForPacienteId(@PathVariable("id") Long id){
        return new ResponseEntity<>(atendimentoService.findByPacienteId(id),HttpStatus.OK);
    }

    @PostMapping("/atendimento/register")
    public ResponseEntity<Atendimento> registerNewAtendimento(CadastroAtendimento cadastroAtendimento){
        return new ResponseEntity<>(atendimentoService.registerNewAtendimento(cadastroAtendimento), HttpStatus.OK);
    }

}

package com.jej.entregueBem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.jej.entregueBem.form.ClienteForm;
import com.jej.entregueBem.model.Cliente;
import com.jej.entregueBem.repository.ClienteRepository;
import com.jej.entregueBem.service.ClienteService;

@CrossOrigin(maxAge = 10)
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody ClienteForm clienteForm) {
		Cliente cliente = clienteService.inserir(clienteForm);
		return ResponseEntity.ok(cliente);
	}
}

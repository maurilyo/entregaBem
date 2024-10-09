package com.jej.entregueBem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jej.entregueBem.form.MaloteForm;
import com.jej.entregueBem.model.Malote;
import com.jej.entregueBem.service.MaloteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("malotes")
public class MaloteController {

    @Autowired
    MaloteService service;
    
    public ResponseEntity<Malote> inserir(@RequestBody MaloteForm malote){
        return ResponseEntity.ok(service.inserir(malote));
    }
}

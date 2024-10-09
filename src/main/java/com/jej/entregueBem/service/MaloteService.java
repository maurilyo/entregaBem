package com.jej.entregueBem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jej.entregueBem.form.MaloteForm;
import com.jej.entregueBem.model.Malote;
import com.jej.entregueBem.repository.MaloteRepository;

@Service
public class MaloteService {

    @Autowired
    MaloteRepository maloteRepository;

    public Malote inserir(MaloteForm dto){
        return null;
    }

}

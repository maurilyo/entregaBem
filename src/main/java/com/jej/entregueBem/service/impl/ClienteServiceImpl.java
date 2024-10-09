package com.jej.entregueBem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jej.entregueBem.form.ClienteForm;
import com.jej.entregueBem.model.Cliente;
import com.jej.entregueBem.model.Endereco;
import com.jej.entregueBem.repository.ClienteRepository;
import com.jej.entregueBem.repository.EnderecoRepository;
import com.jej.entregueBem.service.ClienteService;
import com.jej.entregueBem.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Cliente inserir(ClienteForm cliente) {
        return salvarClienteComCep(cliente);
    }

	private Cliente salvarClienteComCep(ClienteForm clienteForm) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		Long cep = clienteForm.getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep.toString());
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		return clienteRepository.save(cliente);
	}

}

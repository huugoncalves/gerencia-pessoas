package com.huugoncalves.gerenciapessoas.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.huugoncalves.gerenciapessoas.model.dto.EnderecoDTO;
import com.huugoncalves.gerenciapessoas.model.dto.PessoaDTO;
import com.huugoncalves.gerenciapessoas.model.mappers.EnderecoMapper;
import com.huugoncalves.gerenciapessoas.model.mappers.PessoaMapper;
import com.huugoncalves.gerenciapessoas.repository.EnderecoRepository;
import com.huugoncalves.gerenciapessoas.repository.PessoaRepository;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping(value = "/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoMapper enderecoMapper;
	@Autowired
	private PessoaMapper pessoaMapper;
	
	@PostMapping(value = "/{idPessoa}")
	@Transactional
	public ResponseEntity<PessoaDTO> createEndereco(@PathVariable Long idPessoa, @RequestBody @Valid EnderecoDTO endereco) {
		var pessoa = pessoaRepository.findById(idPessoa);
		if (pessoa.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		pessoa.get().getEnderecos().add(enderecoMapper.toModel(endereco));
		pessoaRepository.save(pessoa.get());
		var uri = UriComponentsBuilder.fromPath("").buildAndExpand(pessoa.get().getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaMapper.toDTO(pessoa.get()));
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO principal) {
		var endereco = enderecoRepository.findById(id);
		if (endereco.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		var newEndereco = endereco.get();
		newEndereco.setPrincipal(principal.getPrincipal());
		enderecoRepository.save(newEndereco);
		return ResponseEntity.ok(enderecoMapper.toDTO(newEndereco));
	}
	
	@GetMapping(value = "/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<ArrayList<EnderecoDTO>> findEnderecosById(@PathVariable Long id) {
		var pessoa = pessoaRepository.findById(id);
		if (pessoa.get().getEnderecos().isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		var response = new ArrayList<EnderecoDTO>();
		for (var endereco : pessoa.get().getEnderecos()) {
			response.add(enderecoMapper.toDTO(endereco));
		}
		return ResponseEntity.ok(response);
	}

}

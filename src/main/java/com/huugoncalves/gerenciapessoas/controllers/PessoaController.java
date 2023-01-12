package com.huugoncalves.gerenciapessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.huugoncalves.gerenciapessoas.model.dto.PessoaDTO;
import com.huugoncalves.gerenciapessoas.model.mappers.PessoaMapper;
import com.huugoncalves.gerenciapessoas.repository.PessoaRepository;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping(value = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PessoaMapper pessoaMapper;
	
	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<Page<PessoaDTO>> findAll(Pageable pageable) {
		var pessoas = pessoaRepository.findAll(pageable);
		if (pessoas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pessoas.map(x -> pessoaMapper.toDTO(x)));
	}
	
	@GetMapping(value = "/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
		var pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoaMapper.toDTO(pessoa.get()));		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDTO> savePessoa(@RequestBody @Valid PessoaDTO pessoa) {
		var response = pessoaRepository.save(pessoaMapper.toModel(pessoa));
		
		var uri = UriComponentsBuilder.fromPath("/pessoa/{id}").buildAndExpand(response.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoaMapper.toDTO(response));
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<PessoaDTO> editPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
		var pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		var newPessoa = pessoa.get();
		newPessoa.setNomePessoa(pessoaDTO.getNomePessoa());
		newPessoa.setDataNascimento(pessoaDTO.getDataNascimento());
		newPessoa = pessoaRepository.save(newPessoa);
		return ResponseEntity.ok(pessoaMapper.toDTO(newPessoa));
	}

}

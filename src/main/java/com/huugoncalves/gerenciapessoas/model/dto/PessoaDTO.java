package com.huugoncalves.gerenciapessoas.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.huugoncalves.gerenciapessoas.model.entities.Pessoa;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PessoaDTO {
	
	public PessoaDTO() {
	}
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nomePessoa = pessoa.getNomePessoa();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecos = pessoa.getEnderecos().stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
	}

	private Long id;
	@NotEmpty(message = "nomePessoa não pode ser vazio")
	private String nomePessoa;
	private LocalDate dataNascimento;
	private List<EnderecoDTO> enderecos;

}

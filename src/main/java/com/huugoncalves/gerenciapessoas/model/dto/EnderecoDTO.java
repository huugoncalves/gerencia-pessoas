package com.huugoncalves.gerenciapessoas.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.huugoncalves.gerenciapessoas.model.entities.Endereco;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EnderecoDTO {
	
	public EnderecoDTO() {
	}

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.principal = endereco.getPrincipal();
	}
	
	private Long id;
	@NotEmpty(message = "Logradouro não pode ser vazio")
	private String logradouro;
	@NotEmpty(message = "CEP não pode ser vazio")
	private String cep;
	@NotNull(message = "Numero não pode ser vazio")
	private Integer numero;
	@NotEmpty(message = "Cidade não pode ser vazio")
	private String cidade;
	private String principal;

}

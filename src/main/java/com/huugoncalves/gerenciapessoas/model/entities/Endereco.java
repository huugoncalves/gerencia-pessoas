package com.huugoncalves.gerenciapessoas.model.entities;

import com.huugoncalves.gerenciapessoas.model.dto.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_enderecos")
@Data
public class Endereco {
	
	public Endereco() {
	}
	
	public Endereco(EnderecoDTO enderecos) {
		this.logradouro = enderecos.getLogradouro();
		this.cep = enderecos.getCep();
		this.numero = enderecos.getNumero();
		this.cidade = enderecos.getCidade();
		this.principal = enderecos.getPrincipal();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;
	private String principal;
	
}

package com.huugoncalves.gerenciapessoas.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huugoncalves.gerenciapessoas.model.dto.PessoaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_pessoas")
@Data
public class Pessoa {
	
	public Pessoa() {
	}
	
	public Pessoa(PessoaDTO pessoa) {
		this.nomePessoa = pessoa.getNomePessoa();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecos = pessoa.getEnderecos().stream().map(x -> new Endereco(x)).collect(Collectors.toList());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePessoa;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private List<Endereco> enderecos = new ArrayList<>();

}

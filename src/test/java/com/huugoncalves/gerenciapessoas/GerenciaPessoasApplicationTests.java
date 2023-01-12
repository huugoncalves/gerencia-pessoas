package com.huugoncalves.gerenciapessoas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.huugoncalves.gerenciapessoas.model.entities.Endereco;
import com.huugoncalves.gerenciapessoas.model.entities.Pessoa;
import com.huugoncalves.gerenciapessoas.model.mappers.EnderecoMapper;
import com.huugoncalves.gerenciapessoas.model.mappers.PessoaMapper;

@SpringBootTest
class GerenciaPessoasApplicationTests {
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	@Autowired
	private PessoaMapper pessoaMapper;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testeCadastroPessoaSemEndereco() {
		var pessoa = new Pessoa();
		pessoa.setNomePessoa("Hugo");
		pessoa.setDataNascimento(LocalDate.parse("1993-04-05"));
		
		assertEquals(pessoa.getNomePessoa(), "Hugo");
		assertEquals(pessoa.getDataNascimento(), LocalDate.parse("1993-04-05"));
	}
	
	@Test
	void testePessoaDTO() {
		var pessoa = new Pessoa();
		pessoa.setNomePessoa("Hugo");
		pessoa.setDataNascimento(LocalDate.parse("1993-04-05"));
		var pessoaDTO = pessoaMapper.toDTO(pessoa);
		
		assertEquals(pessoaDTO.getNomePessoa(), "Hugo");
		assertEquals(pessoaDTO.getDataNascimento(), LocalDate.parse("1993-04-05"));
	}
	
	@Test
	void testeEnderecoDTO() {
		var endereco = new Endereco();
		endereco.setLogradouro("Rua 1");
		endereco.setCep("0000002");
		endereco.setNumero(333);
		endereco.setCidade("Belo Horizonte");
		var enderecoDTO = enderecoMapper.toDTO(endereco);
		
		assertEquals(enderecoDTO.getLogradouro(), "Rua 1");
		assertEquals(enderecoDTO.getCep(), "0000002");
		assertEquals(enderecoDTO.getNumero(), 333);
		assertEquals(enderecoDTO.getCidade(), "Belo Horizonte");
	}

}

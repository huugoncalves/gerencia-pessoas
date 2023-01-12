package com.huugoncalves.gerenciapessoas.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.huugoncalves.gerenciapessoas.model.dto.PessoaDTO;
import com.huugoncalves.gerenciapessoas.model.entities.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	Pessoa toModel(PessoaDTO dto);
	PessoaDTO toDTO(Pessoa pessoa);

}

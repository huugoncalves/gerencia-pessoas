package com.huugoncalves.gerenciapessoas.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.huugoncalves.gerenciapessoas.model.dto.EnderecoDTO;
import com.huugoncalves.gerenciapessoas.model.entities.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

	EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
	Endereco toModel(EnderecoDTO dto);
	EnderecoDTO toDTO(Endereco endereco);
}

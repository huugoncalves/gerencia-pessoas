package com.huugoncalves.gerenciapessoas.model.mappers;

import com.huugoncalves.gerenciapessoas.model.dto.EnderecoDTO;
import com.huugoncalves.gerenciapessoas.model.entities.Endereco;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T08:09:39-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public Endereco toModel(EnderecoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setCep( dto.getCep() );
        endereco.setCidade( dto.getCidade() );
        endereco.setId( dto.getId() );
        endereco.setLogradouro( dto.getLogradouro() );
        endereco.setNumero( dto.getNumero() );
        endereco.setPrincipal( dto.getPrincipal() );

        return endereco;
    }

    @Override
    public EnderecoDTO toDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setCep( endereco.getCep() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setId( endereco.getId() );
        enderecoDTO.setLogradouro( endereco.getLogradouro() );
        enderecoDTO.setNumero( endereco.getNumero() );
        enderecoDTO.setPrincipal( endereco.getPrincipal() );

        return enderecoDTO;
    }
}

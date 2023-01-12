package com.huugoncalves.gerenciapessoas.model.mappers;

import com.huugoncalves.gerenciapessoas.model.dto.EnderecoDTO;
import com.huugoncalves.gerenciapessoas.model.dto.PessoaDTO;
import com.huugoncalves.gerenciapessoas.model.entities.Endereco;
import com.huugoncalves.gerenciapessoas.model.entities.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T08:04:09-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa toModel(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setDataNascimento( dto.getDataNascimento() );
        pessoa.setEnderecos( enderecoDTOListToEnderecoList( dto.getEnderecos() ) );
        pessoa.setId( dto.getId() );
        pessoa.setNomePessoa( dto.getNomePessoa() );

        return pessoa;
    }

    @Override
    public PessoaDTO toDTO(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setDataNascimento( pessoa.getDataNascimento() );
        pessoaDTO.setEnderecos( enderecoListToEnderecoDTOList( pessoa.getEnderecos() ) );
        pessoaDTO.setId( pessoa.getId() );
        pessoaDTO.setNomePessoa( pessoa.getNomePessoa() );

        return pessoaDTO;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setCep( enderecoDTO.getCep() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setId( enderecoDTO.getId() );
        endereco.setLogradouro( enderecoDTO.getLogradouro() );
        endereco.setNumero( enderecoDTO.getNumero() );
        endereco.setPrincipal( enderecoDTO.getPrincipal() );

        return endereco;
    }

    protected List<Endereco> enderecoDTOListToEnderecoList(List<EnderecoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Endereco> list1 = new ArrayList<Endereco>( list.size() );
        for ( EnderecoDTO enderecoDTO : list ) {
            list1.add( enderecoDTOToEndereco( enderecoDTO ) );
        }

        return list1;
    }

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
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

    protected List<EnderecoDTO> enderecoListToEnderecoDTOList(List<Endereco> list) {
        if ( list == null ) {
            return null;
        }

        List<EnderecoDTO> list1 = new ArrayList<EnderecoDTO>( list.size() );
        for ( Endereco endereco : list ) {
            list1.add( enderecoToEnderecoDTO( endereco ) );
        }

        return list1;
    }
}

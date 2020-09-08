package io.github.tiagoferreira.mapper;

import io.github.tiagoferreira.domain.EnderecoDTO;
import io.github.tiagoferreira.model.Endereco;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper extends GenericMapper<Endereco, EnderecoDTO>{
}

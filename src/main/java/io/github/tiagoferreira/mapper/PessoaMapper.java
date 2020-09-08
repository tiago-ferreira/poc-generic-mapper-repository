package io.github.tiagoferreira.mapper;

import io.github.tiagoferreira.domain.PessoaDTO;
import io.github.tiagoferreira.model.Pessoa;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaMapper extends GenericMapper<Pessoa, PessoaDTO>{
}

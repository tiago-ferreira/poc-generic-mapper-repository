package io.github.tiagoferreira.domain;

import io.github.tiagoferreira.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Integer id;
    private String rua;
    private Short numero;
    private Pessoa pessoa;

}

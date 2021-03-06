package io.github.tiagoferreira.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "mapper", name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Short numero;
    @ManyToOne
    private Pessoa pessoa;
}

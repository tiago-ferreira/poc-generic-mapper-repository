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
@Table(schema = "mapper", name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
}

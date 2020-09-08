package io.github.tiagoferreira.repository;

import io.github.tiagoferreira.domain.EnderecoDTO;
import io.github.tiagoferreira.mapper.EnderecoMapper;
import io.github.tiagoferreira.model.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EnderecoRepository extends GenericRepository<Endereco, EnderecoDTO, Integer, EnderecoMapper>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

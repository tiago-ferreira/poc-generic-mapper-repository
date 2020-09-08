package io.github.tiagoferreira.repository;

import io.github.tiagoferreira.domain.PessoaDTO;
import io.github.tiagoferreira.mapper.PessoaMapper;
import io.github.tiagoferreira.model.Pessoa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PessoaRepository extends GenericRepository<Pessoa, PessoaDTO, Integer, PessoaMapper>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

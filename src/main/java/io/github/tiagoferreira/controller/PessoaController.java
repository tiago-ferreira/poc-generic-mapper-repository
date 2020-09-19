package io.github.tiagoferreira.controller;

import io.github.tiagoferreira.domain.PessoaDTO;
import io.github.tiagoferreira.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public PessoaDTO save(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaRepository.save(pessoaDTO);
    }

    @PutMapping
    public PessoaDTO update(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaRepository.update(pessoaDTO);
    }

    @GetMapping("{id}")
    public Optional<PessoaDTO> find(@PathVariable("id") Integer id) {
        return pessoaRepository.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        pessoaRepository.delete(id);
    }
}

package br.com.clinica.controller;

import br.com.clinica.dto.contabil.DadosAtualizacaoContabil;
import br.com.clinica.dto.contabil.DadosContabil;
import br.com.clinica.dto.contabil.DadosListagemContabil;
import br.com.clinica.funcionarios.Contabil;
import br.com.clinica.repository.ContabilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contabeis")
public class ContabilController {

    @Autowired
    private ContabilRepository repository;

    @PostMapping
    @Transactional
    public DadosContabil cadastrar(@RequestBody @Valid DadosContabil dados) {
        repository.save(new Contabil(dados));

        return dados;
    }

    @GetMapping
    public Page<DadosListagemContabil> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemContabil::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoContabil contabeis) {
        var contabil = repository.getReferenceById(contabeis.id());
        contabil.atualizarInfo(contabeis);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var contabil = repository.getReferenceById(id);
        contabil.excluir();
    }
}

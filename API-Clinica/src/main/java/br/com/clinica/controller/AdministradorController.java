package br.com.clinica.controller;

import br.com.clinica.dto.admin.DadosAdministrador;
import br.com.clinica.dto.admin.DadosAtualizacaoAdmin;
import br.com.clinica.dto.admin.DadosListagemAdmin;
import br.com.clinica.funcionarios.Administrador;
import br.com.clinica.repository.AdministradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @PostMapping
    @Transactional
    public DadosAdministrador cadastrar(@RequestBody @Valid DadosAdministrador dados){
        repository.save(new Administrador(dados));

        return dados;
    }

    @GetMapping
    public Page<DadosListagemAdmin> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemAdmin::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAdmin contabeis) {
        var contabil = repository.getReferenceById(contabeis.id());
        contabil.atualizarInfo(contabeis);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var administrador = repository.getReferenceById(id);
        administrador.excluir();
    }
}

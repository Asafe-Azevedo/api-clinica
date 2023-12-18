package br.com.clinica.controller;

import br.com.clinica.dto.medico.DadosMedico;
import br.com.clinica.repository.MedicoRepository;
import br.com.clinica.dto.medico.DadosAtualizacaoMedico;
import br.com.clinica.dto.medico.DadosListagemMedico;
import br.com.clinica.funcionarios.Medico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public DadosMedico cadastrar(@RequestBody @Valid DadosMedico dados) {
        repository.save(new Medico(dados));

        return dados;
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico medicos) {
        var medico = repository.getReferenceById(medicos.id());
        medico.atualizarInfo(medicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}

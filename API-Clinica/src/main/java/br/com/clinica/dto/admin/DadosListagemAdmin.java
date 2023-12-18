package br.com.clinica.dto.admin;

import br.com.clinica.endereco.Endereco;
import br.com.clinica.funcionarios.Administrador;
import br.com.clinica.especialidade.EspecialidadeAdministrador;

public record DadosListagemAdmin(Long id, String nome, String nascimento, EspecialidadeAdministrador especialidade, Endereco endereco) {

    public DadosListagemAdmin(Administrador administrador){
        this(administrador.getId(), administrador.getNome(), administrador.getNascimento(), administrador.getEspecialidade(), administrador.getEndereco());
    }
}

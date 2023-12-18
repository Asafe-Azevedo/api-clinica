package br.com.clinica.dto.contabil;

import br.com.clinica.endereco.Endereco;
import br.com.clinica.especialidade.EspecialidadeContabil;
import br.com.clinica.funcionarios.Administrador;
import br.com.clinica.funcionarios.Contabil;

public record DadosListagemContabil(Long id, String nome, String nascimento, EspecialidadeContabil especialidade, Endereco endereco) {

    public DadosListagemContabil(Contabil  contabil){
        this(contabil.getId(), contabil.getNome(), contabil.getNascimento(), contabil.getEspecialidade(), contabil.getEndereco());
    }

}

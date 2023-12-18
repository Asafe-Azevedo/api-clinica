package br.com.clinica.dto.admin;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeAdministrador;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAdmin(

        @NotNull
        Long id,

        String nome,
        EspecialidadeAdministrador especialidade,
        DadosEndereco endereco,
        String salario
) {
}

package br.com.clinica.dto.admin;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeAdministrador;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAdministrador(

        @NotBlank
        String nome,

        @NotBlank
        String nascimento,

        @NotBlank
        String cpf,

        @NotBlank
        String cfa,

        @NotNull
        EspecialidadeAdministrador especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco,

        String salario
) {
}

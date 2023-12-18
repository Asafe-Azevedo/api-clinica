package br.com.clinica.dto.contabil;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeContabil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoContabil(

        @NotNull
        Long id,

        String nome,
        EspecialidadeContabil especialidade,
        DadosEndereco endereco,
        String salario
) {
}

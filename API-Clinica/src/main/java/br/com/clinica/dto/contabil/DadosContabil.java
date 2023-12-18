package br.com.clinica.dto.contabil;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeContabil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosContabil(

        @NotBlank
        String nome,

        @NotBlank
        String nascimento,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotBlank
        @Pattern(regexp = "\\d{6}")
        String crc,

        @NotNull
        EspecialidadeContabil especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco,

        String salario
) {
}

package br.com.clinica.dto.medico;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeMedico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosMedico(

        @NotBlank
        String nome,

        @NotBlank
        String nascimento,

        @NotBlank
        String cpf,

        @NotNull
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        EspecialidadeMedico especialidade,

        @NotBlank
        String salario,

        @NotNull
        @Valid
        DadosEndereco endereco

) {
}

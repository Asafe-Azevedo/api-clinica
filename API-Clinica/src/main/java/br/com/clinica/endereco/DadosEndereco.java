package br.com.clinica.endereco;

import jakarta.validation.constraints.NotBlank;


public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String rua,

        @NotBlank
        String uf,

        @NotBlank
        String cidade


) {
}

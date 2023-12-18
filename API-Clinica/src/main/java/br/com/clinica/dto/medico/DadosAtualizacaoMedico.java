package br.com.clinica.dto.medico;

import br.com.clinica.endereco.DadosEndereco;
import br.com.clinica.especialidade.EspecialidadeMedico;

public record DadosAtualizacaoMedico(

        Long id,
        String nome,
        EspecialidadeMedico especialidade,
        DadosEndereco endereco,
        String salario
) {
}

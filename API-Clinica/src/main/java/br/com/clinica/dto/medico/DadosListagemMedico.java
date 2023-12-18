package br.com.clinica.dto.medico;

import br.com.clinica.endereco.Endereco;
import br.com.clinica.especialidade.EspecialidadeMedico;
import br.com.clinica.funcionarios.Medico;

public record DadosListagemMedico(Long id, String nome, String crm, EspecialidadeMedico especialidade, Endereco endereco) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}

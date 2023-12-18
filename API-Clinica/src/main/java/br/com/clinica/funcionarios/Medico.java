package br.com.clinica.funcionarios;

import br.com.clinica.dto.medico.DadosMedico;
import br.com.clinica.especialidade.EspecialidadeMedico;
import br.com.clinica.dto.medico.DadosAtualizacaoMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico extends Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeMedico especialidade;

    public Medico(DadosMedico dados) {
        super(dados);
        this.ativo = true;
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
    }

    public void atualizarInfo(DadosAtualizacaoMedico medicos) {
        if (medicos.nome() != null) {
            this.nome = medicos.nome();
        }
        if (medicos.especialidade() != null) {
            this.especialidade = medicos.especialidade();
        }
        if (medicos.endereco() != null) {
            this.endereco.atualizarInformacoes(medicos.endereco());
        }
        if (medicos.salario() != null) {
            this.salario = medicos.salario();
        }
    }


    public void excluir() {
        this.ativo = false;
    }
}

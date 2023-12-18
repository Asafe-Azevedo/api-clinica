package br.com.clinica.funcionarios;

import br.com.clinica.dto.contabil.DadosAtualizacaoContabil;
import br.com.clinica.dto.contabil.DadosContabil;
import br.com.clinica.especialidade.EspecialidadeContabil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contabeis")
@Entity(name = "Contabil")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contabil extends Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crc;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeContabil especialidade;

    public Contabil(DadosContabil dados) {
        super(dados);
        this.ativo = true;
        this.crc = dados.crc();
        this.especialidade = dados.especialidade();
    }

    public void atualizarInfo(DadosAtualizacaoContabil contabeis) {
        if (contabeis.nome() != null) {
            this.nome = contabeis.nome();
        }
        if (contabeis.especialidade() != null) {
            this.especialidade = contabeis.especialidade();
        }
        if (contabeis.endereco() != null) {
            this.endereco.atualizarInformacoes(contabeis.endereco());
        }
        if (contabeis.salario() != null) {
            this.salario = contabeis.salario();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

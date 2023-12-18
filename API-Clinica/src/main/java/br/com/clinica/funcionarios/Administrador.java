package br.com.clinica.funcionarios;

import br.com.clinica.dto.admin.DadosAdministrador;
import br.com.clinica.dto.admin.DadosAtualizacaoAdmin;
import br.com.clinica.especialidade.EspecialidadeAdministrador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "administradores")
@Entity(name = "Administrador")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Administrador extends Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cfa;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeAdministrador especialidade;

    public Administrador(DadosAdministrador dados) {
        super(dados);
        this.cfa = dados.cfa();
        this.ativo = true;
        this.especialidade = dados.especialidade();
    }

    public void atualizarInfo(DadosAtualizacaoAdmin admin) {

            if (admin.nome() != null) {
                this.nome = admin.nome();
            }
            if (admin.especialidade() != null) {
                this.especialidade = admin.especialidade();
            }
            if (admin.endereco() != null) {
                this.endereco.atualizarInformacoes(admin.endereco());
            }
            if (admin.salario() != null) {
                this.salario = admin.salario();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

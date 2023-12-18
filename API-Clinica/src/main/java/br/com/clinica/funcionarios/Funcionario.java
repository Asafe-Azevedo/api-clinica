package br.com.clinica.funcionarios;

import br.com.clinica.Pessoa;
import br.com.clinica.dto.admin.DadosAdministrador;
import br.com.clinica.dto.contabil.DadosContabil;
import br.com.clinica.dto.medico.DadosMedico;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {

    protected String salario;

    public Funcionario(DadosMedico dados) {
        super(dados);
        this.salario = dados.salario();
    }

    public Funcionario(DadosContabil dados) {
        super(dados);
        this.salario = dados.salario();
    }

    public Funcionario(DadosAdministrador dados) {
        super(dados);
        this.salario = dados.salario();
    }
}

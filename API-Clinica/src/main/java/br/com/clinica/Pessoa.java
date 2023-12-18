package br.com.clinica;

import br.com.clinica.dto.admin.DadosAdministrador;
import br.com.clinica.dto.contabil.DadosContabil;
import br.com.clinica.dto.medico.DadosMedico;
import br.com.clinica.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    protected String nome;
    private String nascimento;
    private String cpf;

    @Embedded
    protected Endereco endereco;

    public Pessoa(DadosMedico dados) {
        this.nome = dados.nome();
        this.nascimento = dados.nascimento();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public Pessoa(DadosContabil dados) {
        this.nome = dados.nome();
        this.nascimento = dados.nascimento();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public Pessoa(DadosAdministrador dados) {
        this.nome = dados.nome();
        this.nascimento = dados.nascimento();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
}

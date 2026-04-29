package dev.matheuslf.mastersys.dto;

import dev.matheuslf.mastersys.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 150, message = "O nome deve ter o máximo 150 caracteres.")
        String nome,

        @Past(message = "A data de nascimento deve estar no passado.")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O sexo deve ter no máximo 1 caractere.")
        String sexo,

        @Size(max = 30, message = "O telefone deve ter no máximo 30 caracteres.")
        String telefone,

        @Size(max = 30, message = "O celular deve ter no máximo 30 caracteres.")
        String celular,

        @Email(message = "E-mail inválido")
        @Size(max = 150, message = "O e-mail deve ter no máximo 150 caracteres.")
        String email,

        String obervacao,

        @Size(max = 150, message = "O endereço deve ter no máximo 150 caracteres.")
        String endereco,

        @Size(max = 20, message = "O numero deve ter no máximo 20 caracteres.")
        String numero,

        @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres.")
        String complemento,

        @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres.")
        String bairro,

        @Size(max = 100, message = "O cidade deve ter no máximo 100 caracteres.")
        String cidade,

        @Size(max = 2, message = "O estado deve ter no máximo 2 caracteres.")
        String estado,

        @Size(max = 20, message = "O CEP deve ter no máximo 20.")
        String cep
) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(obervacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }

}










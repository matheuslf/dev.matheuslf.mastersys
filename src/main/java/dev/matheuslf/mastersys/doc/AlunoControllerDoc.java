package dev.matheuslf.mastersys.doc;

import dev.matheuslf.mastersys.dto.AlunoFiltroRequest;
import dev.matheuslf.mastersys.dto.AlunoRequest;
import dev.matheuslf.mastersys.dto.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Alunos",
        description = "Operações para cadastro, consulta, atualização, exclusão" +
                      " e filtragem de alunos"
)
public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadastrar aluno",
            description = "Cria um novo aluno no sistema de academia",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    AlunoResponse cadastrar
                    (
                            @RequestBody
                            @Valid
                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                    description = "Dados necessários para cadastrar um aluno",
                                    required = true,
                                    content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                                    examples = @ExampleObject(
                                            name = "Aluno válido",
                                            value = """
                                                    {
                                                          "nome" : "João da Silva",
                                                          "dataNascimento": "1995-08-15",
                                                          "sexo": "M",
                                                          "telefone": "4833334444",
                                                          "celular": "48991645543",
                                                          "email": "joao@email.com",
                                                          "observacao": "Aluno iniciante",
                                                          "endereco": "Rua das Flores",
                                                          "numero": "123",
                                                          "complemento": "Apartamento 202",
                                                          "bairro": "Centro",
                                                          "cidade": "Criciúma",
                                                          "estado": "SC",
                                                          "cep": "88802410"
                                                    }
                                                    """
                                    ))
                            )
                            AlunoRequest alunoRequest
                    );

    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada, permitindo filtros opcionais por " +
                          "nome, e-mail, celular, cidade e estado",
            responses = {
                @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
            }
    )
    Page<AlunoResponse> listar(
        @Parameter(description = "Filtros opcionais para busca de alunos")
        AlunoFiltroRequest filtro,

        @Parameter(description = "Informações de paginação e ordenação")
        Pageable pageable
    );

    @Operation(
            summary = "Buscar aluno por ID",
            description = "Retorna os dados resumidos de um aluno específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation =  ErrorResponse.class))
                    )
            }
    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno", example = "2", required = true)
            Long id);

}













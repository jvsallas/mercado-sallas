package br.com.mercadosallas.clientes.dto;

import br.com.mercadosallas.telefones.dto.TelefoneDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClienteDto implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sobrenome")
    private String sobrenome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("email")
    private String email;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("data_cadastro")
    private String dataCadastro;

    @JsonProperty("telefones")
    private List<TelefoneDto> telefones;


}

package br.com.mercadosallas.clientes.dto;

import br.com.mercadosallas.telefones.dto.TelefoneForm;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClienteForm implements Serializable {

    private String nome;
    private String sobrenome;
    private String cpf;
    @JsonProperty("data_nascimento")
    private String dataNascimento;
    private String email;
    private List<TelefoneForm> telefones;

}

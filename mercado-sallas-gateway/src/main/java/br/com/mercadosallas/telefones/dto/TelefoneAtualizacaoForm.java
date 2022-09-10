package br.com.mercadosallas.telefones.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class TelefoneAtualizacaoForm implements Serializable {

    private String ddd;
    private String numero;
    private String tipo;
}

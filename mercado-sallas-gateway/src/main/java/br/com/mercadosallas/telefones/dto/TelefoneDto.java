package br.com.mercadosallas.telefones.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelefoneDto implements Serializable {
    private Long id;
    private String ddd;
    private String numero;
    private String tipo;
}

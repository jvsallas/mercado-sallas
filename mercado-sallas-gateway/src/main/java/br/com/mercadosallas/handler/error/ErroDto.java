package br.com.mercadosallas.handler.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErroDto {
    private Integer status;
    private String error;
    private String message;
    private String path;
}

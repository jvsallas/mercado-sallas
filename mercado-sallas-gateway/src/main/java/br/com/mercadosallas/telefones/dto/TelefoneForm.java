package br.com.mercadosallas.telefones.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TelefoneForm implements Serializable {
    private String ddd;
    private String numero;
    private String tipo;
}

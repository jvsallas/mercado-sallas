package br.com.mercadosallas.telefones.feignclient;

import br.com.mercadosallas.telefones.dto.TelefoneAtualizacaoForm;
import br.com.mercadosallas.telefones.dto.TelefoneDto;
import br.com.mercadosallas.telefones.dto.TelefoneForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "telefones", url = "http://localhost:8080/clientes")
public interface TelefonesClient {

    @PostMapping("/{idCliente}/telefones")
    ResponseEntity<TelefoneDto> adicionarTelefoneAoCliente(@PathVariable String idCliente, @RequestBody TelefoneForm form) throws Exception;

    @GetMapping("/{idCliente}/telefones")
    ResponseEntity<List<TelefoneDto>> listarTelefonesDoCliente(@PathVariable String idCliente);

    @GetMapping("/{idCliente}/telefones/{idTelefone}")
    ResponseEntity<TelefoneDto> listarTelefonePorId(@PathVariable String idCliente, @PathVariable Long idTelefone);

    @PutMapping("/{idCliente}/telefones/{idTelefone}")
    ResponseEntity<TelefoneDto> alterarNumeroTelefone(@PathVariable String idCliente, @PathVariable Long idTelefone,
                                                             @RequestBody TelefoneAtualizacaoForm form);

    @DeleteMapping("/{idCliente}/telefones/{idTelefone}")
    ResponseEntity<?> deletarTelefone(@PathVariable String idCliente, @PathVariable Long idTelefone);

}

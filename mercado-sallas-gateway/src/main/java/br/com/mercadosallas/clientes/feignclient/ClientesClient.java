package br.com.mercadosallas.clientes.feignclient;

import br.com.mercadosallas.clientes.dto.ClienteAtualizacaoForm;
import br.com.mercadosallas.clientes.dto.ClienteDto;
import br.com.mercadosallas.clientes.dto.ClienteForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "modulo-clientes", url = "http://localhost:8080/clientes")
public interface ClientesClient {

    @PostMapping
    ResponseEntity<ClienteDto> adicionarCliente(@RequestBody ClienteForm clienteForm) throws Exception;

    @GetMapping
    ResponseEntity<Object> listarClientes(@RequestParam String cpf) throws Exception;

    @GetMapping("/{id}")
    ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable String id) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<ClienteDto> alterarDadosCliente(@PathVariable String id, @RequestBody ClienteAtualizacaoForm form) throws Exception;

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable String id) throws Exception;

}

package br.com.mercadosallas.clientes.controller;

import br.com.mercadosallas.clientes.dto.ClienteAtualizacaoForm;
import br.com.mercadosallas.clientes.dto.ClienteDto;
import br.com.mercadosallas.clientes.dto.ClienteForm;
import br.com.mercadosallas.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> adicionarCliente(@RequestBody ClienteForm clienteForm) throws Exception {
        return clienteService.adicionarCliente(clienteForm);
    }

    @GetMapping
    public ResponseEntity<Object> listarClientes(@RequestParam (required = false) String cpf) throws Exception {
        return clienteService.listarClientes(cpf);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> listarClientePorId(@PathVariable String id) throws Exception {
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> alterarDadosCliente(@PathVariable String id, @RequestBody ClienteAtualizacaoForm form) throws Exception {
        return clienteService.alterarDadosCliente(id, form);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable String id) throws Exception {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}

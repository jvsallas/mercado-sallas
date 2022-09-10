package br.com.mercadosallas.clientes.service;

import br.com.mercadosallas.clientes.dto.ClienteAtualizacaoForm;
import br.com.mercadosallas.clientes.dto.ClienteDto;
import br.com.mercadosallas.clientes.feignclient.ClientesClient;
import br.com.mercadosallas.clientes.dto.ClienteForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClientesClient clientesClient;

    public ResponseEntity<ClienteDto> adicionarCliente(ClienteForm clienteForm) throws Exception {
        return clientesClient.adicionarCliente(clienteForm);
    }

    public ResponseEntity<Object> listarClientes(String cpf) throws Exception {
        return clientesClient.listarClientes(cpf);
    }

    public ResponseEntity<ClienteDto> buscarClientePorId(String id) throws Exception {
        return clientesClient.buscarClientePorId(id);
    }

    public ResponseEntity<ClienteDto> alterarDadosCliente(String id, ClienteAtualizacaoForm form) throws Exception {
        return clientesClient.alterarDadosCliente(id, form);
    }

    public void deletarCliente(String id) throws Exception {
        clientesClient.deletarCliente(id);
    }
}
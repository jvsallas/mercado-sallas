package br.com.mercadosallas.telefones.service;

import br.com.mercadosallas.telefones.dto.TelefoneAtualizacaoForm;
import br.com.mercadosallas.telefones.dto.TelefoneDto;
import br.com.mercadosallas.telefones.dto.TelefoneForm;
import br.com.mercadosallas.telefones.feignclient.TelefonesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private TelefonesClient telefonesClient;

    public ResponseEntity<TelefoneDto> adicionarTelefoneAoCliente(String idCliente, TelefoneForm telefoneForm) throws Exception {
        return telefonesClient.adicionarTelefoneAoCliente(idCliente, telefoneForm);

    }

    public ResponseEntity<List<TelefoneDto>> listarTelefonesDoCliente(String idCliente) {
        return telefonesClient.listarTelefonesDoCliente(idCliente);
    }

    public ResponseEntity<TelefoneDto> listarTelefonePorId(String idCliente, Long idTelefone) {
        return telefonesClient.listarTelefonePorId(idCliente, idTelefone);
    }

    public ResponseEntity<TelefoneDto> alterarTelefone(String idCliente, Long idTelefone, TelefoneAtualizacaoForm form) {
        return telefonesClient.alterarNumeroTelefone(idCliente, idTelefone, form);
    }

    public void deletarTelefone(String idCliente, Long idTelefone) {
        telefonesClient.deletarTelefone(idCliente, idTelefone);
    }


}


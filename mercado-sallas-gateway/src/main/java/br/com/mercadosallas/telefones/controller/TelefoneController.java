package br.com.mercadosallas.telefones.controller;

import br.com.mercadosallas.telefones.dto.TelefoneAtualizacaoForm;
import br.com.mercadosallas.telefones.dto.TelefoneDto;
import br.com.mercadosallas.telefones.dto.TelefoneForm;
import br.com.mercadosallas.telefones.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes/{idCliente}/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @PostMapping
    public ResponseEntity<TelefoneDto> adicionarTelefoneAoCliente(@PathVariable String idCliente, @RequestBody TelefoneForm telefoneForm) throws Exception {
        return telefoneService.adicionarTelefoneAoCliente(idCliente, telefoneForm);
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDto>> listarTelefonesDoCliente(@PathVariable String idCliente) {
        return telefoneService.listarTelefonesDoCliente(idCliente);
    }

    @GetMapping("/{idTelefone}")
    public ResponseEntity<TelefoneDto> listarTelefonePorId(@PathVariable String idCliente, @PathVariable Long idTelefone) {
        return telefoneService.listarTelefonePorId(idCliente, idTelefone);
    }

    @PutMapping("/{idTelefone}")
    public ResponseEntity<TelefoneDto> alterarNumeroTelefone(@PathVariable String idCliente, @PathVariable Long idTelefone,
                                                             @RequestBody TelefoneAtualizacaoForm form) {
        return telefoneService.alterarTelefone(idCliente, idTelefone, form);
    }

    @DeleteMapping("/{idTelefone}")
    public void deletarTelefone(@PathVariable String idCliente, @PathVariable Long idTelefone) {
        telefoneService.deletarTelefone(idCliente, idTelefone);
    }
}

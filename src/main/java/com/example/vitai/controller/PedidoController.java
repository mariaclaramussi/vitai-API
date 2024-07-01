package com.example.vitai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.Pedido;
import com.example.vitai.dto.Pedido.PedidoIdDTO;
import com.example.vitai.dto.Pedido.PedidoRequestDTO;
import com.example.vitai.services.PedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping("/**")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @PostMapping
    public ResponseEntity<PedidoIdDTO> createPedido(@RequestBody PedidoRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        PedidoIdDTO pedidoDTO = pedidoService.createPedido(body);

        var uri = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(pedidoDTO.id()).toUri();

        return ResponseEntity.created(uri).body(pedidoDTO);
    }

    @GetMapping("paciente/{id}")
    public List<Pedido> getPedidosByPaciente(@PathVariable String id) {
        return pedidoService.getPedidosByPacienteId(Integer.parseInt(id));
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedidosById(@PathVariable String id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);

        if (pedido.isPresent()) {
            return pedido;
        }
        return null;
    }
}

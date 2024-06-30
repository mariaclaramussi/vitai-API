package com.example.vitai.controller;

import java.util.List;

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

}

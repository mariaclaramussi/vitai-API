package com.example.vitai.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.PedidoItem;
import com.example.vitai.dto.PedidoItem.PedidoItemIdDTO;
import com.example.vitai.dto.PedidoItem.PedidoItemRequestDTO;
import com.example.vitai.services.PedidosItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos-items")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoItemController {
    private final PedidosItemService pedidoItemService;

    @GetMapping("/**")
    public List<PedidoItem> getAllPedidos() {
        return pedidoItemService.getPedidosItem();
    }

    @PostMapping
    public ResponseEntity<PedidoItemIdDTO> createPedidoItem(@RequestBody PedidoItemRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        PedidoItemIdDTO pedidoItemIdDTO = pedidoItemService.createPedidoItem(body);

        var uri = uriComponentsBuilder.path("/pedido-items/{id}").buildAndExpand(pedidoItemIdDTO.id()).toUri();

        return ResponseEntity.created(uri).body(pedidoItemIdDTO);
    }

}

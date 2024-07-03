package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.Pedido;
import com.example.vitai.domain.PedidoItem;
import com.example.vitai.dto.PedidoItem.PedidoItemIdDTO;
import com.example.vitai.dto.PedidoItem.PedidoItemRequestDTO;
import com.example.vitai.repository.ExameTipoRepository;
import com.example.vitai.repository.PedidoItemRepository;
import com.example.vitai.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidosItemService {
    private final PedidoItemRepository pedidoItemRepository;
    private final PedidoRepository pedidoRepository;
    private final ExameTipoRepository exameTipoRepository;

    public List<PedidoItem> getPedidosItem() {
        return pedidoItemRepository.findAll();
    }

    public PedidoItemIdDTO createPedidoItem(PedidoItemRequestDTO pedidoItem) {
        PedidoItem newPedidoItem = new PedidoItem();

        newPedidoItem.setStatus(pedidoItem.status());
        newPedidoItem.setDataRealizacao(pedidoItem.dataRealizacao());

        ExameTipo exameTipo = exameTipoRepository.findById(pedidoItem.codExameTipo()).get();
        newPedidoItem.setCodExameTipo(exameTipo);

        Pedido pedido = pedidoRepository.findById(pedidoItem.codPedido()).get();
        newPedidoItem.setCodPedido(pedido);

        pedido.addPedidoItemToPedido(newPedidoItem);

        this.pedidoItemRepository.save(newPedidoItem);

        return new PedidoItemIdDTO(newPedidoItem.getId());
    }
}

package com.example.vitai.dto.Pedido;

import java.time.LocalDateTime;
import java.util.List;

import com.example.vitai.domain.Medico;
import com.example.vitai.domain.Paciente;
import com.example.vitai.domain.PedidoItem;

public record PedidoDTO(
        Integer id,
        LocalDateTime dataPedido,
        LocalDateTime dataPrevisto,
        String status,
        String tipoPedido,
        LocalDateTime dataCadastro,
        Paciente paciente,
        Medico medico,
        List<PedidoItem> itensPedido) {

}

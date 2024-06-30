package com.example.vitai.dto.Pedido;

import java.time.LocalDateTime;

public record PedidoRequestDTO(
        String id,
        LocalDateTime dataPedido,
        LocalDateTime dataPrevisto,
        String tipoPedido,
        LocalDateTime dataCadastro,
        Integer codPaciente,
        Integer codMedico,
        Integer codAtendente,
        String status) {

}

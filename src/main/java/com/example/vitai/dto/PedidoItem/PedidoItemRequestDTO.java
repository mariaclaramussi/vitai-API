package com.example.vitai.dto.PedidoItem;

import java.time.LocalDateTime;

public record PedidoItemRequestDTO(
                Integer id,
                String status,
                Integer codExameTipo,
                Integer codPedido,
                LocalDateTime dataRealizacao) {

}

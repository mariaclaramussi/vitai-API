package com.example.vitai.dto.Pedido;

import com.example.vitai.domain.Pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponseDTO {
    PedidoDTO pedido;

    public PedidoResponseDTO(Pedido pedido) {
        this.pedido = new PedidoDTO(pedido.getId(), pedido.getDataPedido(), pedido.getDataPrevisto(),
                pedido.getStatus(),
                pedido.getTipoPedido(), pedido.getDataCadastro(), pedido.getPaciente(), pedido.getMedico(),
                pedido.getAtendente(), pedido.getPedidosItensList());
    }
}

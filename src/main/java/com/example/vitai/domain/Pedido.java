package com.example.vitai.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_previsto")
    private LocalDateTime dataPrevisto;

    private String status;

    @Column(name = "tipo_pedido")
    private String tipoPedido;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToMany(mappedBy = "codPedido")
    @JsonManagedReference
    private List<PedidoItem> pedidosItensList;

    @Version
    private LocalDateTime timTimestamp;

    public void addPedidoItemToPedido(PedidoItem pedidoItem) {
        if (pedidosItensList == null)
            pedidosItensList = new ArrayList<PedidoItem>();

        pedidoItem.setCodPedido(this);
        pedidosItensList.add(pedidoItem);
    }
}

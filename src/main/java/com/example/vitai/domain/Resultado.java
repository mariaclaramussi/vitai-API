package com.example.vitai.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resultado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private LocalDateTime dataResultado;
    
    private LocalDateTime horaResultado;

    private boolean liberado;

    @ManyToOne
    @JoinColumn(name = "pedido_item_id", nullable = false)
    private PedidoItem codPedidoItem;

    @Version
    private LocalDateTime timTimestamp;
}

package com.example.vitai.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "resultado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "data_resultado")
    private LocalDate dataResultado;
    
    @Column(name = "hora_resultado")
    private LocalDateTime horaResultado;

    private boolean liberado;

    @ManyToOne
    @JoinColumn(name = "pedido_item_id", nullable = false)
    private PedidoItem codPedidoItem;

    @OneToMany(mappedBy = "codResultado")
    private List<ResultadoItem> resultadoItens;

    @Version
    private LocalDateTime timTimestamp;
}

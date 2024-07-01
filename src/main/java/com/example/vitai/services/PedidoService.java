package com.example.vitai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.Medico;
import com.example.vitai.domain.Paciente;
import com.example.vitai.domain.Pedido;
import com.example.vitai.domain.Pessoa;
import com.example.vitai.dto.Pedido.PedidoIdDTO;
import com.example.vitai.dto.Pedido.PedidoRequestDTO;
import com.example.vitai.repository.PedidoRepository;
import com.example.vitai.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PessoaRepository pessoaRepository;
    private final PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoIdDTO createPedido(PedidoRequestDTO pedido) {
        Pedido newPedido = new Pedido();

        newPedido.setDataPedido(pedido.dataPedido());
        newPedido.setDataPrevisto(pedido.dataPrevisto());
        newPedido.setTipoPedido(pedido.tipoPedido());
        newPedido.setDataCadastro(pedido.dataCadastro());
        newPedido.setStatus(pedido.status());

        Pessoa paciente = pessoaRepository.findById(pedido.codPaciente()).get();
        newPedido.setPaciente((Paciente) paciente);

        Pessoa medico = pessoaRepository.findById(pedido.codMedico()).get();
        newPedido.setMedico((Medico) medico);

        this.pedidoRepository.save(newPedido);

        return new PedidoIdDTO((newPedido.getId()));
    }

    public Optional<Pedido> getPedidoById(String id) {
        return pedidoRepository.findById(Integer.parseInt(id));
    }

    public List<Pedido> getPedidosByPacienteId(Integer id) {
        return pedidoRepository.findAllByPacienteId(id);
    }
}

package org.contas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.contas.controller.ContaType;
import org.contas.model.Cliente;
import org.contas.model.Conta;

@Getter
@AllArgsConstructor
public class LoginDTO {

    private boolean verUsuarioLogado = false;

    private String cliente;

    private int contaNumero;

    private int agencia;

    private double saldo;

    private int idCliente;

    private ContaType tipoConta;
}

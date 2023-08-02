package org.contas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.contas.controller.ContaType;

@Getter
@Setter
@AllArgsConstructor
public class Login {

    private boolean verUsuarioLogado = false;

    private String cliente;

    private int contaNumero;

    private int agencia;

    private double saldo;

    private int idCliente;

    private ContaType tipoConta;
}

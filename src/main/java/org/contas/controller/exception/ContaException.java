package org.contas.controller.exception;

import org.contas.service.ContaService;

public class ContaException extends RuntimeException{
    public void SaldoInsuficiente(String mensagem) {
        System.out.println("Saldo insuficiente");
    }
}

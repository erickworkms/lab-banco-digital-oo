package org.contas.exception;

public class ContaExpection extends RuntimeException{

    public void SaldoInsuficiente(String mensagem) {
        System.out.println("Saldo insuficiente");
    }
}

package org.contas.controller;

public enum ContaType {

    CONTACORRENTE(0),

    CONTAPOUPANCA(6.75),

    CONTASALARIO(0);

    private double rendimento;

    ContaType(double TipoConta) {
        this.rendimento = TipoConta;
    }
    public double getRendimento(){
        return rendimento;
    }
}

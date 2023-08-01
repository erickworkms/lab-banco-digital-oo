package org.contas.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.contas.controller.ContaType;;

@Getter
@Setter
public class Conta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	@NonNull
	private int idCliente;
	@NonNull
	private int agencia;
	@NonNull
	private int numero;
	private double saldo;

	private ContaType tipoConta;

	public Conta(@NonNull int idCliente,ContaType tipoConta) {
		this.idCliente = idCliente;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0.0;
		this.tipoConta =tipoConta;
	}




}

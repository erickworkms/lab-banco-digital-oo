package org.contas.dto;

import org.contas.model.Cliente;
import org.contas.model.IConta;

public abstract class ContaDTO implements IConta {

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
}

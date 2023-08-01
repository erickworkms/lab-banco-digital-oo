package org.contas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.contas.controller.ContaType;
import org.contas.model.Cliente;

@Getter
@Setter
@AllArgsConstructor
public class ContaDTO {

	private int idCliente;
	private int agencia;
	private int numero;
	private double saldo;
	private ContaType tipoConta;
}

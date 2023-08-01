package org.contas.service;

import org.contas.controller.ContaType;
import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.dto.LoginDTO;

public interface IConta {

	void criarConta(ContaDTO ContaDTO, ContaType tipoConta);
	void deletarConta(int contaId,ClienteDTO clienteDTO);
	boolean loginInicio();
	boolean loginUsuario(ClienteDTO clienteDTO);
	LoginDTO verInicioLogin();
	void criarUsuario(ClienteDTO clienteDTO);
	void deletarUsuario(ClienteDTO clienteDTO);
	void sacar(double valor,ContaDTO ContaDTO);
	void depositar(double valor,ContaDTO ContaDTO);
	void transferir(double valor, ContaDTO ContaDTO);
	void imprimirExtrato(ContaDTO ContaDTO);
}

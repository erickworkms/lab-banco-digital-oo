package org.contas.controller;

import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.dto.LoginDTO;
import org.contas.service.ContaService;
import org.contas.service.IConta;

public class ContaController implements IConta {

    private ContaService contaService = new ContaService();

    @Override
    public void criarConta(ContaDTO ContaDTO,ContaType tipoConta) {
        contaService.criarConta(ContaDTO,tipoConta);
    }

    @Override
    public void deletarConta(int contaId,ClienteDTO clienteDTO) {
        contaService.deletarConta(contaId,clienteDTO);
    }

    @Override
    public boolean loginInicio() {
        return contaService.loginInicio();
    }

    @Override
    public boolean loginUsuario(ClienteDTO clienteDTO) {
        return contaService.loginUsuario(clienteDTO);
    }

    @Override
    public LoginDTO verInicioLogin() {
        return contaService.verInicioLogin();
    }

    @Override
    public void criarUsuario(ClienteDTO clienteDTO) {
        contaService.criarUsuario(clienteDTO);
    }

    @Override
    public void deletarUsuario(ClienteDTO clienteDTO) {
        contaService.deletarUsuario(clienteDTO);
    }

    @Override
    public void sacar(double valor, ContaDTO ContaDTO) {
        contaService.sacar(valor,ContaDTO);
    }

    @Override
    public void depositar(double valor, ContaDTO ContaDTO) {
        contaService.depositar(valor,ContaDTO);
    }

    @Override
    public void transferir(double valor, ContaDTO ContaDTO) {
        contaService.transferir(valor,ContaDTO);
    }

    @Override
    public void imprimirExtrato(ContaDTO ContaDTO) {
        contaService.imprimirExtrato(ContaDTO);
    }
}

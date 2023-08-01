package org.contas.service;

import org.contas.controller.ContaType;
import org.contas.dao.Banco;
import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.dto.LoginDTO;

public final class ContaService implements IConta {

    private static Banco banco = new Banco();

    @Override
    public void criarConta(ContaDTO contaDTO,ContaType tipoConta)
    {
        banco.criaContas(contaDTO,tipoConta);
    }

    @Override
    public void deletarConta(int contaId,ClienteDTO clienteDTO)
    {
        boolean verDeletarConta =banco.deletaConta(1,clienteDTO);
        if(verDeletarConta){
            System.out.println("Usuario deletado do sistema com sucesso");
        }else
            System.out.println("Usuario não encontrado");
    }

    @Override
    public boolean loginInicio() {
        LoginDTO loginDTO = banco.verInicioLogin();
        if (loginDTO.isVerUsuarioLogado()) {
            System.out.println("Usuario" + loginDTO.getCliente() + "logado no sistema");
            return true;
        } else
            System.out.println("Usuario não logado");
        return false;
    }

    @Override
    public boolean loginUsuario(ClienteDTO clienteDTO) {
        boolean verSenha = banco.verSenhaLogin(clienteDTO);
        if (verSenha) {
            System.out.println("Usuario" + clienteDTO.getNome() + " foi logado no sistema");
            return true;
        } else
            System.out.println("Usuario não logado");
        return false;
    }

    @Override
    public LoginDTO verInicioLogin() {
        return banco.verInicioLogin();
    }

    @Override
    public void criarUsuario(ClienteDTO clienteDTO)
    {
        banco.criaUsuario(clienteDTO);
    }

    @Override
    public void deletarUsuario(ClienteDTO clienteDTO) {
        boolean verDeletarUsuario =banco.deletaUsuario(clienteDTO);
        if(verDeletarUsuario){
            System.out.println("Usuario deletado do sistema com sucesso");
        }else
            System.out.println("Usuario não encontrado");
    }

    @Override
    public void sacar(double valor, ContaDTO ContaDTO) {
        System.out.println(banco.sacar(valor, ContaDTO));
    }

    @Override
    public void depositar(double valor, ContaDTO ContaDTO) {
        System.out.println(banco.depositar(valor, ContaDTO));
    }

    @Override
    public void transferir(double valor, ContaDTO ContaDTO) {
        System.out.println(banco.transferir(valor, ContaDTO));
    }

    @Override
    public void imprimirExtrato(ContaDTO contaDTO) {
        ContaDTO contaExtrato = banco.imprimirExtrato(contaDTO);
        if (contaExtrato != null){
       //     System.out.printf("Titular: %s%n", contaExtrato.getNome());
            System.out.printf("Agencia: %d%n", contaExtrato.getAgencia());
            System.out.printf("Numero: %d%n", contaExtrato.getNumero());
            System.out.printf("Saldo: %.2f%n", contaExtrato.getSaldo());
        }
        else
            System.out.println("Erro ao tentar imprimir o extrato");
    }

  /*
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }*/
}

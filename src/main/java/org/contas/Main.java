package org.contas;

import org.contas.controller.ContaController;
import org.contas.controller.ContaType;
import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.dto.LoginDTO;
import org.contas.model.Cliente;
import org.contas.scanner.LerDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContaController controle = new ContaController();

        ClienteDTO dadosClienteInicial = new ClienteDTO(0, "teste", "teste de souza", "31/09/1960", "78945612332", null, "Rua do teste", "5511900000000", "teste@gmail.com", "teste");
        ContaDTO contaAtivaInicial = new ContaDTO(0, 0, 0, 0, ContaType.CONTAPOUPANCA);
        controle.criarUsuario(dadosClienteInicial);

        String escolha;
        boolean login = false;
        boolean contaEscolhida = false;
        int numeroConta;
        int agencia;
        int cpf;
        double valor;
        ContaDTO contaAtiva = new ContaDTO(0, 0, 0, 0, ContaType.CONTAPOUPANCA);
        ClienteDTO dadosCliente = new ClienteDTO(0, "", "", "0", "", null, "", "", "", "");
        LoginDTO dadosLogin = new LoginDTO(false, "", 0, 0, 0, 0, ContaType.CONTAPOUPANCA);
        System.out.println("Seja bem vindo!" +
                "\nVerificando login...");
        controle.loginInicio();
        while (true) {
            if (!login) {
                System.out.println("Usuario não logado no sistema");
                System.out.println("Por favor escolha uma das opções abaixo :");
                System.out.println("/////////////////////////////////////////");
                System.out.println("////       1 -  Fazer Login          ////");
                System.out.println("////       2 -  Criar Usuario        ////");
                System.out.println("////       3 -  Deletar Usuario      ////");

                escolha = LerDados.lerDado();

                switch (escolha) {
                    case "1":
                        System.out.println("Por favor, preencha os dados abaixo:");
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite os dados da agencia da conta ");
                        contaAtiva.setAgencia(Integer.parseInt(LerDados.lerDado()));

                        System.out.println("////////////////////////////////////");
                        System.out.println("     Digite o número da conta       ");
                        contaAtiva.setNumero(Integer.parseInt(LerDados.lerDado()));

                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o seu nome de usuario e login");
                        dadosCliente.setUsuario(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("  Digite a sua senha para o login   ");
                        dadosCliente.setSenha(LerDados.lerDado());

                        login = controle.loginUsuario(dadosCliente);
                        break;
                    case "2":
                        System.out.println("Por favor, preencha os dados abaixo:");
                        System.out.println("////////////////////////////////////");
                        System.out.println("   Digite o seu nome e sobrenome    ");
                        dadosCliente.setNome(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("   Digite sua data de nascimento    ");
                        dadosCliente.setDataNascimento(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("        Digite o seu cpf            ");
                        dadosCliente.setCpf(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("      Digite o seu endereço         ");
                        dadosCliente.setEndereco(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o seu telefone(5511 00000000)");
                        dadosCliente.setTelefone(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("         Digite o seu email         ");
                        dadosCliente.setEmail(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o seu nome de usuario e login");
                        dadosCliente.setUsuario(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("  Digite a sua senha para o login   ");
                        dadosCliente.setSenha(LerDados.lerDado());

                        controle.criarUsuario(dadosCliente);
                        break;
                    case "3":
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o seu nome de usuario e login");
                        dadosCliente.setUsuario(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("  Digite a sua senha para o login   ");
                        dadosCliente.setSenha(LerDados.lerDado());

                        controle.deletarUsuario(dadosCliente);
                        login = false;
                        break;
                    default:
                        break;
                }
                if (login) {
                    System.out.println("Parabéns, o login foi realizado com sucesso!");
                } else
                    System.out.println("O login falhou, tente novamente");
            }
            while (login) {
                dadosLogin = controle.verInicioLogin();
                System.out.println("/////////////////////////////////////////");
                System.out.println("/////////////////////////////////////////");
                System.out.println("Usuario : " + dadosLogin.getCliente());
                System.out.println("Conta : " + dadosLogin.getContaNumero());
                System.out.println("Agência : " + dadosLogin.getAgencia());
                System.out.println("Tipo : " + dadosLogin.getTipoConta());
                System.out.println("Saldo : " + dadosLogin.getSaldo());
                System.out.println("/////////////////////////////////////////");
                System.out.println("Por favor escolha uma das opções abaixo :");
                System.out.println("/////////////////////////////////////////");
                System.out.println("////       1 -  Criar Conta          ////");
                System.out.println("////       2 -  Escolher Conta       ////");
                System.out.println("////       3 -  Deletar Conta        ////");
                System.out.println("////       4 -  Deslogar             ////");
                System.out.println("////       5 -  Fechar Programa      ////");

                escolha = LerDados.lerDado();

                switch (escolha) {

                    case "1":
                        System.out.println("Por favor, preencha os dados abaixo:");
                        System.out.println("////////////////////////////////////");
                        System.out.println("  Qual o tipo de conta será criada? ");
                        System.out.println("1 - CONTACORRENTE");
                        System.out.println("2 - CONTAPOUPANCA");
                        System.out.println("3 - CONTASALARIO");
                        escolha = LerDados.lerDado();
                        contaAtiva.setIdCliente(dadosLogin.getIdCliente());
                        switch (escolha) {
                            case "1":
                                contaAtiva.setTipoConta(ContaType.CONTACORRENTE);
                                controle.criarConta(contaAtiva);
                                break;
                            case "2":
                                contaAtiva.setTipoConta(ContaType.CONTAPOUPANCA);
                                controle.criarConta(contaAtiva);
                                break;
                            case "3":
                                contaAtiva.setTipoConta(ContaType.CONTASALARIO);
                                controle.criarConta(contaAtiva);
                                break;
                            default:
                                System.out.println("Opção invalida");
                                break;
                        }

                        break;
                    case "2":
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o numero da sua conta");
                        numeroConta = Integer.parseInt(LerDados.lerDado());
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o numero da sua agencia");
                        agencia = Integer.parseInt(LerDados.lerDado());
                        boolean controleConta = controle.verContaEscolhida(numeroConta, agencia, dadosLogin.getCliente());
                        if (controleConta){
                            dadosLogin = controle.verInicioLogin();
                            contaEscolhida = true;
                        }
                        break;
                    case "3":
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o numero da sua conta");
                        numeroConta = Integer.parseInt(LerDados.lerDado());
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o numero da sua agencia");
                        agencia = Integer.parseInt(LerDados.lerDado());
                        controle.deletarConta(numeroConta, dadosCliente);
                        break;
                    case "4":
                        dadosLogin = null;
                        login = false;
                        break;
                    case "5":
                        System.out.println("Programa encerrado");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                while (contaEscolhida) {
                    dadosLogin = controle.verInicioLogin();
                    System.out.println("/////////////////////////////////////////");
                    System.out.println("/////////////////////////////////////////");
                    System.out.println("Usuario : " + dadosLogin.getCliente());
                    System.out.println("Conta : " + dadosLogin.getContaNumero());
                    System.out.println("Agência : " + dadosLogin.getAgencia());
                    System.out.println("Tipo : " + dadosLogin.getTipoConta());
                    System.out.println("Saldo : " + dadosLogin.getSaldo());
                    System.out.println("/////////////////////////////////////////");
                    System.out.println("Por favor escolha uma das opções abaixo :");
                    System.out.println("/////////////////////////////////////////");
                    System.out.println("////       1 -  Trocar conta          ////");
                    System.out.println("////       2 -  Depositar em conta    ////");
                    System.out.println("////       3 -  Saque em Conta        ////");
                    System.out.println("////       4 -  Transferir dinheiro   ////");
                    System.out.println("////       5 -  Extrato bancario      ////");
                    System.out.println("////       6 -  Deslogar              ////");
                    System.out.println("////       7 -  Fechar Programa       ////");

                    escolha = LerDados.lerDado();
                    switch (escolha) {

                        case "1":
                            System.out.println("////////////////////////////////////");
                            System.out.println("Digite o numero da sua conta");
                            numeroConta = Integer.parseInt(LerDados.lerDado());
                            System.out.println("////////////////////////////////////");
                            System.out.println("Digite o numero da sua agencia");
                            agencia = Integer.parseInt(LerDados.lerDado());
                            controle.verContaEscolhida(numeroConta, agencia, dadosLogin.getCliente());
                            dadosLogin = controle.verInicioLogin();

                            break;
                        case "2":
                            System.out.println("////////////////////////////////////");
                            System.out.println("    Escolha uma das opções abaixo   ");
                            System.out.println("    1- Depositar na minha conta     ");
                            System.out.println("2-Depositar na conta de outra pessoa");
                            escolha = LerDados.lerDado();
                            if (escolha.equals("1")) {
                                System.out.println("Digite o valor do deposito");
                                valor = Double.parseDouble(LerDados.lerDado());
                                contaAtiva.setAgencia(dadosLogin.getAgencia());
                                contaAtiva.setNumero(dadosLogin.getContaNumero());
                                controle.depositar(valor, contaAtiva, 0);
                                controle.verContaEscolhida(dadosLogin.getContaNumero(),dadosLogin.getAgencia(), dadosLogin.getCliente());
                            }else if (escolha.equals("2")) {
                                    System.out.println("////////////////////////////////////");
                                    System.out.println("Digite o numero da conta");
                                    numeroConta = Integer.parseInt(LerDados.lerDado());
                                    System.out.println("////////////////////////////////////");
                                    System.out.println("Digite o numero da agencia");
                                    agencia = Integer.parseInt(LerDados.lerDado());
                                    System.out.println("Digite o cpf do beneficiario");
                                    cpf = Integer.parseInt(LerDados.lerDado());
                                    System.out.println("Digite o valor do deposito");
                                    valor = Double.parseDouble(LerDados.lerDado());
                                    contaAtiva.setAgencia(agencia);
                                    contaAtiva.setNumero(numeroConta);
                                    controle.depositar(valor, contaAtiva, cpf);
                                }  else
                                System.out.println("Opção não encontrada");
                            break;
                        case "3":
                            System.out.println("////////////////////////////////////");
                            System.out.println("Digite o valor do deposito");
                            valor = Double.parseDouble(LerDados.lerDado());
                            controle.sacar(valor, contaAtiva);
                            controle.verContaEscolhida(dadosLogin.getContaNumero(),dadosLogin.getAgencia(), dadosLogin.getCliente());
                            break;
                        case "4":
                            System.out.println("////////////////////////////////////");
                            System.out.println("Digite o numero da conta");
                            numeroConta = Integer.parseInt(LerDados.lerDado());
                            System.out.println("////////////////////////////////////");
                            System.out.println("Digite o numero da agencia");
                            agencia = Integer.parseInt(LerDados.lerDado());
                            System.out.println("Digite o cpf do beneficiario");
                            cpf = Integer.parseInt(LerDados.lerDado());
                            System.out.println("Digite o valor do deposito");
                            valor = Double.parseDouble(LerDados.lerDado());
                            contaAtiva.setAgencia(agencia);
                            contaAtiva.setNumero(numeroConta);
                            controle.transferir(valor, contaAtiva, cpf);
                            break;
                        case "5":
                            dadosLogin = controle.verInicioLogin();
                            contaAtiva.setAgencia(dadosLogin.getAgencia());
                            contaAtiva.setNumero(dadosLogin.getContaNumero());
                            contaAtiva.setNumero(dadosLogin.getIdCliente());
                            controle.imprimirExtrato(contaAtiva);
                            break;
                        case "6":
                            dadosLogin = null;
                            login = false;
                            contaEscolhida = false;
                            break;
                        case "7":
                            System.out.println("Programa encerrado");
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
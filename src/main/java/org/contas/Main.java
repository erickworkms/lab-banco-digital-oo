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

        ClienteDTO dadosClienteInicial = new ClienteDTO(0,"teste","teste de souza","31/09/1960","78945612332",null,"Rua do teste","5511900000000","teste@gmail.com","teste");
        ContaDTO contaAtivaInicial = new ContaDTO(0,0,0,0, ContaType.CONTAPOUPANCA);
        controle.criarUsuario(dadosClienteInicial);

        String escolha;
        boolean login = false;
        ContaDTO contaAtiva = new ContaDTO(0,0,0,0,ContaType.CONTAPOUPANCA);
        ClienteDTO dadosCliente = new ClienteDTO(0,"","","0","",null,"","","","");
        LoginDTO dadosLogin = new LoginDTO(false,"",0,"",0,0,ContaType.CONTAPOUPANCA);
        System.out.println("Seja bem vindo!" +
                "\nVerificando login...");
        controle.loginInicio();
        while (true){
            if (!login){
                System.out.println("Usuario não logado no sistema");
                System.out.println("Por favor escolha uma das opções abaixo :");
                System.out.println("/////////////////////////////////////////");
                System.out.println("////       1 -  Fazer Login          ////");
                System.out.println("////       2 -  Criar Usuario        ////");
                System.out.println("////       3 -  Deletar Usuario      ////");
                System.out.println("////       4 -  Criar Conta          ////");
                System.out.println("////       5 -  Fechar Conta         ////");

                escolha= LerDados.lerDado();

                switch (escolha){
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

                        //contaAtiva.setCliente(new Cliente(0,dadosCliente.getUsuario(),"","0","",null,"","","", dadosCliente.getSenha()));
                        login=controle.loginUsuario(dadosCliente);
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
                        /*contaAtiva.setCliente(new Cliente(0,
                                dadosCliente.getUsuario(),
                                dadosCliente.getNome(),
                                dadosCliente.getDataNascimento(),
                                dadosCliente.getCpf(),null,
                                dadosCliente.getEndereco(),
                                dadosCliente.getTelefone(),
                                dadosCliente.getEmail(),
                                dadosCliente.getSenha()));*/
                        controle.criarUsuario(dadosCliente);
                        break;
                    case "3":
                        System.out.println("////////////////////////////////////");
                        System.out.println("Digite o seu nome de usuario e login");
                        dadosCliente.setUsuario(LerDados.lerDado());

                        System.out.println("////////////////////////////////////");
                        System.out.println("  Digite a sua senha para o login   ");
                        dadosCliente.setSenha(LerDados.lerDado());

                       // contaAtiva.setCliente(new Cliente(0,dadosCliente.getUsuario(),"","0","",null,"","","", dadosCliente.getSenha()));
                        controle.deletarUsuario(dadosCliente);
                        login=false;
                        break;
                    default:
                        break;
                }
                if (login) {
                    System.out.println("Parabéns, o login foi realizado com sucesso!");
                }
                else
                System.out.println("O login falhou, tente novamente");
            } else if (login) {
                controle.verInicioLogin();
                System.out.println("/////////////////////////////////////////");
                System.out.println("/////////////////////////////////////////");
                System.out.println("Usuario : "+dadosClienteInicial.getNome());
                System.out.println("Conta : "+contaAtiva.getNumero());
                System.out.println("Agência : "+contaAtiva.getAgencia());
                System.out.println("/////////////////////////////////////////");
                System.out.println("Por favor escolha uma das opções abaixo :");
                System.out.println("/////////////////////////////////////////");
                System.out.println("////       1 -  Criar Conta          ////");
                System.out.println("////       2 -  Fechar Conta         ////");
                System.out.println("////       3 -  Deletar Usuario      ////");
                System.out.println("////       4 -  Criar Conta          ////");
                System.out.println("////       5 -  Fechar Conta         ////");
                LerDados.lerDado();

            }

        }
    }
}
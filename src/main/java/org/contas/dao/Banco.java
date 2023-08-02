package org.contas.dao;

import lombok.Getter;
import lombok.Setter;
import org.contas.controller.ContaType;
import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.dto.LoginDTO;
import org.contas.model.Cliente;
import org.contas.model.Conta;
import org.contas.model.Login;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {

    private List<Conta> contas= new ArrayList<>();

    private Login informacaoLogin = new Login(false, null, 0,0,0,0,ContaType.CONTAPOUPANCA);

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes.add(clientes);
    }

    private List<Cliente> clientes = new ArrayList<>();

    public List<Conta> getContas() {
        return contas;
    }

    public void criaContas(ContaDTO contaDTO) {
        for (Cliente verCliente : clientes) {
            if (contaDTO.getIdCliente() == verCliente.getIdCliente()) {
                int numeroConta;
                if (verCliente.getContas()!= null){
                    numeroConta = verCliente.getContas().size();
                }
                else
                    numeroConta = 1;

                Conta conta = new Conta(contaDTO.getIdCliente(),contaDTO.getTipoConta(),numeroConta);
                verCliente.addConta(conta);
                contas.add(conta);
                System.out.println("Conta criada com sucesso!  ");
                System.out.println("Segue os dados de sua conta");
                System.out.println("ID DE CLIENTE: "+conta.getIdCliente());
                System.out.println("AGENCIA: "+conta.getAgencia());
                System.out.println("NUMERO CONTA: "+conta.getNumero());
                System.out.println("TIPO DE CONTA: "+conta.getTipoConta());
                System.out.println("//////////////////////////////////////");
            }
            else
                System.out.println("Usuario criado falhou");
        }
    }

    public boolean deletaConta(int contaId, ClienteDTO clienteDTO) {

        if (informacaoLogin.isVerUsuarioLogado()) {
            for (Cliente verCliente : clientes) {
                if (clienteDTO.getCpf().equals(verCliente.getCpf())) {
                    for (Conta verContas : clienteDTO.getContas()) {
                        if (contaId == verContas.getNumero()) {
                            contas.remove(verContas);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void criaUsuario(ClienteDTO clienteDTO) {

        VerLogin verLogin = new VerLogin();

        if ((clientes != null && verLogin.verDispUsuario(clienteDTO, clientes))) {
            Cliente dadosConta = new Cliente(
                    clientes.size() + 1,
                    clienteDTO.getUsuario(),
                    clienteDTO.getNome(),
                    clienteDTO.getDataNascimento(),
                    clienteDTO.getCpf(),
                    clienteDTO.getContas(),
                    clienteDTO.getEndereco(),
                    clienteDTO.getTelefone(),
                    clienteDTO.getEmail(),
                    clienteDTO.getSenha());
            clientes.add(dadosConta);
            atualizaInformacaoLoginUsuario(dadosConta);
            System.out.println("Usuario criado com sucesso");
            System.out.println("NOME: "+dadosConta.getNome());
            System.out.println("DATA DE NASCIMENTO: "+dadosConta.getDataNascimento());
            System.out.println("CPF: "+dadosConta.getCpf());
            System.out.println("ENDERECO: "+dadosConta.getEndereco());
            System.out.println("TELEFONE: "+dadosConta.getTelefone());
            System.out.println("EMAIL: "+dadosConta.getEmail());
            System.out.println("USUARIO: "+dadosConta.getUsuario());
            System.out.println("SENHA: "+dadosConta.getSenha());
            System.out.println("//////////////////////////////////////");

            System.out.println("Usuario criado com sucesso");
        } else
            System.out.println("CPF JÁ EXISTE NO BANCO DE DADOS");
    }

    public boolean deletaUsuario(ClienteDTO clienteDTO) {

        if (informacaoLogin.isVerUsuarioLogado()) {
            for (Cliente verCliente : clientes) {
                if (clienteDTO.getUsuario().equals(verCliente.getUsuario())) {
                    clientes.remove(verCliente);
                    return true;
                }
            }
        }
        return false;
    }

    public LoginDTO verInicioLogin() {
        return new LoginDTO(
                informacaoLogin.isVerUsuarioLogado(),
                informacaoLogin.getCliente(),
                informacaoLogin.getContaNumero(),
                informacaoLogin.getAgencia(),
                informacaoLogin.getSaldo(),
                informacaoLogin.getIdCliente(),
                informacaoLogin.getTipoConta()
                );
    }

    public boolean verSenhaLogin(ClienteDTO clienteDTO) {
        VerLogin verLogin = new VerLogin();
        boolean verSenhaCorreta = verLogin.verSenhaLogin(clienteDTO, clientes);
        if (verSenhaCorreta) {
            System.out.println("Usuario logado corretamente");
        }
        return verSenhaCorreta;
    }

    public void verContaEscolhida(int numeroConta,int agencia,String usuario) {

            Cliente clienteLogin = verClientes(usuario);
            Conta contalogin = verContas(numeroConta,agencia,clienteLogin);
            if (contalogin != null){
                atualizaInformacaoLoginUsuario(clienteLogin);
                atualizaInformacaoConta(contalogin);
            }else
                System.out.println("Conta não existente no sistema");
        }
    public void atualizaInformacaoLoginUsuario(Cliente dadosCliente){
        informacaoLogin.setCliente(dadosCliente.getUsuario());
        informacaoLogin.setIdCliente(dadosCliente.getIdCliente());
    }
    public void atualizaInformacaoConta(Conta dadosConta){
        informacaoLogin.setTipoConta(dadosConta.getTipoConta());
        informacaoLogin.setContaNumero(dadosConta.getNumero());
        informacaoLogin.setAgencia(dadosConta.getAgencia());
        informacaoLogin.setSaldo(dadosConta.getSaldo());
        informacaoLogin.setIdCliente(dadosConta.getIdCliente());
    }

    public Conta verContas(int numeroConta,int agencia,Cliente cliente){
        for (Conta verConta : cliente.getContas()) {
            if (numeroConta == verConta.getNumero() && agencia == verConta.getAgencia()) {
                return verConta;
            }
        }return null;
    }

    public Cliente verClientes(String usuario){
        for (Cliente verCliente : clientes) {
            if (usuario.equals(verCliente.getUsuario())) {
                return verCliente;
            }
        }return null;
    }
    public String sacar(double valor, ContaDTO contaDTO) {

        if (valor >= informacaoLogin.getSaldo()) {
            for (int i = 0; i < contas.size(); i++) {
                if (contaDTO.getIdCliente() == contas.get(i).getIdCliente() && informacaoLogin.getIdCliente()
                        == contas.get(i).getNumero()) {
                    contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);

                    return "O saque de " + valor + " reais foi realizado com sucesso.";
                }
            }
        }
        return "Saldo insuficiente na sua conta.";
    }

    public String depositar(double valor, ContaDTO contaDTO) {

        for (int i = 0; i < contas.size(); i++) {
            if (contaDTO.getIdCliente() == contas.get(i).getIdCliente()
                    && informacaoLogin.getContaNumero() == contas.get(i).getNumero()) {
                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);

                return "O deposito de " + valor + " reais foi realizado com sucesso.";
            }
        }
        return "Não foi possivel fazer o deposito";
    }

    public String transferir(double valor, ContaDTO contaDTO) {
        if (valor >= informacaoLogin.getSaldo()) {
            for (int i = 0; i < contas.size(); i++) {
                if (informacaoLogin.getIdCliente() == contas.get(i).getIdCliente()
                        && informacaoLogin.getContaNumero() == contas.get(i).getNumero()) {
                    contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);

                } else if (contas.get(i).getNumero() == contaDTO.getNumero() &&
                        contas.get(i).getAgencia() == contaDTO.getAgencia()) {
                    contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                }
            }
            return "O deposito de " + valor + " reais foi realizado com sucesso.";
        }
        return "Não foi possivel fazer a transferencia.";
    }

    public ContaDTO imprimirExtrato(ContaDTO contaDTO) {

        ContaDTO contaExtrato = null;
        if (informacaoLogin.isVerUsuarioLogado()){
            for (Cliente verCliente : clientes) {
                if (informacaoLogin.getCliente().equals(verCliente.getUsuario())) {
                    for (int i = 0; i < contas.size(); i++) {
                        if (contaDTO.getIdCliente() == contas.get(i).getIdCliente()
                                && informacaoLogin.getContaNumero() == contas.get(i).getNumero()) {
                            contaExtrato = new ContaDTO(
                                    contas.get(i).getIdCliente(),
                                    contas.get(i).getAgencia(),
                                    contas.get(i).getNumero(),
                                    contas.get(i).getSaldo(),
                                    contas.get(i).getTipoConta()
                                    );
                            return contaExtrato;
                        }
                    }
                }
            }
        }
        return null;
    }
}

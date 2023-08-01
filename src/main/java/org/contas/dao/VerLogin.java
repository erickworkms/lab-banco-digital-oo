package org.contas.dao;

import org.contas.dto.ClienteDTO;
import org.contas.dto.ContaDTO;
import org.contas.model.Cliente;

import java.util.List;

public class VerLogin {
    public boolean verDispUsuario(ClienteDTO clienteDTO, List<Cliente> clientes) {
        if (clientes != null) {
            for (Cliente verCliente : clientes) {
                if (clienteDTO.getCpf().equals(verCliente.getCpf())) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean verSenhaLogin(ClienteDTO clienteDTO, List<Cliente> clientes) {
       if (clientes != null) {
           for (Cliente verCliente : clientes) {
               if (clienteDTO.getUsuario().equals(verCliente.getUsuario())) {
                   if (clienteDTO.getSenha().equals(verCliente.getSenha())) {
                       return true;
                   } else
                       return false;
               }
           }
       }
        return false;
    }
    public boolean verDeletarUsuario(ClienteDTO clienteDTO, List<Cliente> clientes) {
        for (Cliente verCliente : clientes) {
            if (clienteDTO.getCpf().equals(verCliente.getCpf())) {
                if (clienteDTO.getSenha().equals(verCliente.getSenha())){
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}

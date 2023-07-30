package org.contas.model;

import java.util.List;

public class Cliente {

	private String nome;
	private String dataNascimento;
	private String cpf;
	private List<Conta> Contas;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

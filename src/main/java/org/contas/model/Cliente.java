package org.contas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class Cliente {

	@NonNull
	private int idCliente;
	@NonNull
	private String usuario="";
	@NonNull
	private String nome="";
	@NonNull
	private String dataNascimento="";
	@NonNull
	private String cpf="";

	private List<Conta> contas;
	@NonNull
	private String endereco="";
	@NonNull
	private String telefone="";
	@NonNull
	private String email="";
	@NonNull
	private String senha="";

	public void addConta(Conta conta){
		if (contas == null){
			contas = new ArrayList<>();
		}
		contas.add(conta);
	}
}

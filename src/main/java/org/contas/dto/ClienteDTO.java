package org.contas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.contas.model.Conta;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {

	private int id;

	private String usuario="";

	private String nome="";

	private String dataNascimento="";

	private String cpf="";

	private List<Conta> Contas = new ArrayList();

	private String endereco="";

	private String telefone="";

	private String email="";

	private String senha="";

}

package Model;

import java.util.Date;

public class Motorista extends Funcionario {
	String cnh;

	public Motorista(int codFuncionario, String cpf, String nome, String cargo, Date dataNascimento,
			Date dataContratacao, double salario, String cnh) {
		super(codFuncionario, cpf, nome, cargo, dataNascimento, dataContratacao, salario);
		this.cnh = cnh;
	}
	
}

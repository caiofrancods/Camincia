package Model;

import java.util.Date;

public class Funcionario {
	private int codFuncionario;
	private String cpf;
	private String nome;
	private String cargo;
	private Date dataNascimento;
	private Date dataContratacao;
	private Date dataDemissao;
	private double salario;
	
	public Funcionario(int codFuncionario, String cpf, String nome, String cargo, Date dataNascimento, Date dataContratacao, double salario) {
		if(cpf != null && nome != null && cargo != null) {
			this.codFuncionario = codFuncionario;
			this.cpf = cpf;
			this.nome = nome;
			this.cargo = cargo;
			this.dataNascimento = dataNascimento;
			this.dataContratacao = dataContratacao;
			this.salario = salario;
		}

	}
	
	public int getCodigo() {
		return codFuncionario;
	}

	
	
}

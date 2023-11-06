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

	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public double getSalario() {
		return salario;
	}

	public int getCnh() {
		return 0;
	}
	public void setDataDemissao() {
		this.dataDemissao = new Date();
	}
	
	
}

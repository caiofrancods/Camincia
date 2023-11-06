package Repo;

import Model.Funcionario;
import java.util.Arrays;
import java.util.List;

public class RepoFuncionario{
	
	Funcionario[] funcionarios;
	
	public static int quant;
	
	public RepoFuncionario(){
		funcionarios = new Funcionario[10];
		quant = 0;
	}

	public boolean adicionar(Funcionario caminhao) {
		if(caminhao != null) {
			for(int i = 0; i < funcionarios.length; i++) {
				if(funcionarios[i] == null) {
					funcionarios[i] = caminhao;
					quant++;
					return true;
				}
			}
		}
		return false;
	}

	public boolean excluir(int codigo) {
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				if(funcionarios[i].getCodigo() == codigo) {
					funcionarios[i] = null;
					quant--;
					return true;
				}
			}
		}
		return false;
	}

	public boolean alterar(Funcionario func) {
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				if(funcionarios[i].getCodigo() == func.getCodigo()) {
					funcionarios[i] = func;
					return true;
				}
			}
		}
		return false;
	}

	public List<Funcionario> listar() {
		Funcionario[] vetAux = new Funcionario[quant];
		int k = 0;
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				vetAux[k] = funcionarios[i];
				k++;
			}
		}
		List<Funcionario> lista = Arrays.asList(vetAux);
		return lista;
	}
	
	public boolean buscarPorCodigo(int codigo) {
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				if(funcionarios[i].getCodigo() == codigo) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Funcionario getFuncionario(int codigo) {
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				if(funcionarios[i].getCodigo() == codigo) {
					return funcionarios[i];
				}
			}
		}
		return null;
	}
	
	public boolean demitir(int codigo) {
		for(int i = 0; i < funcionarios.length; i++) {
			if(funcionarios[i] != null) {
				if(funcionarios[i].getCodigo() == codigo) {
					funcionarios[i].setDataDemissao();
					return true;
				}
			}
		}
		return false;
	}
		
	public int getProxCodigo() {
		return quant;
	}
	
}
package Control;

import javax.swing.text.View;

import Model.Funcionario;
import Repo.RepoFuncionario;

public class ControlFuncionario{
	
	private RepoFuncionario repo;
	
	public ControlFuncionario() {
		repo = new RepoFuncionario();
	}
	
	public boolean adicionar() {
		Funcionario func = view.adicionar();
		if(func != null) {
			return repo.adicionar(func);
		}else {
			return false;
		}
	}
	
	public boolean excluir() {
		int codigo = view.excluir();
		if(repo.buscarPorCodigo(codigo)) {
			return repo.excluir(codigo);
		}else {
			return false;
		}
	}
	
	public boolean alterar() {
		int codigo = view.codigoAlterar();
		if(repo.buscarPorCodigo(codigo)) {
			Funcionario funcs = view.alterar();
			if(funcs != null) {
				return repo.alterar(funcs);
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	

	public Funcionario listar() {
		Funcionario[] funcionarios = repo.listar();
		view.listar(funcionarios);
		return null;
	}
	
	public boolean demitir() {
		int codigo = view.demitir();
		if(repo.buscarPorCodigo(codigo)) {
			return repo.demitir(codigo);
		}else {
			return false;
		}
	}
}

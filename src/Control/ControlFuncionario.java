package Control;

import Model.Funcionario;
import Repo.RepoFuncionario;
import View.ViewFuncionario;
import java.util.List;

public class ControlFuncionario{
	
	private RepoFuncionario repo;
	private ViewFuncionario view;
	
	public ControlFuncionario() {
		repo = new RepoFuncionario();
		view = new ViewFuncionario();
	}
	
	public boolean adicionar() {
		Funcionario func = view.adicionar(repo.getProxCodigo());
		if(func != null) {
			return repo.adicionar(func);
		}else {
			return false;
		}
	}
	
	public boolean excluir() {
		int codigo = view.excluir(repo.listar());
		if(repo.buscarPorCodigo(codigo)) {
			return repo.excluir(codigo);
		}else {
			return false;
		}
	}
	
	public boolean alterar() {
		int codigo = view.codigoAlterar(repo.listar());
		if(repo.buscarPorCodigo(codigo)) {
			Funcionario funcs = view.alterar(repo.getFuncionario(codigo));
			if(funcs != null) {
				return repo.alterar(funcs);
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	

	public void listar() {
		List<Funcionario> funcionarios = repo.listar();
		view.listar(funcionarios);
	}
	
	public boolean demitir() {
		int codigo = view.demitir(repo.listar());
		if(repo.buscarPorCodigo(codigo)) {
			return repo.demitir(codigo);
		}else {
			return false;
		}
	}
}

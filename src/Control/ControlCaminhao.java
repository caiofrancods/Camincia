package Control;

import Model.Caminhao;
import Repo.RepoCaminhao;

public class ControlCaminhao{
	
	RepoCaminhao repo;
	
	public ControlCaminhao() {
		repo = new RepoCaminhao();
	}
	
	public boolean adicionar() {
		Caminhao caminhao = view.adicionar();
		if(caminhao != null) {
			return repo.adicionar(caminhao);
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
			Caminhao caminhao = view.alterar();
			if(caminhao != null) {
				return repo.alterar(caminhao);
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public void listar() {
		Caminhao[] caminhoes = repo.listar();
		view.listar(caminhoes);
	}
}


package Control;

import Model.Caminhao;
import Repo.RepoCaminhao;
import View.ViewCaminhao;
import java.util.List;

public class ControlCaminhao{
	
	RepoCaminhao repo;
	ViewCaminhao view;
	
	public ControlCaminhao() {
		repo = new RepoCaminhao();
		view = new ViewCaminhao();
	}
	
	public boolean adicionar() {
		Caminhao caminhao = view.adicionar(repo.getProxCodigo());
		System.out.println(caminhao);
		if(caminhao != null) {
			return repo.adicionar(caminhao);
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
			Caminhao caminhao = view.alterar(repo.getCaminhao(codigo));
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
		List<Caminhao> caminhoes = repo.listar();
		view.listar(caminhoes);
	}
	
	public void init() {
		Caminhao c1 = new Caminhao(0, "FJF4585", "Volks", 2015, 2000.0);
		repo.adicionar(c1);
		Caminhao c2 = new Caminhao(1, "NHE8759", "Mercedes", 2010, 1500.0);
		repo.adicionar(c2);
	}
}


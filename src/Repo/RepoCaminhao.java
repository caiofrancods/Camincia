package Repo;

import java.util.Arrays;
import java.util.List;

import Model.Caminhao;

public class RepoCaminhao{
	
	Caminhao[] caminhoes;
	
	public static int quant;
	
	public RepoCaminhao(){
		caminhoes = new Caminhao[10];
		quant = 0;
	}

	public boolean adicionar(Caminhao caminhao) {
		if(caminhao != null) {
			for(int i = 0; i < caminhoes.length; i++) {
				if(caminhoes[i] == null) {
					caminhoes[i] = caminhao;
					quant++;
					return true;
				}
			}
		}
		return false;
	}

	public boolean excluir(int codigo) {
		for(int i = 0; i < caminhoes.length; i++) {
			if(caminhoes[i] != null) {
				if(caminhoes[i].getCodigo() == codigo) {
					caminhoes[i] = null;
					quant--;
					return true;
				}
			}
		}
		return false;
	}

	public boolean alterar(Caminhao caminhao) {
		for(int i = 0; i < caminhoes.length; i++) {
			if(caminhoes[i] != null) {
				if(caminhoes[i].getCodigo() == caminhao.getCodigo()) {
					caminhoes[i] = caminhao;
					return true;
				}
			}
		}
		return false;
	}

	public List<Caminhao> listar() {
		Caminhao[] vetAux = new Caminhao[quant];
		int k = 0;
		for(int i = 0; i < caminhoes.length; i++) {
			if(caminhoes[i] != null) {
				vetAux[k] = caminhoes[i];
				k++;
			}
		}
		List<Caminhao> lista = Arrays.asList(vetAux);
		return lista;
	}
	
	public boolean buscarPorCodigo(int codigo) {
		for(int i = 0; i < caminhoes.length; i++) {
			if(caminhoes[i] != null) {
				if(caminhoes[i].getCodigo() == codigo) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Caminhao getCaminhao(int codigo) {
		for(int i = 0; i < caminhoes.length; i++) {
			if(caminhoes[i] != null) {
				if(caminhoes[i].getCodigo() == codigo) {
					return caminhoes[i];
				}
			}
		}
		return null;
	}
	
	public int getProxCodigo() {
		return quant;
	}
}

package View;

import java.util.List;

import Model.Caminhao;

public class ViewCaminhao {
	
	public Caminhao adicionar(int proxcod) {
		JanelaCadastroCaminhao janela = new JanelaCadastroCaminhao(proxcod);
		return janela.getCaminhao();
	}
	
	public int excluir(List<Caminhao> caminhoes) {
		JanelaSelecaoExclusaoCaminhao j = new JanelaSelecaoExclusaoCaminhao(caminhoes);
		try{
			Caminhao f = j.getCaminhao();
			return f.getCodigo();
		}catch (Exception e) {
			return -1;
		}
	}
	
	public int codigoAlterar(List<Caminhao> caminhoes) {
		JanelaSelecaoAlteracaoCaminhao j = new JanelaSelecaoAlteracaoCaminhao(caminhoes);
		try{
			Caminhao f = j.getCaminhao();
			return f.getCodigo();
		}catch (Exception e) {
			return -1;
		}
		
	}
	
	public Caminhao alterar(Caminhao c) {
		JanelaCadastroCaminhao janela = new JanelaCadastroCaminhao(c);
		return janela.getCaminhao();
	}
	
	public void listar(List<Caminhao> caminhoes) {
		new JanelaListagemCaminhao(caminhoes);
	}
	
}

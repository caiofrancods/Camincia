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
		Caminhao f = j.getCaminhao();
		return f.getCodigo();
	}
	
	public int codigoAlterar(List<Caminhao> caminhoes) {
		JanelaSelecaoAlteracaoCaminhao j = new JanelaSelecaoAlteracaoCaminhao(caminhoes);
		Caminhao f = j.getCaminhao();
		return f.getCodigo();
	}
	
	public Caminhao alterar(Caminhao c) {
		JanelaCadastroCaminhao janela = new JanelaCadastroCaminhao(c);
		return janela.getCaminhao();
	}
	
	public void listar(List<Caminhao> caminhoes) {
		new JanelaListagemCaminhao(caminhoes);
	}
	
}

package View;

import Model.Funcionario;
import java.util.List;

public class ViewFuncionario {
	
	public Funcionario adicionar(int proxcod) {
		JanelaCadastroFuncionario janela = new JanelaCadastroFuncionario(proxcod);
		return janela.getFuncionario();
	}
	
	public int excluir(List<Funcionario> funcionarios) {
		JanelaSelecaoExclusaoFuncionario j = new JanelaSelecaoExclusaoFuncionario(funcionarios);
		try{
			Funcionario f = j.getFuncionario();
			return f.getCodigo();
		}catch (Exception e) {
			return -1;
		}
		
	}
	
	public int codigoAlterar(List<Funcionario> funcionarios) {
		JanelaSelecaoAlteracaoFuncionario j = new JanelaSelecaoAlteracaoFuncionario(funcionarios);
		try{
			Funcionario f = j.getFuncionario();
			return f.getCodigo();
		}catch (Exception e) {
			return -1;
		}
	}
	
	public Funcionario alterar(Funcionario f) {
		JanelaCadastroFuncionario janela = new JanelaCadastroFuncionario(f);
		return janela.getFuncionario();
	}
	
	public void listar(List<Funcionario> funcionarios) {
		new JanelaListagemFuncionario(funcionarios);
	}
	
	public int demitir(List<Funcionario> funcionarios) {
		JanelaDemitirFuncionario j = new JanelaDemitirFuncionario(funcionarios);
		Funcionario f = j.getFuncionario();
		return f.getCodigo();
	}
}

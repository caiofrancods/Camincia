package View;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Funcionario;
import Model.Motorista;

public class JanelaSelecaoExclusaoFuncionario extends JanelaListagemFuncionario{
	private Funcionario funcionario;

	private JButton btSelecao;

	public JanelaSelecaoExclusaoFuncionario(List<Funcionario> funcionarios) {
		super(funcionarios); // chama o construtor da superclasse JanelaListagemAluno

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	@Override
	protected void initGUI() {
		super.initGUI();
		// permite selecionar apenas uma unica linha
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// para inserir o botao excluir à esquerda
		panelBotoes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		btFechar.setText("Cancelar");

		btSelecao = new JButton();
		btSelecao.setEnabled(false);
		btSelecao.addActionListener(new ExcluirListener());
		panelBotoes.add(btSelecao);

		// Evento de selecao de linha da tabela
		tabela.getSelectionModel()
				.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						btSelecao.setEnabled(true);
					}
				});
		setTitle("Selecione um funcionário para excluir");
		btSelecao.setText("Excluir");

	}

	// classe interna (a JanelaSelecaoAluno)
	private class ExcluirListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = tabela.getSelectedRow();
			funcionario = model.getFuncionario(linhaSelecionada);
			dispose();
		}

	}
}
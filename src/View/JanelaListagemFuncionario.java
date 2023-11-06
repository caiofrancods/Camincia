package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Funcionario;
import Model.Motorista;

public class JanelaListagemFuncionario extends JDialog{
	protected List<Funcionario> funcionarios;
	protected JButton btFechar;
	protected JPanel panelBotoes;
	protected JTable tabela;
	protected FuncionarioTableModel model;

	public JanelaListagemFuncionario(List<Funcionario> funcionarios) {
		super(); // chama construtor de JDialog
		this.funcionarios = funcionarios;
		initGUI();
		setVisible(true);
	}

	protected void initGUI() {

		setModal(true);
		this.setTitle("Listagem de Funcionarios");
		// tamanho para janela (largura,altura) em pixels
		setSize(800, 480);

		// posiciona a janela em relacao a outra janela
		// null: no meio da tela
		setLocationRelativeTo(null);
		// supondo que a janela seja uma janela principal,
		// fechar a janela deve encerrar a aplicacao
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Nao permite alterar o tamanho da janela
		// setResizable(false);

		model = new FuncionarioTableModel(funcionarios);
		tabela = new JTable(model);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(230);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(6).setResizable(false);

		// nao permite alteracao da ordem das colunas
		tabela.getTableHeader().setReorderingAllowed(false);

		JPanel panel = (JPanel) getContentPane();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

		JScrollPane spFuncionario = new JScrollPane(tabela,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(spFuncionario, BorderLayout.CENTER);

		panelBotoes = new JPanel();
		// panelBotoes.setBackground(Color.MAGENTA);
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		// add(panelBotoes);
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);

		btFechar = new JButton("Fechar");
		btFechar.setBounds(380, 360, 100, 25);
		// classe anonima
		// criar um objeto de uma classe que assina uma interface mas sem
		// criar a classe
		btFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBotoes.add(btFechar);
	}
}
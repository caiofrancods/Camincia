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

import Model.Caminhao;


public class JanelaListagemCaminhao extends JDialog {
	protected List<Caminhao> caminhoes;
	protected JButton btFechar;
	protected JPanel panelBotoes;
	protected JTable tabela;
	protected CaminhaoTableModel model;

	public JanelaListagemCaminhao(List<Caminhao> caminhoes) {
		super(); // chama construtor de JDialog
		this.caminhoes = caminhoes;
		initGUI();
		setVisible(true);
	}

	protected void initGUI() {

		setModal(true);
		this.setTitle("Listagem de Caminhao");
		setSize(800, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		model = new CaminhaoTableModel(caminhoes);
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

		tabela.getTableHeader().setReorderingAllowed(false);

		JPanel panel = (JPanel) getContentPane();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

		JScrollPane spCaminhao = new JScrollPane(tabela,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(spCaminhao, BorderLayout.CENTER);

		panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);

		btFechar = new JButton("Fechar");
		btFechar.setBounds(380, 360, 100, 25);
		btFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBotoes.add(btFechar);
	}
}

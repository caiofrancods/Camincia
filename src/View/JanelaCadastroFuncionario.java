package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Model.Funcionario;
import Model.Motorista;


public class JanelaCadastroFuncionario extends JDialog implements ActionListener {
	private Funcionario funcionario;

	private JTextField tfCodFuncionario;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfCNH;
	private JComboBox<String> cbCargo;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfDataContratacao;
	private JTextField tfSalario;

	private JButton btSalvar;
	private JButton btCancelar;

	public JanelaCadastroFuncionario(int proxcodigo) {
		super();
		initGUI();
		tfCodFuncionario.setText(String.valueOf(proxcodigo));
		setVisible(true);
	}
	
	public JanelaCadastroFuncionario(Funcionario a) {
		super();
		initGUI();

		setTitle("Edicao Funcionario");
		// preencher os textfields
		funcionario = a;
		tfCodFuncionario.setText(String.valueOf(a.getCodigo()));
		tfSalario.setText(String.valueOf(a.getSalario()));
		tfNome.setText(a.getNome());
//		if(a instanceof Motorista) {
//			tfCNH.setText(((Motorista) a).getCnh());
//		}
		tfCPF.setText(a.getCpf());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataN = sdf.format(a.getDataNascimento());
		tfDataNascimento.setText(dataN);
		String dataC = sdf.format(a.getDataContratacao());
		tfDataContratacao.setText(dataC);
        cbCargo.setSelectedItem(a.getCargo());

		setVisible(true);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	private void initGUI() {
	    setModal(true);
	    setTitle("Cadastro Funcionário");
	    setSize(510, 480);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    getContentPane().add(panel, BorderLayout.CENTER);


	    JLabel lbCodFuncionario = new JLabel("Código do Funcionário");
	    lbCodFuncionario.setBounds(10, 10, 80, 25);
	    panel.add(lbCodFuncionario);
	    tfCodFuncionario = new JTextField();
	    tfCodFuncionario.setEditable(false);
	    tfCodFuncionario.setBounds(10, 35, 70, 25);
	    panel.add(tfCodFuncionario);


	    JLabel lbNome = new JLabel("Nome");
	    lbNome.setBounds(90, 10, 50, 25);
	    panel.add(lbNome);
	    tfNome = new JTextField();
	    tfNome.setBounds(90, 35, 400, 25);
	    panel.add(tfNome);


	    JLabel lbCPF = new JLabel("CPF");
	    lbCPF.setBounds(10, 70, 50, 25);
	    panel.add(lbCPF);
	    String maskCPF = "###.###.###-##";
	    MaskFormatter mascaraCPF = null;
	    try {
	        mascaraCPF = new MaskFormatter(maskCPF);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    tfCPF = new JFormattedTextField(mascaraCPF);
	    tfCPF.setBounds(10, 95, 180, 25);
	    panel.add(tfCPF);
	    

	    JLabel lbDataN = new JLabel("Data Nasc.");
	    lbDataN.setBounds(200, 70, 100, 25);
	    panel.add(lbDataN);
	    try {
	        tfDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
	    } catch (ParseException e1) {
	        e1.printStackTrace();
	    }
	    tfDataNascimento.setBounds(200, 95, 150, 25);
	    panel.add(tfDataNascimento);


	    JLabel lbDataC = new JLabel("Data Contratação");
	    lbDataC.setBounds(10, 130, 130, 25);
	    panel.add(lbDataC);
	    try {
	        tfDataContratacao = new JFormattedTextField(new MaskFormatter("##/##/####"));
	    } catch (ParseException e1) {
	        e1.printStackTrace();
	    }
	    tfDataContratacao.setBounds(10, 155, 130, 25);
	    panel.add(tfDataContratacao);


	    String[] cargos = { "-- Selecione um cargo --", "Gerente", "Funcionário", "Motorista" };
	    JLabel lbCargo = new JLabel("Cargo");
	    lbCargo.setBounds(270, 130, 100, 25);
	    panel.add(lbCargo);
	    cbCargo = new JComboBox<String>(cargos);
	    cbCargo.setBounds(270, 155, 220, 25);
	    panel.add(cbCargo);


	    JLabel lbSalario = new JLabel("Salário");
	    lbSalario.setBounds(155, 130, 50, 25);
	    panel.add(lbSalario);
	    tfSalario = new JTextField();
	    tfSalario.setBounds(155, 155, 100, 25);
	    panel.add(tfSalario);
	    
//	    JLabel lbCNH = new JLabel("CNH");
//	    lbCNH.setBounds(10, 190, 50, 25);
//	    panel.add(lbCNH);
//	    tfCNH = new JTextField();
//	    if(!(funcionario instanceof Motorista)) {
//	    	tfCNH.setEditable(false);
//	    }
//	    tfCNH.setBounds(10, 215, 100, 25);
//	    panel.add(tfCNH);

	    JPanel panelBotoes = new JPanel();
	    panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
	    getContentPane().add(panelBotoes, BorderLayout.SOUTH);

	    btSalvar = new JButton("Salvar");
	    btSalvar.setBounds(380, 250, 100, 25);
	    btSalvar.addActionListener(this);
	    panelBotoes.add(btSalvar);

	    btCancelar = new JButton("Cancelar");
	    btCancelar.setBounds(380, 250, 100, 25);
	    btCancelar.addActionListener(this);
	    panelBotoes.add(btCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object origem = e.getSource();
		if (origem == btSalvar) {
			boolean passou = true;
			int codFuncionario = Integer.parseInt(tfCodFuncionario.getText());
			String nome = tfNome.getText();
			if (nome.length() > 2)
				tfNome.setBackground(Color.WHITE);
			else {
				tfNome.setBackground(Color.PINK);
				passou = false;
			}
			String cpf = tfCPF.getText();
			if (!cpf.equals("   .   .   -  "))
				tfCPF.setBackground(Color.WHITE);
			else {
				tfCPF.setBackground(Color.PINK);
				passou = false;
			}
			String cargo = (String) cbCargo.getSelectedItem();
			if (!cargo.equals("-- Selecione um cargo --"))
				cbCargo.setBackground(Color.WHITE);
			else {
				cbCargo.setBackground(Color.PINK);
				passou = false;
			}
			String dataN = tfDataNascimento.getText();
			String dataC = tfDataContratacao.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date daten = null;
			if (!dataN.equals("  /  /    ")) {
				try {
					daten = sdf.parse(dataN);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				tfDataNascimento.setBackground(Color.WHITE);
			} else {
				tfDataNascimento.setBackground(Color.PINK);
				passou = false;
			}
			Date datec = null;
			if (!dataC.equals("  /  /    ")) {
				try {
					datec = sdf.parse(dataC);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				tfDataContratacao.setBackground(Color.WHITE);
			} else {
				tfDataContratacao.setBackground(Color.PINK);
				passou = false;
			}
			double salario = 0;
			try {
				salario = Double.parseDouble(tfSalario.getText());
				if (salario < 0) {
					passou = false;
				}
			} catch (NumberFormatException ex) {
				passou = false;
			}

			if (passou) {
				funcionario = new Funcionario(codFuncionario, cpf, nome, cargo, daten, datec, salario);
			} else {
				JOptionPane.showMessageDialog(this, "Não preencheu algum campo obrigatório");
			}
			dispose();
		} else if (origem == btCancelar) {
			dispose();
		}
	}
}
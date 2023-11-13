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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Model.Caminhao;
import Model.Funcionario;

public class JanelaCadastroCaminhao extends JDialog implements ActionListener  {
	private Caminhao caminhao;

	private JTextField tfCodCaminhao;
	private JTextField tfPlaca;
	private JTextField tfMarca;
	private JTextField tfAno;
	private JTextField tfCargaMax;

	private JButton btSalvar;
	private JButton btCancelar;

	public JanelaCadastroCaminhao(int proxcodigo) {
		super();
		initGUI();
		tfCodCaminhao.setText(String.valueOf(proxcodigo));
		setVisible(true);
	}
	
	public JanelaCadastroCaminhao(Caminhao a) {
		super();
		initGUI();

		setTitle("Edicao Funcionario");
		// preencher os textfields
		tfCodCaminhao.setText(String.valueOf(a.getCodigo()));
		tfPlaca.setText(a.getPlaca());
		tfAno.setText(String.valueOf(a.getAno()));
		tfMarca.setText(a.getMarca());
		tfCargaMax.setText (String.valueOf(a.getCargaMaxima()));
		
		setVisible(true);
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}
	private void initGUI() {
	    setModal(true);
	    setTitle("Cadastro Caminhao");
	    setSize(510, 290);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    getContentPane().add(panel, BorderLayout.CENTER);


	    JLabel lbCodCaminhao = new JLabel("Código do Caminhao");
	    lbCodCaminhao.setBounds(10, 10, 80, 25);
	    panel.add(lbCodCaminhao);
	    tfCodCaminhao = new JTextField();
	    tfCodCaminhao.setEditable(false);
	    tfCodCaminhao.setBounds(10, 35, 70, 25);
	    panel.add(tfCodCaminhao);


	    JLabel lbMarca = new JLabel("Marca");
	    lbMarca.setBounds(90, 10, 50, 25);
	    panel.add(lbMarca);
	    tfMarca= new JTextField();
	    tfMarca.setBounds(90, 35, 400, 25);
	    panel.add(tfMarca);


	    JLabel lbAno = new JLabel("Ano");
	    lbAno.setBounds(10, 70, 50, 25);
	    panel.add(lbAno);
	    String maskAno = "####";
	    MaskFormatter mascaraAno = null;
	    try {
	        mascaraAno = new MaskFormatter(maskAno);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    tfAno = new JFormattedTextField(mascaraAno);
	    tfAno.setBounds(10, 95, 180, 25);
	    panel.add(tfAno);
	    
	    JLabel lbPlaca = new JLabel("Placa");
	    lbPlaca.setBounds(200, 70, 50, 25);
	    panel.add(lbPlaca);
	    tfPlaca = new JTextField();
	    tfPlaca.setBounds(200, 95, 150, 25);
	    panel.add(tfPlaca);
	    
	    JLabel lbCargaMax = new JLabel("Carga Maxima");
	    lbCargaMax.setBounds(360, 70, 130, 25);
	    panel.add(lbCargaMax);
	    tfCargaMax = new JTextField();
	    tfCargaMax.setBounds(360, 95, 130, 25);
	    panel.add(tfCargaMax);

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
			int codCaminhao = Integer.parseInt(tfCodCaminhao.getText());
			String marca = tfMarca.getText();
			if (marca.length() > 2)
				tfMarca.setBackground(Color.WHITE);
			else {
				tfMarca.setBackground(Color.PINK);
				passou = false;
			}
			String placa = tfPlaca.getText();
			if (placa.length() > 5)
				tfPlaca.setBackground(Color.WHITE);
			else {
				tfPlaca.setBackground(Color.PINK);
				passou = false;
			}
			int ano = 0;
			try {
				ano = Integer.parseInt(tfAno.getText());
				if (ano < 1000 || ano > 9999) {
					passou = false;
				}
			} catch (NumberFormatException ex) {
				passou = false;
			}
			double cargamax = 0;
			try {
				cargamax = Double.parseDouble(tfCargaMax.getText());
				if (cargamax < 0) {
					passou = false;
				}
			} catch (NumberFormatException ex) {
				passou = false;
			}

			if (passou) {
				Caminhao c = new Caminhao(codCaminhao, placa, marca, ano, cargamax);
				this.caminhao = c;
			} else {
				JOptionPane.showMessageDialog(this, "Não preencheu algum campo obrigatório");
			}
			dispose();
		} else if (origem == btCancelar) {
			dispose();
		}
	}
}
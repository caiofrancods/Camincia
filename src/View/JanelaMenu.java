package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JanelaMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int opc;
	
	public int getOpc() {
		return opc;
	}

	public JanelaMenu() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setModal(true);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFuncionrio = new JMenu("Funcionário");
		menuBar.add(mnFuncionrio);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnFuncionrio.add(mntmCadastrar);
		
		mntmCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 101;
            	dispose();
            }
        });
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnFuncionrio.add(mntmEditar);
		
		mntmEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 103;
            	dispose();
            }
        });
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mnFuncionrio.add(mntmExcluir_1);
		
		mntmExcluir_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 102;
            	dispose();
            }
        });
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mnFuncionrio.add(mntmListar_1);
		
		mntmListar_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 104;
            	dispose();
            }
        });
		
		JMenu mnCaminhao = new JMenu("Caminhao");
		menuBar.add(mnCaminhao);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnCaminhao.add(mntmCadastrar_1);
		
		mntmCadastrar_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 1001;
            	dispose();
            }
        });
		
		JMenuItem mntmEditar_1 = new JMenuItem("Editar");
		mnCaminhao.add(mntmEditar_1);
		
		mntmEditar_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 1003;
            	dispose();
            }
        });
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnCaminhao.add(mntmExcluir);
		
		mntmExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 1002;
            	dispose();
            }
        });
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnCaminhao.add(mntmListar);
		
		mntmListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = 1004;
            	dispose();
            }
        });
		
		JMenu mnRota = new JMenu("Rota");
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = -1;
            	dispose();
            }
        });
		menuBar.add(mnRota);
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}

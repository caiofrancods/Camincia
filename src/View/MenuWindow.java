package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuWindow extends JFrame {

	private JButton btnFuncionario, btnCaminhao, btnRota;
    private JButton btnCadastro, btnExcluir, btnAlterar, btnListar, btnVoltar;
    protected int opc;
    public int getOpc() {
    	return opc;
    }
    public MenuWindow() {
        super("Menu");
        setTitle("Menu");
	    setSize(510, 480);
        // Configura o layout da janela
        setLayout(new FlowLayout());

        Bts();
        // Adiciona um listener aos botões
        btnFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	subBts(100);
            }
        });

        btnCaminhao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	subBts(1000);

            }
        });
        
        // Empacota e exibe a janela
        pack();
        setVisible(true);
    }
    
    public void Bts() {
        // Cria os botões
        btnFuncionario = new JButton("Funcionário");
        btnCaminhao= new JButton("Caminhão");
        //btnRota = new JButton("Rota");


        // Adiciona os botões à janela
        add(btnFuncionario);
        add(btnCaminhao);
        //add(btnRota);
    }
    
    public void subBts(int principal) {
    	setLayout(new FlowLayout());
    	remove(btnFuncionario);
    	remove(btnCaminhao);

    	// Cria os botões
        btnCadastro = new JButton("Cadastro");
        btnExcluir = new JButton("Excluir");
        btnAlterar = new JButton("Alterar");
        btnListar = new JButton("Listar");
        btnVoltar = new JButton("Voltar");

        // Adiciona os botões à janela
        add(btnCadastro);
        add(btnExcluir);
        add(btnAlterar);
        add(btnListar);
        add(btnVoltar);


        // Adiciona um listener aos botões
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = principal+1;
            	dispose();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = principal+2;
            	dispose();

            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = principal+3;
            	dispose();
   
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = principal+4;
            	dispose();

            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	opc = -1;
            	dispose();

            }
        });
        pack();
        setVisible(true);
        
    }

}

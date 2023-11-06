package View;

import java.util.Scanner;

public class Principal{
	private Scanner scn;
	JanelaMenu jmenu;
	
	public Principal() {
		jmenu = new JanelaMenu();
	}
	
	public int menu() {
		jmenu.setVisible(true);
		return jmenu.getOpc();
	}
}
package Sistem;

import Control.ControlFuncionario;
import Control.ControlCaminhao;
import View.Principal;

public class Sistema {

	public static void main(String[] args) {
		ControlFuncionario controlFuncionario = new ControlFuncionario();
		ControlCaminhao controlCaminhao = new ControlCaminhao();
		Principal principal = new Principal();
		int opc = principal.menu();
		while(opc != -1) {
			if(opc < 1000) {
				switch (opc) {
				case 101: 
					controlFuncionario.adicionar();
					break;
				case 102:
					controlFuncionario.excluir();
					break;
				case 103:
					controlFuncionario.alterar();
					break;
				case 104:
					controlFuncionario.listar();
					break;
				}
			}else {
				switch (opc) {
				case 1001: 
					controlCaminhao.adicionar();
					break;
				case 1002:
					controlCaminhao.excluir();
					break;
				case 1003:
					controlCaminhao.alterar();
					break;
				case 1004:
					controlCaminhao.listar();
					break;
				}
			}
			opc = principal.menu();
		}
		System.out.println("Fim do Programa!");
	}

}

package View;

import java.util.Scanner;

public class Principal{
	private Scanner scn;
	
	public Principal() {
		scn = new Scanner(System.in);
	}
	
	public int menu() {
		System.out.println("____Camincia____");
		System.out.println();
		System.out.println("__Menu__: ");
		System.out.println("0 - Sair");
		System.out.println("1 - Funcionario");
		System.out.println("2 - Caminhao");
		System.out.println("3 - Rota");
		System.out.println();
		System.out.print("Selecione uma opcao: ");
		int opc = scn.nextInt();
		while(opc < 0 || opc > 3) {
			System.out.println("Opção inválida. Digite novamente: ");
			System.out.print("Selecione uma opcao: ");
			opc = scn.nextInt();
		}
		if(opc == 1) {
			System.out.println("__Menu__: ");
			System.out.println("0 - Voltar");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Excluir");
			System.out.println("3 - Alterar");
			System.out.println("4 - Listar");
			System.out.println();
			System.out.print("Selecione uma opcao: ");
			int opcs = scn.nextInt();
			while(opcs < 0 || opc > 4) {
				System.out.println("Opção inválida. Digite novamente: ");
				System.out.print("Selecione uma opcao: ");
				opc = scn.nextInt();
			}
			return opcs + 100;
		}else if(opc == 2){
			System.out.println("__Menu__: ");
			System.out.println("0 - Voltar");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Excluir");
			System.out.println("3 - Alterar");
			System.out.println("4 - Listar");
			System.out.println();
			System.out.print("Selecione uma opcao: ");
			int opcs = scn.nextInt();
			while(opcs < 0 || opc > 4) {
				System.out.println("Opção inválida. Digite novamente: ");
				System.out.print("Selecione uma opcao: ");
				opc = scn.nextInt();
			}
			return opcs + 1000;
		}else if(opc == 3){
			System.out.println("Em breve...");
			return -1;
		}else {
			return 0;
		}
		
	}
}
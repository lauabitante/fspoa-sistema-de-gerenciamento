import java.util.Scanner;

public class SistemaDeGerenciamento {
	
	public Aplicacao aplicacao = new Aplicacao();
	static Scanner scan = new Scanner(System.in);
	static int opcao;

	public static void main(String[] args) {
		mostraMenu();
	}
	
	public static void mostraMenu(){
		while(true){
			System.out.println("[SISTEMA DE GERENCIAMENTO DE PROJETOS] \n");
			System.out.println("Selecione uma opcao: \n [1]Criar projeto");
			opcao = scan.nextInt();
			executaOpcao(opcao);
		}
	}
	
	public static void executaOpcao(int opcao){
		switch(opcao){
		case 1:
			
			break;
		}
	}
}

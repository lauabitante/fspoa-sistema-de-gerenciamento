import java.util.Scanner;

public class SistemaDeGerenciamento {
	
	public Aplicacao aplicacao = new Aplicacao();
	
	public static GerenciaProjeto gerenciaProjeto = new GerenciaProjeto();
	public static GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario();
	public static GerenciaCompetencia gerenciaCompetencia = new GerenciaCompetencia();

	static Scanner scan = new Scanner(System.in);
	static int opcao;

	public static void main(String[] args) {
		mostraMenu();
	}
	
	public static void mostraMenu(){
		while(true){
			System.out.println("[SISTEMA DE GERENCIAMENTO DE PROJETOS] \n");
			System.out.println("Selecione uma Opção:");
			System.out.println("[1]Novo Projeto");
			System.out.println("[2]Novo Funcionário");
			System.out.println("[3]Nova Competência");
			System.out.println("[4]Incluir Funcionário em Projeto");
			System.out.println("[5]Excluir Projeto");
			System.out.println("[6]Excluir Funcionário");
			System.out.println("[7]Consultar Projetos Ativos");
			System.out.println("[8]Consultar Projetos com Competências Pendentes");
			System.out.println();

			System.out.print("Opção: ");
			opcao = scan.nextInt();
			executaOpcao(opcao);
		}
	}
	
	public static void executaOpcao(int opcao){
		switch(opcao){
		case 1:
			gerenciaProjeto.criaProjeto();
//			System.out.println(Aplicacao.getInstance().listaProjetos.toString());
			break;
		
		case 2:
			gerenciaFuncionario.criaFuncionario();
//			System.out.println(Aplicacao.getInstance().listaFuncionarios.toString());
			break;
			
		case 3:
			gerenciaCompetencia.criaCompetencia();
//			System.out.println(Aplicacao.getInstance().listaCompetencias.toString());
			break;
			
		case 4:
			
			break;
			
		case 5:
			gerenciaProjeto.excluiProjeto();
//			System.out.println(Aplicacao.getInstance().listaProjetos.toString());
			break;
			
		case 6:
			gerenciaFuncionario.excluiFuncionario();
//			System.out.println(Aplicacao.getInstance().listaFuncionarios.toString());
			break;
			
		case 7:
			break;
			
		case 8:
			break;
			
		default:
			break;
		}
	}
}

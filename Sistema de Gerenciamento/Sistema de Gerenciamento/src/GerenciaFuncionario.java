import java.util.Scanner;

public class GerenciaFuncionario {

	Scanner scan = new Scanner(System.in);
	
	public void criaFuncionario(){
		
		System.out.println("Digite o nome do Funcionário: ");
		String nomeFuncionario = scan.nextLine();
		
		System.out.println("Digite o salário do Funcionário: ");
		Double salario = scan.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFuncionario, salario, 0);
		
		System.out.println("LISTA DE COMPETENCIAS:");
		Aplicacao.getInstance().listaCompetencias.imprimirIndexado();
		
		int competencia;
		
		do{
			System.out.println("Digite o código de uma competencia ou 0 para sair: ");
			competencia = scan.nextInt();
			
			if(competencia > Aplicacao.getInstance().listaCompetencias.tamanho()){
				System.out.println("Valor inválido! \n Tente novamente ou digite 0 para sair.");
			}
			else if(competencia != 0){
				Node<Competencia> novaCompetencia = Aplicacao.getInstance().listaCompetencias.getElemento(competencia);
				funcionario.adicionaCompetencia(novaCompetencia.valor().toString());
				funcionario.setQtdCompetencias(funcionario.getQtdCompetencias()+1);
				System.out.println("Competencia: "+novaCompetencia.valor().toString()+" adicionada.");
			}
		}
		while(competencia != 0);
		
		Aplicacao.getInstance().listaFuncionarios.adiciona(funcionario);
	}
	
	public void excluiFuncionario() {
		
		System.out.println("LISTA DE FUNCIONÁRIOS:");
		Aplicacao.getInstance().listaFuncionarios.imprimirIndexado();
		int codFuncionario;
		
		do{
			System.out.println("Digite o código do Funcionário para Excluir ou 0 para sair: ");
			codFuncionario = scan.nextInt();
			
			if(codFuncionario > Aplicacao.getInstance().listaFuncionarios.tamanho()){
				System.out.println("Valor inválido! \n Tente novamente ou digite 0 para sair.");
			}
			else if(codFuncionario != 0){
				Node<Funcionario> funcionario = Aplicacao.getInstance().listaFuncionarios.getElemento(codFuncionario);
				System.out.println("Funcionário: "+funcionario.valor().getNome()+" excluído com sucesso!");
				Aplicacao.getInstance().listaFuncionarios.remove(funcionario.valor());	
				System.out.println();
				break;
			}
		}
		while(codFuncionario != 0);
	}	
}

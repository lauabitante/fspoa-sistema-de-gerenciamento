import java.util.Scanner;
import java.time.LocalDate;

public class GerenciaProjeto {

	Scanner scan = new Scanner(System.in);
	
	public void criaProjeto() {
		System.out.println("Digite o nome do Projeto: ");
		String nomeProjeto = scan.nextLine();
		
		System.out.println("Digite a data de início do Projeto: ex:(2016-01-30)");
		LocalDate dataInicio = LocalDate.parse(scan.next());
		
		System.out.println("Digite a data final do Projeto: ex:(2016-01-30)");
		LocalDate dataFim = LocalDate.parse(scan.next());
		
		Projeto projeto = new Projeto(nomeProjeto, dataInicio, dataFim, 0);
	
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
				projeto.adicionaCompetencia(novaCompetencia.valor().toString());
				projeto.setQtdCompetencias(projeto.getQtdCompetencias()+1);
				System.out.println("Competencia: "+novaCompetencia.valor().toString()+" adicionada.");
			}
		}
		while(competencia != 0);
		
		Aplicacao.getInstance().listaProjetos.adiciona(projeto);
	}
	
	
	public void excluiProjeto() {
		
		System.out.println("LISTA DE PROJETOS:");
		Aplicacao.getInstance().listaProjetos.imprimirIndexado();
		int codProjeto;
		
		do{
			System.out.println("Digite o código do Projeto para Excluir ou 0 para sair: ");
			codProjeto = scan.nextInt();
			
			if(codProjeto > Aplicacao.getInstance().listaProjetos.tamanho()){
				System.out.println("Valor inválido! \n Tente novamente ou digite 0 para sair.");
			}
			else if(codProjeto != 0){
				Node<Projeto> projeto = Aplicacao.getInstance().listaProjetos.getElemento(codProjeto);
				System.out.println("Projeto: "+projeto.valor().getNomeProjeto()+" excluído com sucesso!");
				Aplicacao.getInstance().listaProjetos.remove(projeto.valor());	
				System.out.println();
				break;
			}
		}
		while(codProjeto != 0);
	}	


	public void listaProjetosAtivos() {
		
	}

}


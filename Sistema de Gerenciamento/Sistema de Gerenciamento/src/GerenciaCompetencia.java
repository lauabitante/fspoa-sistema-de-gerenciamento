import java.util.Scanner;

public class GerenciaCompetencia {

	Scanner scan = new Scanner(System.in);

	public void criaCompetencia() {

		System.out.println("Digite a Competencia: ");
		String nomeCompetencia = scan.nextLine();
		
		if(verificaCompetencia(nomeCompetencia)){
			System.out.println("Competencia já existe!");
			System.out.println();
		}
		else{
			Competencia competencia = new Competencia(nomeCompetencia);
			Aplicacao.getInstance().listaCompetencias.adiciona(competencia);
		}
	}
	
	public boolean verificaCompetencia(String competencia) {
		
		Node<Competencia> node = Aplicacao.getInstance().listaCompetencias.primeiro;
		
		for(int i=0; i<Aplicacao.getInstance().listaCompetencias.totalDeElementos; i++){
			if(node.valor().toString().equals(competencia)){
				return true;
			}
			else{
				node = node.proximo();
			}
		}
		return false;
	}

}

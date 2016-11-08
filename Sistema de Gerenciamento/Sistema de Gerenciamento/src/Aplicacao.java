import java.io.FileNotFoundException;

public class Aplicacao {
	
	private static Aplicacao singleton = new Aplicacao();
	
	public static Aplicacao getInstance(){
		return singleton;
	}
	
	ListaEncadeada<Colaborador> listaColaboradores = new ListaEncadeada<>();
	ListaEncadeada<Competencia> listaCompetencias  = new ListaEncadeada<>();
	ListaEncadeada<Funcionario> listaFuncionarios  = new ListaEncadeada<>();
	ListaEncadeada<Projeto> 	listaProjetos	   = new ListaEncadeada<>();
	
	public Aplicacao() {
		try {
			run();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			System.err.println(e.getMessage());
		}
	}

	public void run() throws FileNotFoundException {
		
		lerArquivo("colaboradores.csv", listaColaboradores, new ParserColaborador());
		lerArquivo("competencias.csv", listaCompetencias, new ParserCompetencia());
		lerArquivo("funcionarios.csv", listaFuncionarios, new ParserFuncionario());
		lerArquivo("projetos.csv", listaProjetos, new ParserProjeto());		
	}
	
	public <T> void lerArquivo(String nomeArquivo, ListaEncadeada<T> lista, Parser<T> parser) throws FileNotFoundException {
		CSVFile<T> csv;
		csv = new CSVFile<>(nomeArquivo, parser);
		T objeto = null;
		do {
			objeto = csv.readObject();
			if (objeto != null){
				lista.adiciona(objeto);
			}
		} while (objeto != null);
		System.out.println();
	}
}

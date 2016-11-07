import java.util.Scanner;

public class ParserColaborador implements Parser<Colaborador> {

	@Override
	public Colaborador parseObject(String dadosCSV) {
		
		Scanner scan = new Scanner(dadosCSV);
		scan.useDelimiter(";");

		String nomeProjeto = scan.next();
		String nomeFuncionario = scan.next();
		String competencia = scan.next();
		
		Colaborador colaborador = new Colaborador(nomeProjeto, nomeFuncionario, competencia);

		scan.close();

		return colaborador;
	}
}

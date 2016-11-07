import java.util.Scanner;

public class ParserCompetencia implements Parser<Competencia> {

	@Override
	public Competencia parseObject(String dadosCSV) {

		Scanner scan = new Scanner(dadosCSV);
		scan.useDelimiter(";");

		String comp = scan.next();
		
		Competencia competencia = new Competencia(comp);

		scan.close();

		return competencia;
	}

}

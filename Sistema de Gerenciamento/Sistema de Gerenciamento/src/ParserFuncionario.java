import java.util.Scanner;

public class ParserFuncionario implements Parser<Funcionario> {

	@Override
	public Funcionario parseObject(String dadosCSV) {

		Scanner scan = new Scanner(dadosCSV);
		scan.useDelimiter(";");

		String nome = scan.next();
		Double salario = Double.parseDouble(scan.next().replace(",", "."));
		int qtdCompetencias = scan.nextInt();

		Funcionario funcionario = new Funcionario(nome, salario, qtdCompetencias);
		
		while(scan.hasNext()){
			funcionario.adicionaCompetencia(scan.next());
		}

		scan.close();

		return funcionario;
	}
}
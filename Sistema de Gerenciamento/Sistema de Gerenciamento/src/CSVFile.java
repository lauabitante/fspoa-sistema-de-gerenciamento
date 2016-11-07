import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVFile<T> {

	private Scanner scan;
	private Parser<T> parser;
	
	public CSVFile(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		this.scan = new Scanner(
				new BufferedReader(
					new FileReader(filename)
				)
			);
		this.parser = parser;
	}
	
	public T readObject() {
		if (scan.hasNext())
			return parser.parseObject(scan.nextLine());
		return null;
	}
	
	public void skipLine() {
		if (scan.hasNext())
			scan.nextLine();
	}
}

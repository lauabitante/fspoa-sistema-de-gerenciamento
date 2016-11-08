import java.time.LocalDate;

public class Projeto {

	private String nomeProjeto;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private int qtdCompetencias;
	private ListaEncadeada<Competencia> competencias = new ListaEncadeada<>();
	
	public Projeto(String nomeProjeto, LocalDate dataInicio, LocalDate dataFim, int qtdCompetencias) {
		super();
		this.nomeProjeto = nomeProjeto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.qtdCompetencias = qtdCompetencias;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public int getQtdCompetencias() {
		return qtdCompetencias;
	}

	public void setQtdCompetencias(int qtdCompetencias) {
		this.qtdCompetencias = qtdCompetencias;
	}
	
	public void adicionaCompetencia(String competencia){
		Competencia novaCompetencia = new Competencia(competencia);
		competencias.adiciona(novaCompetencia);
	}
	
	public String listaCompetencias(){
		StringBuilder builder = new StringBuilder("[");
		Node<Competencia> atual = competencias.primeiro;

		for (int i = 0; i < this.competencias.totalDeElementos - 1; i++) {
			builder.append(atual.valor());
			builder.append(" | ");
			atual = atual.proximo();
		}

		builder.append(atual.valor());
		builder.append("]");

		return builder.toString();
	}

	@Override
	public String toString() {
		return "Projeto: " + nomeProjeto + ", Data Inicial: " + dataInicio + ", Data Final: " + dataFim
				+ qtdCompetencias + " competencias: " + listaCompetencias();
	}
}

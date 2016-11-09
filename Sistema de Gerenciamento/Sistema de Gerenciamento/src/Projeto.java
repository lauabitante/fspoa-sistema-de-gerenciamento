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
	
	public void adicionaCompetencia(String competencia) {
		Competencia novaCompetencia = new Competencia(competencia);
		competencias.adiciona(novaCompetencia);
	}
	
	public boolean possuiCompetencia(Competencia competencia) {
		Node<Competencia> atual = competencias.primeiro;
		
		for(int i=0; i<competencias.tamanho(); i++){
			if(atual.valor().getCompetencia().equals(competencia.getCompetencia())){
				return true;
			}
			atual = atual.proximo();
		}
		return false;
	}
	
	public ListaEncadeada<Funcionario> listaFuncionariosDisponiveis() {
		ListaEncadeada<Funcionario> lista = new ListaEncadeada<>();
		Node<Funcionario> funcionarioAtual = Aplicacao.getInstance().listaFuncionarios.primeiro;
		Node<Competencia> competenciaAtual = competencias.primeiro;

		while (competenciaAtual != null) {
			while (funcionarioAtual != null) {
				if(funcionarioAtual.valor().possuiCompetencia(competenciaAtual.valor())){
					lista.adiciona(funcionarioAtual.valor());
				}
				funcionarioAtual = funcionarioAtual.proximo();				
			}
			competenciaAtual = competenciaAtual.proximo();
		}
		return lista;
	}
	
	public boolean possuiPendencias() {
		int comp = 0;
		Node<Competencia> competenciaAtual = competencias.primeiro;
		
		for (int i = 1; i < competencias.totalDeElementos; i++) {
			Node<Colaborador> colaboradorAtual = Aplicacao.getInstance().listaColaboradores.primeiro;
			for (int j = 1; j < Aplicacao.getInstance().listaColaboradores.tamanho(); j++) {
				if (colaboradorAtual.valor().getCompetencia().equals(competenciaAtual.valor().getCompetencia())) {
					comp++;
				}
				colaboradorAtual = colaboradorAtual.proximo();
			}
			competenciaAtual = competenciaAtual.proximo();
		}
		return  comp < qtdCompetencias;
	}

	@Override
	public String toString() {
		return "Projeto: " + nomeProjeto + ", Data Inicial: " + dataInicio + ", Data Final: " + dataFim
				+ ", " + qtdCompetencias + " competencias: " + competencias.toStringHorizontal();
	}
}

public class Funcionario {
	
	private String nome;
	private Double salario;
	private int qtdCompetencias;
	public ListaEncadeada<Competencia> competencias = new ListaEncadeada<>(); 
	
	public Funcionario(String nome, Double salario, int qtdCompetencia) {
		this.nome = nome;
		this.salario = salario;
		this.qtdCompetencias = qtdCompetencia;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
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
	
	public int quantidadeProjetos() {
		Node<Colaborador> atual = Aplicacao.getInstance().listaColaboradores.primeiro;
		
		int contProjetos = 0;
		
		for(int i=0; i<Aplicacao.getInstance().listaColaboradores.tamanho(); i++){
			if(atual.valor().getColaborador().equals(getNome())){
				contProjetos++;
			}
			atual = atual.proximo();
		}
		return contProjetos;
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
		return "Funcionario: " + nome + ", " + salario + ", " + qtdCompetencias
				+ " competencias: " + listaCompetencias();
	}
}

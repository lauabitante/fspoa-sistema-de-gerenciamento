
public class Colaborador {
	
	private String nomeProjeto;
	private String nomeFuncionario;
	private String competencia;

	public Colaborador(String nomeProjeto, String colaborador, String competencia) {
		this.nomeProjeto = nomeProjeto;
		this.nomeFuncionario = colaborador;
		this.competencia = competencia;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getColaborador() {
		return nomeFuncionario;
	}

	public void setColaborador(String colaborador) {
		this.nomeFuncionario = colaborador;
	}

	@Override
	public String toString() {
		return "Colaborador [nomeProjeto=" + nomeProjeto + ", nomeFuncionario=" + nomeFuncionario + ", competencia="
				+ competencia + "]";
	}
}

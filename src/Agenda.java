import java.time.LocalDateTime;

public class Agenda {

	private static final int MAX_COMPROMISSOS = 300;
	private Compromisso[] compromissos;
	private int quantCompromissos;
	private String nome;

	public Agenda(String nome) {
		
	}

	public int incluirCompromisso(Compromisso compromisso) {
		return 0;
	}

	public String compromissosNaData(LocalDateTime quando) {
		return "";
	}

	public String relatorioCompromissos() {
		return "";
	}

}

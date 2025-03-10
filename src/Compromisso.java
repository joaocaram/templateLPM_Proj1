import java.time.LocalDateTime;

public class Compromisso {

	private static final String[] TAGS = {"Profissional", "Pessoal" ,"Lazer"};
	private static int ultimoID;
	private int identificador;
	private String descricao;
	private LocalDateTime quando;

	public Compromisso(String desc, LocalDateTime quando, int tipo) {
		
	}

	public boolean estahAntesDe(Compromisso outro) {
		
	}

	public boolean estahEntre(LocalDateTime ini, LocalDateTime fim) {
		
	}

	public String relatorio() {
		
	}

	public boolean reagendar(LocalDateTime quando) {
		
	}

}

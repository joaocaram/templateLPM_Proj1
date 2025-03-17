import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {

	private static final String[] TAGS = {"Profissional", "Pessoal" ,"Lazer"};
	private static int ultimoID;
	private int identificador;
	private String descricao;
	private LocalDateTime quando;

	public Compromisso(String desc, LocalDateTime quando, int tipo) {
		identificador = ++ultimoID;
		descricao = desc;
		if(quando.isBefore(LocalDateTime.now()))
			quando = LocalDateTime.now().plusHours(1);
		this.quando = quando;
		switch (tipo) {
			case 1, 2, 3 -> descricao += " ("+TAGS[tipo-1]+")";
			default -> descricao += " ("+TAGS[2]+")";
		}
	}

	public boolean estahAntesDe(Compromisso outro) {
		return quando.isBefore(outro.quando);
	}

	public boolean estahEntre(LocalDateTime ini, LocalDateTime fim) {
		return quando.isAfter(ini) && quando.isBefore(fim);
	}

	public String relatorio() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy, HH:mm");
		return String.format("%02d - %s em %s", identificador, descricao, formato.format(quando));
	}

	public boolean reagendar(LocalDateTime quando) {
		boolean resposta = false;
		if(quando.isAfter(LocalDateTime.now())){
			resposta = true;
			this.quando = quando;
		}
		return resposta;
	}

}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AplicacaoAgenda {

    // #region utilidades
    static Scanner teclado;

    static int lerInteiro(String mensagem) {
        System.out.print(mensagem + ": ");
        return Integer.parseInt(teclado.nextLine());
    }

    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa() {
        System.out.println("Tecle Enter para continuar.");
        teclado.nextLine();
    }

    static void cabecalho() {
        limparTela();
        System.out.println("GERENCIADOR DE AGENDAS XULAMBS v1\n================");
    }

    static int menuPrincipal() {
        cabecalho();
        System.out.println("1 - Criar nova agenda");
        System.out.println("2 - Incluir compromisso");
        System.out.println("3 - Compromissos de uma data");
        System.out.println("4 - Todos os compromissos");
        System.out.println("0 - Finalizar");
        return lerInteiro("Digite sua opção");
    }
    // #endregion

    static Agenda criarAgenda(){
        cabecalho();
        System.out.println("CRIANDO UMA NOVA AGENDA");
        System.out.print("Digite o nome da agenda: ");
        return new Agenda(teclado.nextLine());
    }

    static String compromissosDeUmaData(Agenda agenda){
        cabecalho();
        System.out.print("Qual a data para filtro (DD/MM/AAAA)? ");
        String data = teclado.nextLine();
        LocalDateTime quando = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return agenda.compromissosNaData(quando);
    }

    public static void main(String[] args) {
        int opcao = menuPrincipal();
        Agenda agenda;
        do{
            switch (opcao) {
                case 1-> agenda = criarAgenda();
                case 2-> incluirCompromisso(agenda);
                case 3-> System.out.println(compromissosDeUmaData(agenda));
                case 4-> {
                    cabecalho();
                    System.out.println(agenda.relatorioCompromissos());
                }
                case 0 -> System.out.println("FLW VLW OBG VLT SMP.");
            }
            opcao = menuPrincipal();
        }while(opcao !=0);
    }
}

package Trabalho_OO;
import java.time.LocalTime;

public class Historico{

    private Consulta consulta;

    Historico(Consulta consulta){

        this.consulta = consulta;

    }

    public Consulta getConsulta(){

        return this.consulta;

    }

    public void ShowHistorico(){

        System.out.println("=====Dados do Historico=====");
        System.out.printf("Nome do Paciente: %s\n", consulta.getPaciente().getNome());
        System.out.printf("CPF do Paciente: %s\n", consulta.getPaciente().getCPF());
        System.out.printf("Nome do Médico: %s\n", consulta.getMedico().getNome());
        System.out.printf("Preço da Consulta: %,2f\n", consulta.getPreço());
        System.out.printf("Plano de Saúde: %s\n", consulta.getPlanoDeSaude().getNome());
        System.out.printf("Consulta: %s\n", consulta.getTipoConsulta());
        System.out.printf("Data da Consulta: %s\n", consulta.getData());
        System.out.printf("Horário da Consulta: %s\n", consulta.getHorario());

    }

}

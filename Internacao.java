package Trabalho_OO;
import java.time.LocalDate;

public class Internacao {

    private Paciente paciente;
    private Medico medicoResponsável;
    private LocalDate DataDeEntrada;
    private LocalDate DataDeSaída;
    private String Status;
    private String Quarto;
    private double CustoInternação;

    Internacao(Paciente paciente, Medico medicoResponsável, LocalDate DataDeEntrada, LocalDate DataDeSaída, String Status, String Quarto, double CustoInternação){

        this.paciente = paciente;
        this.medicoResponsável = medicoResponsável;
        this.DataDeEntrada = DataDeEntrada;
        this.DataDeSaída = DataDeSaída;
        this.Status = Status;
        this.Quarto = Quarto;
        this.CustoInternação = CustoInternação;

    }

    public Paciente getPaciente(){

        return paciente;

    }

    public Medico getMedicoResponsável() {

        return medicoResponsável;

    }

    public LocalDate getDataDeEntrada() {

        return DataDeEntrada;

    }

    public LocalDate getDataDeSaída() {

        return DataDeSaída;

    }

    public String getStatus() {

        return Status;

    }

    public String getQuarto() {

        return Quarto;

    }

    public double getCustoInternação() {

        return CustoInternação;

    }

    public void ACABAR(LocalDate DataDeSaida){

        this.DataDeSaída = DataDeSaida;
        this.Status = "Concluída";

    }

    public void CANCELAR(){

        this.Status = "Cancelada";

    }

}

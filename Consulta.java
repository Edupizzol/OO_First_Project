package Trabalho_OO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private double Preço;
    private PlanoDeSaude planoDeSaude;
    private String TipoConsulta;
    private LocalDate data;
    private LocalTime horario;

    Consulta(String TipoConsulta, Paciente paciente, Medico medico, double Preço, PlanoDeSaude planoDeSaude, LocalDate data, LocalTime horario){

        this.TipoConsulta = TipoConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.Preço = Preço;
        this.planoDeSaude = planoDeSaude;
        this.data = data;
        this.horario = horario;

    }

    public double Descontar(){

        return Preço * (1-planoDeSaude.getDesconto());

    }

    public Paciente getPaciente(){

        return paciente;

    }

    public Medico getMedico() {

        return medico;

    }

    public double getPreço() {

        return Preço;

    }

    public PlanoDeSaude getPlanoDeSaude() {

        return planoDeSaude;

    }

    public String getTipoConsulta() {

        return TipoConsulta;

    }

    public LocalDate getData() {

        return data;

    }

    public LocalTime getHorario() {

        return horario;

    }

}

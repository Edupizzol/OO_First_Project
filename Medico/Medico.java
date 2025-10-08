package Trabalho_OO.Medico;

import Trabalho_OO.Consultas.Consulta;
import Trabalho_OO.Consultas.CSVConsulta;
import Trabalho_OO.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

    private String Especialidade;
    private String EmailProfissional;
    private String CRM;
    private List<Consulta> agendaConsultas;

    public Medico(String Nome, String CPF, int Idade, String Genero, String Telefone, String EstadoCivil, String Especialidade,  String CRM, String EmailProfissional){

        super(Nome,CPF,Idade,Genero,Telefone,EstadoCivil);

        this.Especialidade = Especialidade;
        this.CRM = CRM;
        this.EmailProfissional = EmailProfissional;
        this.agendaConsultas = new ArrayList<>();

    }

    public String getEspecialidade(){

        return this.Especialidade;

    }

    public String getCRM(){

        return this.CRM;

    }

    public String getEmailProfissional(){

        return this.EmailProfissional;

    }

    public void CarregarConsultas(){

        CSVConsulta csvConsulta = new CSVConsulta();
        this.agendaConsultas = csvConsulta.buscarConsultasPorMedico(this.getNome());

    }

    public void addConsulta(Consulta consulta){

        this.agendaConsultas.add(consulta);

    }

    public int getNumeroConsultas() {

        return this.agendaConsultas.size();

    }

    public List<Consulta> getAgendaConsultas() {

        return this.agendaConsultas;

    }

    public void ShowMedico(){

        System.out.println("===Dados do Medico===");
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("CPF: %s\n", getCPF());
        System.out.printf("Idade: %d\n", getIdade());
        System.out.printf("Genero: %s\n", getGenero());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Estado Civil: %s\n", getEstadoCivil());
        System.out.printf("Especialidade: %s\n", getEspecialidade());
        System.out.printf("CRM: %s\n", getCRM());
        System.out.printf("Email: %s\n", getEmailProfissional());
        System.out.println("=====================");

        if(agendaConsultas.isEmpty()){

            System.out.println("Médico Possui Agenda Vazia!");

        }
        else{

            System.out.println("========Consultas Agendadas========");

            for(Consulta consulta : agendaConsultas){

                System.out.printf("Paciente: %s\nData: %s\nPreço: R$ %.2f\n\n",

                        consulta.getPaciente().getNome(),
                        consulta.getData().toString(),
                        consulta.getPreço()

                        );

            }

        }

    }

}

package Trabalho_OO.Paciente;

import Trabalho_OO.Pessoa;
import Trabalho_OO.Consultas.Consulta;
import Trabalho_OO.Consultas.CSVConsulta;
import Trabalho_OO.Internacoes.Internacao;
import Trabalho_OO.Internacoes.CSVInternacao;
import Trabalho_OO.PlanoDeSaude.PlanoDeSaude;

import java.time.LocalDate;
import java.util.*;

public class Paciente extends Pessoa {

    PlanoDeSaude PlanoDeSaude;
    private String TipoSanguineo;
    private double Altura;
    private double Peso;
    private List<Consulta> historicoConsultas;
    private List<Internacao> historicoInternacoes;

    public Paciente(String Nome, String CPF, int Idade, String Genero, String Telefone, String Estado_Civil, String TipoSanguineo, PlanoDeSaude PlanoDeSaude, double Altura, double Peso){

        super(Nome, CPF, Idade, Genero, Telefone, Estado_Civil);

        this.PlanoDeSaude = PlanoDeSaude;
        this.TipoSanguineo = TipoSanguineo;
        this.Altura = Altura;
        this.Peso = Peso;
        this.historicoConsultas = new ArrayList<>();
        this.historicoInternacoes = new ArrayList<>();

    }

    public void CarregarHistorico(){

        CSVConsulta csvConsulta = new CSVConsulta();
        this.historicoConsultas = csvConsulta.buscarConsultasPorPaciente(this.getCPF());

        CSVInternacao csvInternacao = new CSVInternacao();
        this.historicoInternacoes = csvInternacao.BuscarInternacoesPorPaciente(this.getCPF());

    }

    public List<Consulta> getHistoricoConsultas(){

        return this.historicoConsultas;

    }

    public List<Internacao> getHistoricoInternacoes(){

        return this.historicoInternacoes;

    }

    public PlanoDeSaude getPlanoDeSaude(){

        return this.PlanoDeSaude;

    }

    public String getTipoSanguineo(){

        return this.TipoSanguineo;

    }

    public double getAltura(){

        return this.Altura;

    }

    public double getPeso(){

        return this.Peso;

    }

    public void ShowPaciente(){

        System.out.println("===Dados do Paciente===");
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("CPF: %s\n", getCPF());
        System.out.printf("Idade: %d\n", getIdade());
        System.out.printf("Genero: %s\n", getGenero());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Estado Civil: %s\n", getEstadoCivil());
        System.out.printf("TipoSanguineo: %s\n", getTipoSanguineo());
        System.out.printf("Plano de Saude: %s\n", getPlanoDeSaude());
        System.out.printf("Altura: %.2f\n", getAltura());
        System.out.printf("Peso: %.2f\n", getPeso());
        System.out.println("========================");

        if(historicoConsultas.isEmpty()){

            System.out.println("Esse Paciente não Possui Consultas Cadastradas Ainda!");

        }
        else{

            System.out.println("===========Consultas===========");

            for(Consulta consulta : historicoConsultas){

                System.out.printf("Tipo %s:\nPaciente: %s\nMédico Responsável: %s\nData: %s\nHorário: %s\nPreço: %.2f\n\n",

                        consulta.getTipoConsulta(),
                        consulta.getPaciente().getNome(),
                        consulta.getMedico().getNome(),
                        consulta.getData().toString(),
                        consulta.getHorario().toString(),
                        consulta.getPreço()

                );
            }
        }

        if(historicoInternacoes.isEmpty()){

            System.out.println("Paciente não Possui Internações Cadastradas!");

        }
        else{

            System.out.println("===========Internações===========");

            for(Internacao internacao : historicoInternacoes){

                System.out.printf("Paciente: %s\nMédico Responsável: %s\nData de Entrada: %s\nData de Saída: %s\nStatus: %s\nQuarto: %s\nCusto da Internação: %.2f\n\n",

                        internacao.getPaciente().getNome(),
                        internacao.getMedicoResponsável().getNome(),
                        internacao.getDataDeEntrada().toString(),
                        internacao.getDataDeSaída().toString(),
                        internacao.getStatus(),
                        internacao.getQuarto(),
                        internacao.getCustoInternação()

                );
            }
        }

    }

}

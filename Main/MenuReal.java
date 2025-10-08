package Trabalho_OO.Main;
import Trabalho_OO.CSVGerais.DeletarCSV;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Trabalho_OO.Paciente.Paciente;
import Trabalho_OO.Paciente.CSVPaciente;
import Trabalho_OO.Paciente.PacienteEspecial;

import Trabalho_OO.Medico.Medico;
import Trabalho_OO.Medico.CSVMedico;

import Trabalho_OO.PlanoDeSaude.PlanoDeSaude;
import Trabalho_OO.PlanoDeSaude.CSVPlanoDeSaude;

import Trabalho_OO.Consultas.Consulta;
import Trabalho_OO.Consultas.CSVConsulta;

import Trabalho_OO.Internacoes.Internacao;
import Trabalho_OO.Internacoes.CSVInternacao;

import Trabalho_OO.Diagnosticos.Diagnostico;
import Trabalho_OO.Diagnosticos.DiagnosticoCSV;

public class MenuReal extends Menu{

    Scanner sc = new Scanner(System.in);

    @Override
    public void executarOpção(int N) {

        if(N==1){

            CadastrarPaciente();

        }
        else if(N==2){

            CadastrarMedico();

        }
        else if(N==3){

            ShowPaciente();

        }
        else if(N==4){

            ShowMedico();

        }
        else if(N==5){

            CadastrarPlanoDeSaude();

        }
        else if(N==6){

            MarcarConsulta();

        }
        else if(N==7){

            AgendarInternacao();

        }
        else if(N==8){

            CadastrarDiagnóstico();

        }
        else if(N==9){

            ShowDiagnosticos();

        }
        else if(N==10){

            Deletar();

        }

    }

    private void CadastrarPaciente(){

        System.out.println("Digite o Nome do Paciente:");

        String Nome = sc.nextLine();

        System.out.println("Digite o CPF do Paciente:");

        String CPF = sc.nextLine();

        System.out.println("Informe a Idade do Paciente:");

        int Idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o Gênero do Paciente:");

        String Genero = sc.nextLine();

        System.out.println("Digite o Telefone do Paciente:");

        String Telefone = sc.nextLine();

        System.out.println("Informe o Estado Civil do Paciente:");

        String EstadoCivil = sc.nextLine();

        System.out.println("Informe o Tipo Sanguíneo do Paciente:");

        String TipoSanguíneo = sc.nextLine();

        System.out.println("O Paciente Possui Plano de Saúde?");
        System.out.println("Digite Sim ou Não:");

        String PlanoDeSaude;

        PlanoDeSaude planoDeSaude;

        String Plano = sc.nextLine();

        if(Plano.equalsIgnoreCase("Sim")){

            System.out.println("Informe Qual o Plano de Saúde:");

            PlanoDeSaude = sc.nextLine();

            CSVPlanoDeSaude csvPlanoDeSaude = new CSVPlanoDeSaude();
            planoDeSaude = (PlanoDeSaude) csvPlanoDeSaude.buscarCSV(PlanoDeSaude);

        }
        else{

            planoDeSaude = null;

        }

        System.out.println("Informe a Altura do Paciente:");

        double Altura = sc.nextDouble();
        sc.nextLine();

        System.out.println("Informe o Peso do Paciente:");

        double Peso = sc.nextDouble();
        sc.nextLine();

        Paciente paciente = new Paciente(Nome, CPF, Idade, Genero, Telefone, EstadoCivil, TipoSanguíneo, planoDeSaude, Altura, Peso);


        if (Idade < 12 || Idade > 60) {

            paciente = new PacienteEspecial(paciente.getNome(), paciente.getCPF(), Idade);

        }
        else if (paciente.getPlanoDeSaude() != null){

            paciente = new PacienteEspecial(paciente.getNome(), paciente.getCPF(), Idade);

        }

        CSVPaciente csvPaciente = new CSVPaciente();
        csvPaciente.SalvarCSV(paciente);

        System.out.println("Paciente Foi Cadastrado!");

    }

    private void CadastrarMedico(){


        System.out.println("Digite o Nome do Médico:");

        String Nome = sc.nextLine();

        System.out.println("Digite o CPF do Médico:");

        String CPF = sc.nextLine();

        System.out.println("Informe a Idade do Médico:");

        int Idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o Gênero do Médico:");

        String Genero = sc.nextLine();

        System.out.println("Digite o Telefone do Médico:");

        String Telefone = sc.nextLine();

        System.out.println("Informe o Estado Civil do Médico:");

        String EstadoCivil = sc.nextLine();

        System.out.println("Qual a Especialidade do Médico?:");

        String Especialidade = sc.nextLine();

        System.out.println("Informe o Email do Médico:");

        String Email = sc.nextLine();

        System.out.println("Digite a CRM do Médico:");

        String CRM = sc.nextLine();

        Medico medico = new Medico(Nome, CPF, Idade, Genero, Telefone, EstadoCivil, Especialidade, Email, CRM);

        CSVMedico csvMedico = new CSVMedico();
        csvMedico.SalvarCSV(medico);

        System.out.println("Médico Foi Cadastrado!");

    }

    private void ShowPaciente(){

        System.out.println("Informe o CPF do Paciente:");

        String CPF = sc.nextLine();

        CSVPaciente csvPaciente = new CSVPaciente();
        Paciente paciente = (Paciente) csvPaciente.buscarCSV(CPF);

        if(paciente!=null){

            paciente.CarregarHistorico();
            paciente.ShowPaciente();

        }
        else{

            System.out.println("Paciente não Existe!");

        }

    }

    private void ShowMedico(){

        System.out.println("Informe o Nome do Médico:");

        String Nome = sc.nextLine();

        CSVMedico csvMedico = new CSVMedico();
        Medico medico = (Medico) csvMedico.buscarCSV(Nome);

        if(medico!=null){

            medico.CarregarConsultas();
            medico.ShowMedico();

        }
        else{

            System.out.println("Médico não Existe!");

        }

    }

    private void CadastrarPlanoDeSaude(){

        System.out.println("Informe o Plano de Saude:");

        String Nome = sc.nextLine();

        System.out.println("Informe o Desconto Oferecido Pelo Plano de Saúde:");

        double Desconto = sc.nextDouble();
        sc.nextLine();

        PlanoDeSaude planoDeSaude = new PlanoDeSaude(Nome,Desconto);

        CSVPlanoDeSaude csvPlanoDeSaude = new CSVPlanoDeSaude();
        csvPlanoDeSaude.SalvarCSV(planoDeSaude);

        System.out.println("Plano de Saúde Cadastrado!");

    }

    private void MarcarConsulta(){

        LocalDate data = null;
        LocalTime horario = null;

        System.out.println("Informe o Objetivo da Consulta:");

        String TipoConsulta = sc.nextLine();

        System.out.println("Informe o CPF do Paciente:");

        String CPFpaciente = sc.nextLine();

        CSVPaciente csvPaciente = new CSVPaciente();
        Paciente paciente = (Paciente) csvPaciente.buscarCSV(CPFpaciente);

        if(paciente==null){

            System.out.println("Paciente Não Encontrado!");

            return;

        }

        System.out.println("Informe o Nome do Médico:");

        String NomeMedico = sc.nextLine();

        CSVMedico csvMedico = new CSVMedico();
        Medico medico = (Medico) csvMedico.buscarCSV(NomeMedico);

        if(medico==null){

            System.out.println("Medico Não Encontrado!");

            return;

        }

        System.out.println("Informe o Preço da Consulta:");

        double preço = sc.nextDouble();
        sc.nextLine();

        System.out.println("Informe o Plano de Saúde:");

        String Nomep = sc.nextLine();

        CSVPlanoDeSaude csvPlanoDeSaude = new CSVPlanoDeSaude();
        PlanoDeSaude planoDeSaude = (PlanoDeSaude) csvPlanoDeSaude.buscarCSV(Nomep);

        System.out.println("Informe a Data de Consulta:");

        String Data = sc.nextLine();

        try {

            data = LocalDate.parse(Data, DateTimeFormatter.ISO_LOCAL_DATE);

        }
        catch (DateTimeParseException e) {

            System.out.println("Problema ao Ler Data");
            return;

        }

        System.out.println("Informe o Horário da Consulta:");

        String Hora = sc.nextLine();

        try{

            horario = LocalTime.parse(Hora);

        }
        catch (DateTimeParseException e){

            System.out.println("Formato de horário inválido!");
            return;

        }

        Consulta consulta = new Consulta(TipoConsulta, paciente, medico, preço, planoDeSaude, data, horario);

        double precoFinal = preço; // valor inicial

        if(paciente instanceof PacienteEspecial && planoDeSaude != null){

            precoFinal=consulta.Descontar();
            consulta.setPreço(precoFinal);

        }

        medico.addConsulta(consulta);
        paciente.getHistoricoConsultas().add(consulta);

        CSVConsulta csvConsulta = new CSVConsulta();
        csvConsulta.SalvarCSV(consulta);

        if(csvConsulta.ConsultaPossivel(consulta)==false){

            csvConsulta.SalvarCSV(consulta);

            System.out.println("Consulta Marcada!");

        }
        else{

            System.out.println("Conflito Detectado! Consulta não é Possível");

        }

    }

    private void AgendarInternacao(){

        LocalDate dataEntrada = null;
        LocalDate dataSaida = null;

        System.out.println("Informe o Nome do Paciente que Você Deseja Internar:");

        String Nome = sc.nextLine();

        CSVPaciente csvPaciente = new CSVPaciente();
        Paciente paciente = (Paciente) csvPaciente.buscarCSV(Nome);

        if(paciente == null){

            System.out.println("Paciente Não Encontrado!");
            return;

        }

        System.out.println("Informe o Nome do Médico Responsável Pela Internação:");

        String NomeMedico = sc.nextLine();

        CSVMedico csvMedico = new CSVMedico();
        Medico medicoResponsavel = (Medico) csvMedico.buscarCSV(NomeMedico);

        if(medicoResponsavel == null){

            System.out.println("Médico Não Encontrado!");
            return;

        }

        System.out.println("Informe a Data de Entrada Da Internação:");

        String Data1 = sc.nextLine();

        try {

            dataEntrada = LocalDate.parse(Data1, DateTimeFormatter.ISO_LOCAL_DATE);

        }
        catch (DateTimeParseException e) {

            System.out.println("Problema ao Ler Data");
            return;

        }

        System.out.println("Informe a Data de Saída Da Internação:");

        String Data2 = sc.nextLine();

        try {

            dataSaida = LocalDate.parse(Data2, DateTimeFormatter.ISO_LOCAL_DATE);

        }
        catch (DateTimeParseException e) {

            System.out.println("Problema ao Ler Data");
            return;

        }

        System.out.println("Qual o Status da Internação?");

        String Status = sc.nextLine();

        System.out.println("Informe o Quarto em que Será Realizada a Internação:");

        String Quarto = sc.nextLine();

        System.out.println("Qual o Preço da Internação?");

        double PrecoInternacao = sc.nextDouble();
        sc.nextLine();

        double PrecoFinal = PrecoInternacao;

        if(paciente instanceof PacienteEspecial && paciente.getPlanoDeSaude() != null){

            PrecoFinal = PrecoInternacao * (1 - paciente.getPlanoDeSaude().getDesconto());

        }

        Internacao internacao = new Internacao(paciente,medicoResponsavel,dataEntrada,dataSaida,Status,Quarto,PrecoFinal);

        CSVInternacao csvInternacao = new CSVInternacao();

        if(csvInternacao.InternacaoPossivel(internacao)==false){

            paciente.getHistoricoInternacoes().add(internacao);

            csvInternacao.SalvarCSV(internacao);

            System.out.println("Internação Cadastrada com Sucesso!");

        }
        else{

            System.out.println("Leito já Ocupado!");

        }

    }

    private void CadastrarDiagnóstico(){

        System.out.println("Informe o Tipo de Consulta:");
        String TipoConsulta = sc.nextLine();

        System.out.println("Informe o Nome do Paciente:");
        String Nome = sc.nextLine();

        System.out.println("Informe o Nome do Médico que Realizou o Disagnóstico:");
        String NomeMedico = sc.nextLine();

        System.out.println("Informe a Descrição do Diagnóstico:");
        String Descricao = sc.nextLine();

        Diagnostico diagnostico = new Diagnostico(TipoConsulta,Nome,NomeMedico,Descricao);

        DiagnosticoCSV diagnosticoCSV = new DiagnosticoCSV();
        diagnosticoCSV.SalvarCSV(diagnostico);

        System.out.println("Diagnóstico Cadastrado!");

    }

    private void ShowDiagnosticos(){

        DiagnosticoCSV diagnosticoCSV = new DiagnosticoCSV();

        System.out.println("=======Lista de Diagnósticos=======");

        for(Diagnostico diagnostico : diagnosticoCSV.MostrarDiagnosticos()){

            System.out.printf(

                    "Tipo da Consulta: %s\nNome do Paciente: %s\nNome do Médico: %s\n Descrição da Consulta: %s\n\n",

                    diagnostico.getTipoConsulta(),
                    diagnostico.getNomePaciente(),
                    diagnostico.getNomeMedico(),
                    diagnostico.getDescricao()

            );

        }

    }

    private void Deletar(){

        System.out.println("Escolha o tipo de registro para deletar:");
        System.out.println("1: Paciente");
        System.out.println("2: Médico");
        System.out.println("3: Consulta");
        System.out.println("4: Internação");

        int Num = sc.nextInt();

        if(Num == 1){

            System.out.println("Informe o CPF a ser Deletado:");

            String CPF = sc.nextLine();

            DeletarCSV.REMOVE("Pacientes.csv", linha -> {

                String[] campos = linha.split(";");
                return campos.length >= 2 && campos[1].equals(CPF);

            });
        }
        else if(Num==2){

            System.out.println("Informe o Nome do Médico a Ser Deletado:");

            String Nome = sc.nextLine();

            DeletarCSV.REMOVE("Medicos.csv", linha -> {

                String[] campos = linha.split(";");
                return campos.length >= 1 && campos[0].startsWith(Nome);

            });

        }
        else if(Num==3){

            System.out.println("Informe o Nome do Médico:");

            String NomeMedico = sc.nextLine();

            System.out.println("Informe o CPF do Paciente:");

            String CPF = sc.nextLine();

            System.out.println("Informe a Data da Consulta:");

            System.out.println("Informe a Data da Consulta Ano-Mês-Dia:");

            String dataConsulta = sc.nextLine();

            DeletarCSV.REMOVE("Consultas.csv", linha -> {

                String[] campos = linha.split(";");
                return campos.length >= 7 &&
                        campos[1].equals(NomeMedico) &&
                        campos[2].equals(CPF) &&
                        campos[5].equals(dataConsulta);

            });

        }
        else if(Num==4){

            System.out.println("Informe o CPF do Paciente da Internação:");

            String CPF = sc.nextLine();

            System.out.println("Informe a Data de Entrada da Internação Ano-Mês-Dia:");

            String dataEntrada = sc.nextLine();

            DeletarCSV.REMOVE("Internacoes.csv", linha -> {

                String[] campos = linha.split(";");
                return campos.length >= 3 &&
                        campos[1].equals(CPF) &&
                        campos[2].equals(dataEntrada);

            });

        }

    }

}


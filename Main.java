package Trabalho_OO;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("O que deseja fazer?");
        System.out.println("Cadastrar Paciente: Digite 1");
        System.out.println("Cadastrar Médico: Digite 2");
        System.out.println("Ver Paciente: Digite 3");
        System.out.println("Ver Médico: Digite 4");
        System.out.println("Ver Historico: Digite 5");
        System.out.println("Cadastrar Plano de Saúde: 6");
        System.out.println("Criar Consulta: Digite 7");
        System.out.println("Marcar Consulta: Digite 8");

        int num = sc.nextInt();

        if(num==1){

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

            String Plano = sc.nextLine();

                if(Plano.equalsIgnoreCase("Sim")){

                    System.out.println("Informe Qual o Plano de Saúde:");

                    PlanoDeSaude = sc.nextLine();

                }
                else{

                    PlanoDeSaude = "Sem Plano de Saúde!";

                }

            System.out.println("Informe a Altura do Paciente:");

            double Altura = sc.nextDouble();
            sc.nextLine();

            System.out.println("Informe o Peso do Paciente:");

            double Peso = sc.nextDouble();
            sc.nextLine();

            Paciente paciente = new Paciente(Nome, CPF, Idade, Genero, Telefone, EstadoCivil, TipoSanguíneo, PlanoDeSaude, Altura, Peso);

            CSV.CSV_Pessoa.CSV_Paciente(paciente);

        }
        else if(num==2){

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

            CSV.CSV_Pessoa.CSV_Medico(medico);

        }
        else if(num==3){

            System.out.println("Informe o CPF do Paciente:");

            String CPF = sc.nextLine();

            Paciente paciente = CSV.CSV_Pessoa.BuscaPaciente(CPF);

            if(paciente!=null){

                paciente.ShowPaciente();

            }
            else{

                System.out.println("Paciente não Existe!");

            }

        }
        else if(num==4){

            System.out.println("Informe o Nome do Médico:");

            String Nome = sc.nextLine();

            Medico medico = CSV.CSV_Pessoa.BuscaMedico(Nome);

            if(medico!=null){

                medico.ShowMedico();

            }
            else{

                System.out.println("Médico não Existe!");

            }

        }
        else if(num==5){



        }
        else if(num==6){



        }

        sc.close();

    }

}

package Trabalho_OO.Consultas;

import Trabalho_OO.CSVGerais.CSV_Geral;
import Trabalho_OO.Medico.CSVMedico;
import Trabalho_OO.Medico.Medico;
import Trabalho_OO.Paciente.CSVPaciente;
import Trabalho_OO.Paciente.Paciente;
import Trabalho_OO.PlanoDeSaude.CSVPlanoDeSaude;
import Trabalho_OO.PlanoDeSaude.PlanoDeSaude;
import java.io.FileNotFoundException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class CSVHistorico extends CSV_Geral {

    @Override
    public void SalvarCSV(Object obj) {

        Historico Historico = (Historico) obj;

        String FileName = Historico.getConsulta().getPaciente().getNome().replaceAll("\\s","_") + ".csv";

        try (BufferedReader Check = new BufferedReader(new FileReader(FileName))) {

            String TextoTemp;

            while ((TextoTemp = Check.readLine()) != null) {

                String[] Consulta = TextoTemp.split(";");

                String tipo = Consulta[0];
                String medico = Consulta[1];
                String paciente = Consulta[2];
                String data = Consulta[5];
                String horario = Consulta[6];

                if (tipo.equals(Historico.getConsulta().getTipoConsulta()) &&
                        medico.equals(Historico.getConsulta().getMedico().getNome()) &&
                        paciente.equals(Historico.getConsulta().getPaciente().getNome()) &&
                        data.equals(Historico.getConsulta().getData().toString()) &&
                        horario.equals(Historico.getConsulta().getHorario().toString())){

                    System.out.println("CONSULTA JÁ CADASTRADA!");

                    return;

                }

            }


        } catch (FileNotFoundException e) {

            //Lucas Ursulino Boaventura Eu Te Amo
            //nao tire esse comentario, se voce tirar ele nao roda

        } catch (Exception e) {

            System.out.println("Algum Erro Aconteceu");

        }

        try (FileWriter CSV = new FileWriter(FileName, true)) {

            Consulta consulta = Historico.getConsulta();

            CSV.write(

                    consulta.getTipoConsulta() + ";" +
                            consulta.getMedico().getNome() + ";" +
                            consulta.getPaciente().getNome() + ";" +
                            consulta.getPreço() + ";" +
                            consulta.getPlanoDeSaude().getNome() + ";" +
                            consulta.getData() + ";" +
                            consulta.getHorario() + "\n"

            );

            System.out.println("Historico salvo em " + FileName);

        } catch (IOException erro) {

            System.out.println("Erro ao Acessar Historico!");

        }

    }

    @Override
    public List<Consulta> buscarCSV(String cpf) {

        CSVPaciente csvPaciente = new CSVPaciente();
        Paciente paciente = (Paciente) csvPaciente.buscarCSV(cpf);

        if(paciente == null){
            System.out.println("Paciente Não Existe!");
            return new ArrayList<>();
        }

        String file = paciente.getNome() + ".csv";
        List<Consulta> historico = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length >= 7) {
                    String tipo = dados[0];
                    String nomeMedico = dados[1];
                    double preco = Double.parseDouble(dados[3]);
                    String planoNome = dados[4];
                    LocalDate data = LocalDate.parse(dados[5]);
                    LocalTime horario = LocalTime.parse(dados[6]);

                    CSVMedico csvMedico = new CSVMedico();
                    Medico medico = (Medico) csvMedico.buscarCSV(nomeMedico);

                    CSVPlanoDeSaude csvPlanoDeSaude = new CSVPlanoDeSaude();
                    PlanoDeSaude planoSaude = (PlanoDeSaude) csvPlanoDeSaude.buscarCSV(planoNome);

                    Consulta consulta = new Consulta(tipo, paciente, medico, preco, planoSaude, data, horario);
                    historico.add(consulta);
                }
            }

        }
        catch (IOException e){

            System.out.println("Erro ao Ler Arquivo: " + e.getMessage());

        }

        return historico;
    }

}



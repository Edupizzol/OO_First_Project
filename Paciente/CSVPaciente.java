package Trabalho_OO.Paciente;

import Trabalho_OO.CSVGerais.CSV_Geral;
import Trabalho_OO.PlanoDeSaude.PlanoDeSaude;
import Trabalho_OO.PlanoDeSaude.CSVPlanoDeSaude;
import Trabalho_OO.Paciente.Paciente;

import java.io.*;

public class CSVPaciente extends CSV_Geral {

    @Override
    public void SalvarCSV(Object obj) {

        Paciente Paciente = (Paciente) obj;

        String File = "Pacientes.csv";

        try {

            java.io.File file = new java.io.File(File);
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        catch (IOException e){

            e.getMessage();

        }

        try (BufferedReader Check = new BufferedReader(new FileReader(File))) {

            String TextoTemp;

            while ((TextoTemp = Check.readLine()) != null) {

                String[] CPF = TextoTemp.split(";");

                if (CPF.length > 1 && CPF[1].equals(Paciente.getCPF())){

                    System.out.println("PACIENTE JA FOI CADASTRADO!");

                    return;

                }
            }
        }
        catch (IOException error) {

            System.out.println("Algum erro aconteceu!");
        }

        try (FileWriter CSV = new FileWriter("Pacientes.csv", true)) {

            CSV.write(

                    Paciente.getNome() + ";" +
                            Paciente.getCPF() + ";" +
                            Paciente.getIdade() + ";" +
                            Paciente.getGenero() + ";" +
                            Paciente.getTelefone() + ";" +
                            Paciente.getEstadoCivil() + ";" +
                            Paciente.getTipoSanguineo() + ";" +
                            Paciente.getPlanoDeSaude().getNome() + ";" +
                            Paciente.getAltura() + ";" +
                            Paciente.getPeso() + "\n");

        } catch (IOException erro) {

            System.out.println("Erro ao Cadastrar Paciente!");

        }

    }

    @Override
    public Object buscarCSV(String CPF){

            String File = "Pacientes.csv"   ;

            try(BufferedReader Check = new BufferedReader(new FileReader(File))){

                String TextoTemp;

                while((TextoTemp = Check.readLine())!=null){

                    String[] Find = TextoTemp.split(";");

                    if(Find.length>1 && Find[1].equals(CPF)){

                        String nome = Find[0];
                        int idade = Integer.parseInt(Find[2]);
                        String genero = Find[3];
                        String telefone = Find[4];
                        String estadoCivil = Find[5];
                        String tipoSanguineo = Find[6];
                        String planoDeSaude = Find[7];
                        double altura = Double.parseDouble(Find[8]);
                        double peso = Double.parseDouble(Find[9]);

                        CSVPlanoDeSaude csvPlanoDeSaude = new CSVPlanoDeSaude();
                        PlanoDeSaude planoDeSaude1 = (PlanoDeSaude) csvPlanoDeSaude.buscarCSV(planoDeSaude);

                        Paciente paciente = new Paciente(nome, CPF, idade, genero, telefone, estadoCivil, tipoSanguineo, planoDeSaude1, altura, peso);

                        paciente.CarregarHistorico();

                        return paciente;

                    }

                }

            }
            catch (IOException e){

                System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

            }

            return null;

    }

}






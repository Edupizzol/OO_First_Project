package Trabalho_OO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVMedico extends CSV_Geral{

    @Override
    public void SalvarCSV(Object obj) {

        Medico Medico = (Medico) obj;

        try (BufferedReader Check = new BufferedReader(new FileReader("Medicos.csv"))) {

            String TextoTemp;

            while ((TextoTemp = Check.readLine()) != null) {

                String[] CPF = TextoTemp.split(";");

                if (CPF.length > 1 && CPF[1].equals(Medico.getCPF())){

                    System.out.println("MEDICO JA FOI CADASTRADO!");

                    return;

                }

            }

        } catch (IOException error) {
            System.out.println("Algum Erro Aconteceu!");
        }

        try (FileWriter CSV = new FileWriter("Medicos.csv", true)) {

            CSV.write(

                    Medico.getNome() + ";" +
                            Medico.getCPF() + ";" +
                            Medico.getIdade() + ";" +
                            Medico.getGenero() + ";" +
                            Medico.getTelefone() + ";" +
                            Medico.getEstadoCivil() + ";" +
                            Medico.getEspecialidade() + ";" +
                            Medico.getCRM() + ";" +
                            Medico.getEmailProfissional() + "\n");

        } catch (IOException erro) {

            System.out.println("Erro ao Cadastrar Médico!");

        }

    }

    @Override
    public Object buscarCSV(String Nome) {

        String File = "Medicos.csv";

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp = Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find.length>1 && Find[0].equals(Nome)){

                    String nome = Find[0];
                    String cpf = Find[1];
                    int idade = Integer.parseInt(Find[2]);
                    String genero = Find[3];
                    String telefone = Find[4];
                    String estadoCivil = Find[5];
                    String especialidade = Find[6];
                    String crm = Find[7];
                    String emailProfissional = Find[8];

                    return new Medico(nome, cpf, idade, genero, telefone, estadoCivil, especialidade, crm, emailProfissional);

                }

            }


        }
        catch (IOException e){

            System.out.println("Erro ao Ler Arquivo" + e.getMessage());

        }

        return null;

    }

}



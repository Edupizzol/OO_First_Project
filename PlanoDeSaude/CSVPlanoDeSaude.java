package Trabalho_OO.PlanoDeSaude;

import Trabalho_OO.CSVGerais.CSV_Geral;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVPlanoDeSaude extends CSV_Geral {

    @Override
    public void SalvarCSV(Object obj){

        PlanoDeSaude planodesaude = (PlanoDeSaude) obj;

        String File = "PlanoDeSaude.csv";

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp= Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find.length > 0 && (planodesaude.getNome().equals(Find[0]))){

                    System.out.println("Plano de Saúde já Existe");

                    return;

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao ler arquivo " + e.getMessage());

        }

        try(FileWriter CSV = new FileWriter(File,true)){

            CSV.write(

                    planodesaude.getNome() + ";" +
                            planodesaude.getDesconto() + "\n"


            );

            System.out.println("Plano de Saúde Registrado!");

        }
        catch(IOException e){

            System.out.println("Erro ao escrever arquivo " + e.getMessage());

        }

    }

    @Override
    public Object buscarCSV(String Nome) {

        String File = "PlanoDeSaude.csv";

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp = Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find.length>1 && Find[0].equals(Nome)){

                    String NomeP = Find[0];
                    double Desconto = Double.parseDouble(Find[1]);

                    return new PlanoDeSaude(NomeP,Desconto);

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao Ler Arquivo" + e.getMessage());

        }

        return null;

    }

}




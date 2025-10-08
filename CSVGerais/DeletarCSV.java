package Trabalho_OO.CSVGerais;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DeletarCSV {

    public static void REMOVE(String NomeFile, Predicate<String> condicao){

        File File = new File(NomeFile);

        List<String> CSVLinhas = new ArrayList<>();

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp=Check.readLine())!=null){

                if(!condicao.test(TextoTemp)){

                    CSVLinhas.add(TextoTemp);

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao Ler File: " + e.getMessage());
            return;

        }

        try(BufferedWriter CSV = new BufferedWriter(new FileWriter(File))){

            for(String LinhasCSV : CSVLinhas){

                CSV.write(LinhasCSV);
                CSV.newLine();

            }

            System.out.println("Objeto Removido!");

        }
        catch(IOException e){

            System.out.println("Erro ao Ler File: " + e.getMessage());

        }

    }

}

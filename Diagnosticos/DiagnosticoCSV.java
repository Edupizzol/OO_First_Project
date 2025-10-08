package Trabalho_OO.Diagnosticos;
import Trabalho_OO.CSVGerais.CSV_Geral;
import java.io.*;
import java.util.ArrayList;

public class DiagnosticoCSV extends CSV_Geral {

    @Override
    public void SalvarCSV(Object obj){

        Diagnostico diagnostico = (Diagnostico) obj;

        String File = "Diagnosticos.csv";

        try{

            java.io.File file = new java.io.File(File);

            if(!file.exists()){

                file.createNewFile();

            }
        }
        catch(IOException e){

            System.out.println("Erro ao criar arquivo: " + e.getMessage());

        }

        try {

            File Arquivo = new File(File);

            if (!Arquivo.exists()) {

                Arquivo.createNewFile();

            }

        }
        catch (IOException e) {

            e.printStackTrace();

        }

        try(FileWriter CSV = new FileWriter(File,true)){


                CSV.write(

                    diagnostico.getTipoConsulta() + ";" +
                            diagnostico.getNomePaciente() + ";" +
                            diagnostico.getNomeMedico() + ";" +
                            diagnostico.getDescricao() + "\n"

            );


        }
        catch (IOException e){

            System.out.println("Erro ao escrever arquivo " + e.getMessage());

        }

    }

    @Override
    public Object buscarCSV(String Nome) {

        String File = "Diagnosticos.csv";

        File file = new File(File);

        if(!file.exists()){
            try{

                file.createNewFile();

            } catch (IOException e){

                System.out.println("Erro ao criar arquivo Diagnosticos.csv: " + e.getMessage());
                return null;

            }
        }

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp=Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find.length >= 4 && Find[0].equals(Nome)){

                    return new Diagnostico(Find[0],Find[1],Find[2],Find[3]);

                }

            }

        }
        catch (IOException e){

            System.out.println("Erro ao escrever arquivo " + e.getMessage());

        }

        return null;

    }

    public ArrayList<Diagnostico> MostrarDiagnosticos(){

        ArrayList<Diagnostico> diagnosticos = new ArrayList<>();

        String File = "Diagnosticos.csv";

        File file = new File(File);

        if(!file.exists()){

            try{

                file.createNewFile();

            }
            catch (IOException e){

                System.out.println("Erro ao criar arquivo Diagnosticos.csv: " + e.getMessage());
                return diagnosticos; // retorna lista vazia

            }

        }

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp=Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                Diagnostico diagnostico = new Diagnostico(Find[0], Find[1], Find[2], Find[3]);

                diagnosticos.add(diagnostico);

            }

        }
        catch (IOException e){

            System.out.println("Erro ao escrever arquivo " + e.getMessage());

        }

        return diagnosticos;

    }

}

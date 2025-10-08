package Trabalho_OO.Internacoes;


import Trabalho_OO.Internacoes.Internacao;
import Trabalho_OO.Paciente.Paciente;
import Trabalho_OO.Medico.Medico;
import Trabalho_OO.Paciente.CSVPaciente;
import Trabalho_OO.Medico.CSVMedico;
import Trabalho_OO.CSVGerais.CSV_Geral;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVInternacao extends CSV_Geral {

    @Override
    public void SalvarCSV(Object obj) {

        Internacao internacao = (Internacao) obj;

        String File = "Internações.csv";

        try{

            java.io.File file = new java.io.File(File);

            if(!file.exists()){

                file.createNewFile();

            }
        }
        catch(IOException e){

            System.out.println("Erro ao criar arquivo: " + e.getMessage());

        }

        try(BufferedReader check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp= check.readLine())!=null){

                String[] find = TextoTemp.split(";");

                if(find.length > 0 && find[0].equals(internacao.getPaciente().getNome())
                        && find[2].equals(internacao.getDataDeEntrada().toString())){

                    System.out.println("Paciente Já Foi Internado!");

                    return;

                }

                LocalDate entradaExistente = LocalDate.parse(find[2]);
                LocalDate saidaExistente = LocalDate.parse(find[3]);

                boolean QuartoOcupado = find[5].equals(internacao.getQuarto()) &&
                        (internacao.getDataDeEntrada().isBefore(saidaExistente) &&
                                internacao.getDataDeSaída().isAfter(entradaExistente));

                if(QuartoOcupado){

                    System.out.println("Quarto Já Está Ocupado!");
                    return;

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

        }

        try(FileWriter CSV = new FileWriter(File,true)){

            CSV.write(

                    internacao.getPaciente().getCPF() + ";" +
                            internacao.getMedicoResponsável().getNome() + ";" +
                            internacao.getDataDeEntrada() + ";" +
                            internacao.getDataDeSaída() + ";" +
                            internacao.getStatus() + ";" +
                            internacao.getQuarto() + ";" +
                            internacao.getCustoInternação() + "\n"

            );

            System.out.println("Internação Foi Cadastrada!");

        }
        catch(IOException e){

            System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

        }

    }

    @Override
    public Object buscarCSV(String Nome) {
        return null;
    }

    public List<Internacao> BuscarInternacoesPorPaciente(String CPF){

        List<Internacao> internacoes = new ArrayList<>();

        String File = "Internações.csv";

        File file = new File(File);

        if(!file.exists()){

            try{

                file.createNewFile();
                return internacoes;

            }
            catch(IOException e){

                System.out.println("Erro ao criar arquivo Internações.csv: " + e.getMessage());
                return internacoes;

            }

        }

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp=Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find[0].equals(CPF)){

                    String CPFpaciente = Find[0];
                    String NomeMedicoResponsavel = Find[1];
                    LocalDate DataDeEntrada = LocalDate.parse(Find[2]);
                    LocalDate DataDeSaida = LocalDate.parse(Find[3]);
                    String Status = Find[4];
                    String Quarto = Find[5];
                    double Preco = Double.parseDouble(Find[6]);

                    Paciente paciente = new Paciente("", CPF, 0, "", "", "", "", null, 0, 0);

                    CSVMedico csvMedico = new CSVMedico();
                    Medico MedicoResponsavel = (Medico) csvMedico.buscarCSV(NomeMedicoResponsavel);

                    internacoes.add(new Internacao(paciente,MedicoResponsavel,DataDeEntrada,DataDeSaida,Status,Quarto,Preco));

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

        }

        return internacoes;

    }

    public Boolean InternacaoPossivel(Internacao internacao, List<Internacao> internacoesMemoria){

        String File = "Internações.csv";

        File file = new File(File);

        if (!file.exists()){

            try{

                file.createNewFile();
                return false;

            }
            catch (IOException e){

                System.out.println("Erro ao criar arquivo Internações.csv: " + e.getMessage());
                return false;

            }

        }

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp= Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                String Quarto = Find[5];
                LocalDate Inicio = LocalDate.parse(Find[2]);
                LocalDate Fim = LocalDate.parse(Find[3]);

                if(Quarto.equals(internacao.getQuarto())){

                    if(!(internacao.getDataDeSaída().isBefore(Inicio) || internacao.getDataDeEntrada().isAfter(Fim))){

                        System.out.println("Esse Leito já Está Ocupado, não é Possível Marcar a Internação");

                        return false;

                    }

                }

            }


        }
        catch(IOException e){

            System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

        }

        for(Internacao i : internacoesMemoria){

            if(i.getQuarto().equals(internacao.getQuarto())){

                if(!(internacao.getDataDeSaída().isBefore(i.getDataDeEntrada()) || internacao.getDataDeEntrada().isAfter(i.getDataDeSaída()))){

                    System.out.println("Esse Leito já Está Ocupado na memória, não é Possível Marcar a Internação");
                    return false;

                }

            }

        }

        return true;

    }

}


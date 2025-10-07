package Trabalho_OO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.lang.Math;

public class CSVConsulta extends CSV_Geral{

    @Override
    public void SalvarCSV(Object obj) {

        Consulta consulta= (Consulta) obj;

        String File = "Consultas.csv";

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp= Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if (consulta.getMedico().getNome().equals(Find[1]) &&
                        consulta.getPaciente().getCPF().equals(Find[2]) &&
                        consulta.getData().toString().equals(Find[5]) &&
                        consulta.getHorario().toString().equals(Find[6])) {

                    System.out.println("Médico ou Paciente Já Possui Consulta Neste Horário!");

                    return;

                }

            }

        }
        catch (IOException e){

            System.out.println("Erro " + e.getMessage());

        }

        try(FileWriter CSV = new FileWriter(File, true)){

            CSV.write(

                    consulta.getTipoConsulta() + ";" +
                            consulta.getMedico().getNome() + ";" +
                            consulta.getPaciente().getCPF() + ";" +
                            consulta.getPreço() + ";" +
                            consulta.getPlanoDeSaude().getNome() + ";" +
                            consulta.getData() + ";" +
                            consulta.getHorario() + "\n"

            );

            System.out.println("Consulta foi Cadastrada!");

        }
        catch(IOException e){

            System.out.println("Erro " + e.getMessage());

        }

    }

    @Override
    public Object buscarCSV(String Nome) {

        return null;

    }

    public List<Consulta> buscarConsultasPorPaciente(String cpfPaciente) {

        List<Consulta> consultas = new ArrayList<>();

        String File = "Consultas.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(File))) {

            String TextoTemp;

            while ((TextoTemp = br.readLine()) != null){

                String[] Find = TextoTemp.split(";");

                if (Find.length >= 7 && Find[2].equals(cpfPaciente)){

                    String tipoConsulta = Find[0];
                    Medico medico = new Medico(Find[1], "", 0, "", "", "", "", "", "");
                    Paciente paciente = new Paciente("", cpfPaciente, 0, "", "", "", "", null, 0, 0);
                    double preco = Double.parseDouble(Find[3]);
                    PlanoDeSaude plano = null;
                    LocalDate dataConsulta = LocalDate.parse(Find[5]);
                    LocalTime horario = LocalTime.parse(Find[6]);

                    consultas.add(new Consulta(tipoConsulta, paciente, medico, preco, plano, dataConsulta, horario));
                }
            }
        }
        catch(IOException e){

            System.out.println("Erro ao Ler Arquivo" + e.getMessage());

        }

        return consultas;

    }

    public List<Consulta> buscarConsultasPorMedico(String Nome){

        List<Consulta> consultas = new ArrayList<>();

        String File = "Consultas.csv";

        try(BufferedReader Check = new BufferedReader(new FileReader(File))){

            String TextoTemp;

            while((TextoTemp = Check.readLine())!=null){

                String[] Find = TextoTemp.split(";");

                if(Find.length >= 7 && Find[1].equals(Nome)){

                    String tipoConsulta = Find[0];
                    Medico medico = new Medico(Nome, "", 0, "", "", "", "", "", "");
                    Paciente paciente = new Paciente("", Find[2], 0, "", "", "", "", null, 0, 0);
                    double preco = Double.parseDouble(Find[3]);
                    PlanoDeSaude plano = null;
                    LocalDate dataConsulta = LocalDate.parse(Find[5]);
                    LocalTime horario = LocalTime.parse(Find[6]);

                    consultas.add(new Consulta(tipoConsulta, paciente, medico, preco, plano, dataConsulta, horario));

                }

            }

        }
        catch(IOException e){

            System.out.println("Erro ao Ler Arquivo" + e.getMessage());

        }

        return consultas;

    }

    public boolean ConsultaPossivel(Consulta consulta) {

        String File = "Consultas.csv";

            try(BufferedReader Check = new BufferedReader(new FileReader(File))){

                String TextoTemp;

                while((TextoTemp = Check.readLine()) != null){

                    String[] Find = TextoTemp.split(";");

                    LocalDate Data = LocalDate.parse(Find[5]);
                    LocalTime Hora = LocalTime.parse(Find[6]);

                    if(Data.equals(consulta.getData())) {

                        long Minutos = Math.abs(java.time.Duration.between(Hora, consulta.getHorario()).toMinutes());

                        if (Minutos < 60) {

                            if (Find[2].equals(consulta.getPaciente().getCPF())) {

                                System.out.println("Paciente já Possui Consulta Próximo Desse Horário!");
                                return true;

                            }

                            if (Find[1].equals(consulta.getMedico().getNome())) {

                                System.out.println("Médico já Possui Consulta Próximo Desse Horário!");
                                return true;

                            }

                        }
                    }

                }
            }
            catch(IOException e){

                System.out.println("Erro ao ler arquivo: " + e.getMessage());

            }

            return false;

    }


}

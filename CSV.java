package Trabalho_OO;

import java.io.*;
import java.util.ArrayList;

public class CSV {

    public static class CSV_Pessoa {

        static boolean IsEqual = false;

        static boolean StrComp(String CPF, String Comp) {

            return IsEqual = CPF.equals(Comp);

        }

        public static void CSV_Paciente(Paciente Paciente) {

            try (BufferedReader Check = new BufferedReader(new FileReader("Pacientes.csv"))) {

                String TextoTemp;

                while ((TextoTemp = Check.readLine()) != null) {

                    String[] CPF = TextoTemp.split(";");

                    if (CPF.length > 1 && StrComp(CPF[1], Paciente.getCPF()) == true) {

                        System.out.println("PACIENTE JA FOI CADASTRADO!");

                        return;

                    }
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
                                    Paciente.getPlanoDeSaude() + ";" +
                                    Paciente.getAltura() + ";" +
                                    Paciente.getPeso() + "\n");

                } catch (IOException erro) {

                    System.out.println("Erro ao Cadastrar Paciente!");

                }
            } catch (IOException error) {
                System.out.println("Algum erro aconteceu!");
            }

        }

        public static void CSV_Medico(Medico Medico) {

            try (BufferedReader Check = new BufferedReader(new FileReader("Medicos.csv"))) {

                String TextoTemp;

                while ((TextoTemp = Check.readLine()) != null) {

                    String[] CPF = TextoTemp.split(";");

                    if (CPF.length > 1 && StrComp(CPF[1], Medico.getCPF()) == true) {

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

        public static void CSV_Historico(Historico Historico) {


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

        public static void PlanoDeSaudeCSV(PlanoDeSaude planodesaude){

            String File = "PlanoDeSaude.csv";

            try(BufferedReader Check = new BufferedReader(new FileReader(File))){

                String TextoTemp;

                while((TextoTemp= Check.readLine())!=null){

                    String[] Find = TextoTemp.split(";");

                    if(Find.length > 0 && StrComp(planodesaude.getNome(), Find[0])==true){

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

        public static void ConsultaCSV(Consulta consulta){

            String File = "Consultas.csv";

            try(BufferedReader Check = new BufferedReader(new FileReader(File))){

                String TextoTemp;

                while((TextoTemp= Check.readLine())!=null){

                    String[] Find = TextoTemp.split(";");

                    if (consulta.getMedico().getNome().equals(Find[1]) &&
                            consulta.getPaciente().getNome().equals(Find[2]) &&
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
                                consulta.getPaciente().getNome() + ";" +
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

        public static Paciente BuscaPaciente(String CPF){

            String File = "Pacientes.csv";

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

                        return new Paciente(nome, CPF, idade, genero, telefone, estadoCivil, tipoSanguineo, planoDeSaude, altura, peso);

                    }

                }

            }
            catch (IOException e){

                System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());

            }

            return null;

        }

        public static Medico BuscaMedico(String Nome){

            String File = "Medicos.csv";

            try(BufferedReader Check = new BufferedReader(new FileReader(File))){

                String TextoTemp;

                while((TextoTemp= Check.readLine())!=null){

                    String[] Find = TextoTemp.split(";");

                    if(Find.length>1 && Find[0].equals(Nome)){

                        String nome = Find[0];
                        String cpf = Find[1];
                        int idade = Integer.parseInt(Find[2]);
                        String genero = Find[3];
                        String telefone = Find[4];
                        String estadoCivil = Find[5];
                        String especialidade = Find[6];
                        String emailProfissional = Find[7];
                        String crm = Find[8];

                        return new Medico(nome, cpf, idade, genero, telefone, estadoCivil, especialidade, emailProfissional, crm);

                    }

                }


            }
            catch (IOException e){

                System.out.println("Erro ao Ler Arquivo" + e.getMessage());

            }

            return null;

        }

    }

}






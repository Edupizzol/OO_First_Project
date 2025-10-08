package Trabalho_OO;

public abstract class Menu {

    public abstract void executarOpção(int N);

    public void MostrarOpções(){

        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println("Cadastrar Paciente: Digite 1");
        System.out.println("Cadastrar Médico: Digite 2");
        System.out.println("Ver Paciente: Digite 3");
        System.out.println("Ver Médico: Digite 4");
        System.out.println("Cadastrar Plano de Saúde: 5");
        System.out.println("Marcar Consulta: Digite 6");
        System.out.println("Agendar Internação: Digite 7");
        System.out.println("Registrar Diagnóstico: Digite 8");
        System.out.println("Ver Diagnóstico: Digite 9");
        System.out.println("Deletar Algum Arquivo: Digite 10");

    }

}

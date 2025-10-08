package Trabalho_OO.Paciente;

import Trabalho_OO.PlanoDeSaude.PlanoDeSaude;

public class PacienteEspecial extends Paciente{

    public PacienteEspecial(String nome, String cpf, int idade){

        super(nome, cpf, idade, "", "", "", "", null, 0, 0);

    }

    public PacienteEspecial(String nome, String cpf, int idade, PlanoDeSaude planoDeSaude) {

        super(nome, cpf, idade, "", "", "", "", planoDeSaude, 0, 0);

    }

    public PacienteEspecial(String nome, String cpf, int idade, String genero, String telefone, String estadoCivil, String tipoSanguineo, PlanoDeSaude planoDeSaude, double altura, double peso) {

        super(nome, cpf, idade, genero, telefone, estadoCivil, tipoSanguineo, planoDeSaude, altura, peso);

    }

    public double getDescontoIdade(double Preco){

        return Preco*0.10;

    }

}

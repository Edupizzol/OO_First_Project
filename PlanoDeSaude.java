package Trabalho_OO;

public class PlanoDeSaude {

    private String Nome;
    private double Desconto;

    PlanoDeSaude(String Nome, double Desconto){

        this.Nome = Nome;
        this.Desconto = Desconto;

    }


    public String getNome(){

        return Nome;

    }


    public double getDesconto(){

        return Desconto;

    }


}

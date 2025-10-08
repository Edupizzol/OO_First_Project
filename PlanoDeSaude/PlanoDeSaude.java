package Trabalho_OO.PlanoDeSaude;

public class PlanoDeSaude {

    private String Nome;
    private double Desconto;

    public PlanoDeSaude(String Nome, double Desconto){

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

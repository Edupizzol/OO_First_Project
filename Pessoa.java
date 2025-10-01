package Trabalho_OO;

import java.lang.ref.PhantomReference;

public class Pessoa{

    private String Nome;
    private String CPF;
    private int Idade;
    private String Genero;
    private String Telefone;
    private String EstadoCivil;

    Pessoa(String Nome, String CPF, int Idade, String Genero, String Telefone, String Estado_Civil){

        this.Nome = Nome;
        this.CPF = CPF;
        this.Idade = Idade;
        this.Genero = Genero;
        this.Telefone = Telefone;
        this.EstadoCivil = Estado_Civil;

    }

    public String getNome(){

        return this.Nome;

    }
    public String getCPF(){

        return this.CPF;

    }
    public int getIdade(){

        return this.Idade;

    }
    public String getGenero(){

        return this.Genero;

    }
    public String getTelefone(){

        return this.Telefone;

    }
    public String getEstadoCivil(){

        return this.EstadoCivil;

    }

}

package Trabalho_OO;

public class Medico extends Pessoa{

    private String Especialidade;
    private String EmailProfissional;
    private String CRM;

    Medico(String Nome, String CPF, int Idade, String Genero, String Telefone, String EstadoCivil, String Especialidade, String EmailProfissional, String CRM){

        super(Nome,CPF,Idade,Genero,Telefone,EstadoCivil);

        this.Especialidade = Especialidade;
        this.CRM = CRM;
        this.EmailProfissional = EmailProfissional;

    }

    public String getEspecialidade(){

        return this.Especialidade;

    }

    public String getCRM(){

        return this.CRM;

    }

    public String getEmailProfissional(){

        return this.EmailProfissional;

    }

    public void ShowMedico(){

        System.out.println("===Dados do Medico===");
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("CPF: %s\n", getCPF());
        System.out.printf("Idade: %d\n", getIdade());
        System.out.printf("Genero: %s\n", getGenero());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Estado Civil: %s\n", getEstadoCivil());
        System.out.printf("Especialidade: %s\n", getEspecialidade());
        System.out.printf("CRM: %s\n", getCRM());
        System.out.printf("Email: %s\n", getEmailProfissional());

    }

}

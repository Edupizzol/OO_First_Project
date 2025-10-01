package Trabalho_OO;

public class Paciente extends Pessoa{

    private String PlanoDeSaude;
    private String TipoSanguineo;
    private double Altura;
    private double Peso;

    Paciente(String Nome, String CPF, int Idade, String Genero, String Telefone, String Estado_Civil, String TipoSanguineo, String PlanoDeSaude, double Altura, double Peso){

        super(Nome, CPF, Idade, Genero, Telefone, Estado_Civil);

        this.PlanoDeSaude = PlanoDeSaude;
        this.TipoSanguineo = TipoSanguineo;
        this.Altura = Altura;
        this.Peso = Peso;

    }

    public String getPlanoDeSaude(){

        return this.PlanoDeSaude;

    }

    public String getTipoSanguineo(){

        return this.TipoSanguineo;

    }

    public double getAltura(){

        return this.Altura;

    }

    public double getPeso(){

        return this.Peso;

    }

    void ShowPaciente(){

        System.out.println("===Dados do Paciente===");
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("CPF: %s\n", getCPF());
        System.out.printf("Idade: %d\n", getIdade());
        System.out.printf("Genero: %s\n", getGenero());
        System.out.printf("Telefone: %s\n", getTelefone());
        System.out.printf("Estado Civil: %s\n", getEstadoCivil());
        System.out.printf("TipoSanguineo: %s\n", getTipoSanguineo());
        System.out.printf("Plano de Saude: %s\n", getPlanoDeSaude());
        System.out.printf("Altura: %.2f\n", getAltura());
        System.out.printf("Peso: %.2f\n", getPeso());

    }

}

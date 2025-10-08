package Trabalho_OO.Diagnosticos;

public class Diagnostico {

    private String tipoConsulta;
    private String nomePaciente;
    private String nomeMedico;
    private String descricao;

    public Diagnostico(String tipoConsulta, String nomePaciente, String nomeMedico, String descricao) {


        this.tipoConsulta = tipoConsulta;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.descricao = descricao;

    }

    public String getTipoConsulta() {

        return tipoConsulta;

    }

    public String getNomePaciente() {

            return nomePaciente;

    }

    public String getNomeMedico() {

        return nomeMedico;

    }

    public String getDescricao() {

        return descricao;

    }

}



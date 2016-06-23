package com.app.ludus.healer.model;


public class ModelPaciente
{
    private int idPaciente;
    private String nomePaciente;
    private String nomeResponsavel;

    public int getIdPaciente()
    {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente)
    {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente()
    {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente)
    {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeResponsavel()
    {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel)
    {
        this.nomeResponsavel = nomeResponsavel;
    }
}

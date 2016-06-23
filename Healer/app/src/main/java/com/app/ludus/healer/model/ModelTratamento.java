package com.app.ludus.healer.model;

public class ModelTratamento
{
    private int idTratamento;
    private String dataInicio;
    private String dataTermino;
    private String faseTratamento;

    public int getIdTratamento()
    {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento)
    {
        this.idTratamento = idTratamento;
    }

    public String getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio)
    {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino()
    {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino)
    {
        this.dataTermino = dataTermino;
    }

    public String getFaseTratamento()
    {
        return faseTratamento;
    }

    public void setFaseTratamento(String faseTratamento)
    {
        this.faseTratamento = faseTratamento;
    }
}

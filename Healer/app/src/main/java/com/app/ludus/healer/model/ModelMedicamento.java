package com.app.ludus.healer.model;

public class ModelMedicamento
{
    private int idMedicamento;
    private String nomeMedicamento;
    private int qtdMedicamento;
    private String corMedicamento;
    private String horaMedicamento;
    private String dataCriacao;
    private ModelTratamento tratamento;
    private int isActive;
    private String faseTratamento;

    public int getIdMedicamento()
    {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento)
    {
        this.idMedicamento = idMedicamento;
    }

    public String getNomeMedicamento()
    {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento)
    {
        this.nomeMedicamento = nomeMedicamento;
    }

    public int getQtdMedicamento()
    {
        return qtdMedicamento;
    }

    public void setQtdMedicamento(int qtdMedicamento)
    {
        this.qtdMedicamento = qtdMedicamento;
    }

    public String getCorMedicamento()
    {
        return corMedicamento;
    }

    public void setCorMedicamento(String corMedicamento)
    {
        this.corMedicamento = corMedicamento;
    }

    public String getHoraMedicamento()
    {
        return horaMedicamento;
    }

    public void setHoraMedicamento(String horaMedicamento)
    {
        this.horaMedicamento = horaMedicamento;
    }

    public String getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public ModelTratamento getTratamento()
    {
        return tratamento;
    }

    public void setTratamento(ModelTratamento tratamento)
    {
        this.tratamento = tratamento;
    }

    public int isActive()
    {
        return isActive;
    }

    public void setActive(int active)
    {
        isActive = active;
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

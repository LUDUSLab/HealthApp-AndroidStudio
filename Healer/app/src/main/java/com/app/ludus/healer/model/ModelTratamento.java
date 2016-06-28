package com.app.ludus.healer.model;

public class ModelTratamento
{
    private int idTratamento;
    private String nomeTratamento;
    private String dataInicio;
    private String dataTermino;
    private ModelPaciente paciente;
    private ModelResponsavel responsavel;

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    public String getNomeTratamento() {
        return nomeTratamento;
    }

    public void setNomeTratamento(String nomeTratamento) {
        this.nomeTratamento = nomeTratamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public ModelPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ModelPaciente paciente) {
        this.paciente = paciente;
    }

    public ModelResponsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ModelResponsavel responsavel) {
        this.responsavel = responsavel;
    }
}

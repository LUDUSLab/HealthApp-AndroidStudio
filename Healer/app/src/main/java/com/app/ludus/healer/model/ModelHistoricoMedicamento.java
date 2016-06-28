package com.app.ludus.healer.model;

public class ModelHistoricoMedicamento
{
    private int idHistoricoMedicamento;
    private String horaPrevista;
    private String horaReal;
    private String statusMedicamento;
    private ModelMedicamento medicamento;

    public int getIdHistoricoMedicamento() {
        return idHistoricoMedicamento;
    }

    public void setIdHistoricoMedicamento(int idHistoricoMedicamento) {
        this.idHistoricoMedicamento = idHistoricoMedicamento;
    }

    public String getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(String horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public String getHoraReal() {
        return horaReal;
    }

    public void setHoraReal(String horaReal) {
        this.horaReal = horaReal;
    }

    public String getStatusMedicamento() {
        return statusMedicamento;
    }

    public void setStatusMedicamento(String statusMedicamento) {
        this.statusMedicamento = statusMedicamento;
    }

    public ModelMedicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(ModelMedicamento medicamento) {
        this.medicamento = medicamento;
    }
}

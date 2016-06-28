package com.app.ludus.healer.model;


public class ModelPaciente
{
    private int idPaciente;
    private String nomePaciente;
    private String nDeRegistroDaUnidadeSaude;
    private String cartaoNacionalDeSaude;
    private String dataDeNascimento;
    private String telefone;
    private String endereco;
    private String tuberculose;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getnDeRegistroDaUnidadeSaude() {
        return nDeRegistroDaUnidadeSaude;
    }

    public void setnDeRegistroDaUnidadeSaude(String nDeRegistroDaUnidadeSaude) {
        this.nDeRegistroDaUnidadeSaude = nDeRegistroDaUnidadeSaude;
    }

    public String getCartaoNacionalDeSaude() {
        return cartaoNacionalDeSaude;
    }

    public void setCartaoNacionalDeSaude(String cartaoNacionalDeSaude) {
        this.cartaoNacionalDeSaude = cartaoNacionalDeSaude;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(String tuberculose) {
        this.tuberculose = tuberculose;
    }
}

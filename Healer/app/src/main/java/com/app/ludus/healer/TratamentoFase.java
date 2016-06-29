package com.app.ludus.healer;

/**
 * Created by mps.ads on 29/06/2016.
 */
public class TratamentoFase {
    private String nomeFase;
    private int resourceId;

    public TratamentoFase() {
    }

    public TratamentoFase(String nomeFase, int resourceId) {
        this.nomeFase = nomeFase;
        this.resourceId = resourceId;
    }

    public String getNomeFase() {
        return nomeFase;
    }

    public void setNomeFase(String nomeFase) {
        this.nomeFase = nomeFase;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}

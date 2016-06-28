package com.app.ludus.healer;

/**
 * Created by LUDUS on 28/06/2016.
 */
public class MenuOpcao {
    private String opcao;
    private int resourceId;

    public MenuOpcao() {

    }

    public MenuOpcao(String opcao, int resourceId) {
        this.opcao = opcao;
        this.resourceId = resourceId;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}

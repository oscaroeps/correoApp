package com.mig.personal.correoApp;

public class TipoCorreo {
    private int nId;
    private String sTipoCorreo;

    public TipoCorreo() {
    }

    public TipoCorreo(int nId, String sTipoCorreo) {
        this.nId = nId;
        this.sTipoCorreo = sTipoCorreo;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsTipoCorreo() {
        return sTipoCorreo;
    }

    public void setsTipoCorreo(String sTipoCorreo) {
        this.sTipoCorreo = sTipoCorreo;
    }
}

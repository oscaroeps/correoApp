package com.mig.personal.correoApp;

public class Correo {
    private int nId;
    private String sNombre;
    private String sCorreo;
    private Integer nIdTipoCorreo;
    private String sTipoCorreo;


    // Constructor vacío
    public Correo() {
    }

    // Constructor con parámetros (opcional)
    public Correo(int nId, String sNombre, String sCorreo, int nIdTipoCorreo) {
        this.nId = nId;
        this.sNombre = sNombre;
        this.sCorreo = sCorreo;
        this.nIdTipoCorreo = nIdTipoCorreo;
    }

    // Getters y Setters
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsCorreo() {
        return sCorreo;
    }

    public void setsCorreo(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public Integer getnIdTipoCorreo() {
        return nIdTipoCorreo;
    }

    public void setnIdTipoCorreo(Integer nIdTipoCorreo) {
        this.nIdTipoCorreo = nIdTipoCorreo;
    }
    
    public String getsTipoCorreo() {
        return sTipoCorreo;
    }

    public void setsTipoCorreo(String sTipoCorreo) {
        this.sTipoCorreo = sTipoCorreo;
    }

}

package com.mig.personal.correoApp;

import javax.persistence.*;

@Entity
@Table(name = "TC_CORREO")
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "N_ID")
    private int nId;

    @Column(name = "S_NOMBRE")
    private String sNombre;

    @Column(name = "S_CORREO")
    private String sCorreo;

    // Este campo almacena el ID del tipo de correo
    @Column(name = "N_IDTIPOCORREO")
    private Integer nIdTipoCorreo;

    // Este campo se usará para mostrar el nombre del tipo en la vista;
    // lo marcamos como @Transient ya que se calcula en la lógica de negocio
    @Transient
    private String sTipoCorreo;

    // Constructores, getters y setters
    public Correo() {
    }

    // Getters y setters...
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
        if (sTipoCorreo == null) {
            if (nIdTipoCorreo != null) {
                switch (nIdTipoCorreo) {
                    case 1:
                        return "Personal";
                    case 2:
                        return "Laboral";
                    case 3:
                        return "Otro";
                    default:
                        return "Desconocido";
                }
            } else {
                return "No especificado";
            }
        }
        return sTipoCorreo;
    }
    public void setsTipoCorreo(String sTipoCorreo) {
        this.sTipoCorreo = sTipoCorreo;
    }
}

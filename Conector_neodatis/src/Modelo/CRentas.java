/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CRentas {

    int ID_Renta, ID_Socio, No_Ejemplar;
    String Socio, Ejemplar, fecha_renta, fecha_devol, Status;

    public CRentas(int ID_Renta, int ID_Socio, String Socio, String Ejemplar, int No_Ejemplar, String fecha_renta, String fecha_devol, String Status) {
        this.ID_Renta = ID_Renta;
        this.ID_Socio = ID_Socio;
        this.Socio = Socio;
        this.Ejemplar = Ejemplar;
        this.No_Ejemplar = No_Ejemplar;
        this.fecha_renta = fecha_renta;
        this.fecha_devol = fecha_devol;
        this.Status = Status;
    }

    public int getID_Renta() {
        return ID_Renta;
    }

    public void setID_Renta(int ID_Renta) {
        this.ID_Renta = ID_Renta;
    }

    public int getID_Socio() {
        return ID_Socio;
    }

    public void setID_Socio(int ID_Socio) {
        this.ID_Socio = ID_Socio;
    }

    public String getSocio() {
        return Socio;
    }

    public void setSocio(String Socio) {
        this.Socio = Socio;
    }

    public String getEjemplar() {
        return Ejemplar;
    }

    public void setEjemplar(String Ejemplar) {
        this.Ejemplar = Ejemplar;
    }

    public int getNo_Ejemplar() {
        return No_Ejemplar;
    }

    public void setNo_Ejemplar(int No_Ejemplar) {
        this.No_Ejemplar = No_Ejemplar;
    }

    public String getFecha_renta() {
        return fecha_renta;
    }

    public void setFecha_renta(String fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public String getFecha_devol() {
        return fecha_devol;
    }

    public void setFecha_devol(String fecha_devol) {
        this.fecha_devol = fecha_devol;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CPeliculas {

    int ID;
    String Titulo, Nacionalidad, Productora, Fecha;

    public CPeliculas() {
    }

    public CPeliculas(int ID, String Titulo, String Nacionalidad, String Productora, String Fecha) {
        this.ID = ID;
        this.Nacionalidad = Nacionalidad;
        this.Productora = Productora;
        this.Fecha = Fecha;
        this.Titulo = Titulo;
    }

    public CPeliculas(int ID, String Titulo) {
        this.ID = ID;
        this.Titulo = Titulo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public String getProductora() {
        return Productora;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public void setProductora(String Productora) {
        this.Productora = Productora;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

}

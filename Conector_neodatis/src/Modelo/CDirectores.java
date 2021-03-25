/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CDirectores {

    int ID;
    String Nombre, Nacionalidad, Pelicula;

    public CDirectores(int ID, String Nombre, String Nacionalidad, String Pelicula) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Nacionalidad = Nacionalidad;
        this.Pelicula = Pelicula;
    }

    public CDirectores(int ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public CDirectores() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }

}

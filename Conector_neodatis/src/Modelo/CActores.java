/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CActores {

    int ID;
    String Nombre, Nacionalidad, Sexo, Pelicula, Principal;

    public CActores(int ID, String Nombre, String Nacionalidad, String Sexo, String Pelicula, String Principal) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Nacionalidad = Nacionalidad;
        this.Sexo = Sexo;
        this.Pelicula = Pelicula;
        this.Principal = Principal;
    }

    public CActores(int ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public CActores() {
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Película) {
        this.Pelicula = Película;
    }

    public String getPrincipal() {
        return Principal;
    }

    public void setPrincipal(String Principal) {
        this.Principal = Principal;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CEjemplares {

    int ID;
    String Pelicula, Conservacion, Status;

    public CEjemplares(int ID, String Pelicula, String Conservacion, String Status) {
        this.ID = ID;
        this.Pelicula = Pelicula;
        this.Conservacion = Conservacion;
        this.Status = Status;
    }

    public CEjemplares(int ID, String Pelicula) {
        this.ID = ID;
        this.Pelicula = Pelicula;
    }

    public CEjemplares() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }

    public String getConservacion() {
        return Conservacion;
    }

    public void setConservacion(String Conservacion) {
        this.Conservacion = Conservacion;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}

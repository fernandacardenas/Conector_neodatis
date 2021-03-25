/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Omar Olmedo
 */
public class CSocios {

    int ID, ID_Aval;
    String Nombre, Direccion, Telefono, Status;

    public CSocios(int ID, String Nombre, String Direccion, String Telefono, String Status, int ID_Aval) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Status = Status;
        this.ID_Aval = ID_Aval;
    }

    public CSocios(int ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public CSocios() {
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getID_Aval() {
        return ID_Aval;
    }

    public void setID_Aval(int ID_Aval) {
        this.ID_Aval = ID_Aval;
    }

}

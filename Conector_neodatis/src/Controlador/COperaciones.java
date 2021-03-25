/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Omar Olmedo
 */
import java.math.BigInteger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class COperaciones {

    public void insertar(Object ob) {
        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        odb.store(ob);
        odb.close();
        JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
    }

    public void insertarcliente(Object ob) {
        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consults = new CriteriaQuery(Modelo.CSocios.class, Where.equal("Status", "1"));
        odb.store(ob);
        odb.close();
        JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
    }

    public DefaultListModel getClientesNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consultotas = new CriteriaQuery(Modelo.CSocios.class, Where.equal("Status", "1"));
        Objects<Modelo.CSocios> objects = odb.getObjects(consultotas);

        while (objects.hasNext()) {
            Modelo.CSocios cli = objects.next();
            dlm.addElement(cli);
        }
        odb.close();

        return dlm;
    }

    public DefaultListModel getexClientesNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consultotas = new CriteriaQuery(Modelo.CSocios.class, Where.equal("Status", "0"));
        Objects<Modelo.CSocios> objects = odb.getObjects(consultotas);

        while (objects.hasNext()) {
            Modelo.CSocios cli = objects.next();

            dlm.addElement(cli);
        }
        odb.close();

        return dlm;
    }

    public DefaultListModel obtenerpeliculaNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");

        Objects<Modelo.CPeliculas> objects = odb.getObjects(Modelo.CPeliculas.class);

        while (objects.hasNext()) {
            Modelo.CPeliculas pro = objects.next();
            dlm.addElement(pro.getTitulo());
        }
        odb.close();

        return dlm;
    }

    public void eliminar_CliNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery query = new CriteriaQuery(Modelo.CSocios.class, Where.equal("ID", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            odbe.deleteCascade(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El cliente no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("El cliente no existe.");
        } finally {
            odbe.close();
        }
    }

    public void modificarCliNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
            IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.equal("ID", id));
            Objects<Modelo.CSocios> obj2 = odbf.getObjects(consult);
            Modelo.CSocios cli = (Modelo.CSocios) obj2.getFirst();

            if (Columna.equals("NOMBRE")) {

                cli.setNombre(valor);
                odbf.store(cli);

            }
            if (Columna.equals("DIRECCION")) {
                cli.setDireccion(valor);
                odbf.store(cli);
            }

            if (Columna.equals("TELEFONO")) {
                cli.setTelefono(valor);
                odbf.store(cli);
            }

            if (Columna.equals("STATUS")) {
                cli.setStatus(valor);
                odbf.store(cli);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }

    }

    //Metodos para Productos//
    public DefaultListModel getPeliculasNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");

        Objects<Modelo.CPeliculas> objects = odb.getObjects(Modelo.CPeliculas.class);

        while (objects.hasNext()) {
            Modelo.CPeliculas pro = objects.next();
            dlm.addElement(pro);
        }
        odb.close();

        return dlm;
    }

    public void eliminar_PeliNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery query = new CriteriaQuery(Modelo.CPeliculas.class, Where.equal("ID", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            odbe.deleteCascade(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("La Película no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("La Película no existe.");
        } finally {
            odbe.close();
        }

    }

    public void modificarPeliNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {

            IQuery consult = new CriteriaQuery(Modelo.CPeliculas.class, Where.equal("ID", id));
            Objects<Modelo.CPeliculas> obj2 = odbf.getObjects(consult);
            Modelo.CPeliculas pro = (Modelo.CPeliculas) obj2.getFirst();

            if (Columna.equals("Título")) {

                pro.setTitulo(valor);
                odbf.store(pro);

            }
            if (Columna.equals("NACIONALIDAD")) {
                pro.setNacionalidad(valor);
                odbf.store(pro);
            }
            if (Columna.equals("PRODUCTORA")) {
                pro.setProductora(valor);
                odbf.store(pro);
            }
            if (Columna.equals("FECHA")) {
                pro.setFecha(valor);
                odbf.store(pro);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }
    }

    //Metodos Rentas//
    public DefaultListModel getRentasNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consultotas = new CriteriaQuery(Modelo.CRentas.class, Where.equal("Status", "1"));
        Objects<Modelo.CRentas> objects = odb.getObjects(consultotas);
        while (objects.hasNext()) {
            Modelo.CRentas ven = objects.next();
            dlm.addElement(ven);
        }
        odb.close();

        return dlm;
    }

    public void modificarRentasNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {

            IQuery consult = new CriteriaQuery(Modelo.CRentas.class, Where.equal("ID_Renta", id));
            Objects<Modelo.CRentas> obj2 = odbf.getObjects(consult);
            Modelo.CRentas pro = (Modelo.CRentas) obj2.getFirst();

            /* if (Columna.equals("FECHA-RENTA")) {

                pro.setFecha_renta(valor);
                odbf.store(pro);
            }*/
            if (Columna.equals("FECHA-DEVOLUCION")) {
                pro.setFecha_devol(valor);
                odbf.store(pro);
            }
            /*if (Columna.equals("STATUS")) {
                pro.setStatus(valor);
                odbf.store(pro);
            }*/

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }
    }

    public void eliminar_RentasNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {

            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            IQuery query = new CriteriaQuery(Modelo.CRentas.class, Where.equal("ID_Renta", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            odbe.delete(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("La renta no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("La renta no existe.");
        } finally {
            odbe.close();
        }
    }

    public void terminar_renta(String peli, int ejem) {
        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery consultss = new CriteriaQuery(Modelo.CEjemplares.class, Where.and().add(Where.equal("ID", ejem)).add(Where.equal("Pelicula", peli)));
            Objects<Modelo.CEjemplares> obj2 = odbe.getObjects(consultss);
            Modelo.CEjemplares act = (Modelo.CEjemplares) obj2.getFirst();
            act.setStatus("1");
            odbe.store(act);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La renta no existe");
        } catch (ODBRuntimeException exc) {
            JOptionPane.showMessageDialog(null, "Error de Conexión");
        } finally {
            odbe.close();
        }
    }

    //Metodos para Directores//
    public DefaultListModel getDirectoresNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");

        Objects<Modelo.CDirectores> objects = odb.getObjects(Modelo.CDirectores.class);

        while (objects.hasNext()) {
            Modelo.CDirectores dr = objects.next();
            dlm.addElement(dr);
        }
        odb.close();

        return dlm;
    }

    public void eliminar_DirNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery query = new CriteriaQuery(Modelo.CDirectores.class, Where.equal("ID", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            odbe.delete(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El Director no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("El Director no existe.");
        } finally {
            odbe.close();
        }
    }

    public void modificarDirNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
            IQuery consultss = new CriteriaQuery(Modelo.CDirectores.class, Where.equal("ID", id));
            Objects<Modelo.CDirectores> obj2 = odbf.getObjects(consultss);
            Modelo.CDirectores dir = (Modelo.CDirectores) obj2.getFirst();

            if (Columna.equals("NOMBRE")) {

                dir.setNombre(valor);
                odbf.store(dir);

            }
            if (Columna.equals("NACIONALIDAD")) {
                dir.setNacionalidad(valor);
                odbf.store(dir);
            }
            if (Columna.equals("PELÍCULA")) {
                dir.setPelicula(valor);
                odbf.store(dir);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }

    }

    //Metodos para Actores//
    public DefaultListModel getActoresNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");

        Objects<Modelo.CActores> objects = odb.getObjects(Modelo.CActores.class);

        while (objects.hasNext()) {
            Modelo.CActores ac = objects.next();
            dlm.addElement(ac);
        }
        odb.close();

        return dlm;
    }

    public void eliminar_ActNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery query = new CriteriaQuery(Modelo.CActores.class, Where.equal("ID", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            odbe.delete(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El Actor no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("El Actor no existe.");
        } finally {
            odbe.close();
        }
    }

    public void modificarActNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
            IQuery consultss = new CriteriaQuery(Modelo.CActores.class, Where.equal("ID", id));
            Objects<Modelo.CActores> obj2 = odbf.getObjects(consultss);
            Modelo.CActores act = (Modelo.CActores) obj2.getFirst();

            if (Columna.equals("NOMBRE")) {

                act.setNombre(valor);
                odbf.store(act);

            }
            if (Columna.equals("NACIONALIDAD")) {
                act.setNacionalidad(valor);
                odbf.store(act);
            }
            if (Columna.equals("SEXO")) {
                act.setSexo(valor);
                odbf.store(act);
            }
            if (Columna.equals("PELICULA")) {
                act.setPelicula(valor);
                odbf.store(act);
            }
            if (Columna.equals("PRINCIPAL")) {
                act.setPelicula(valor);
                odbf.store(act);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }

    }

    //Metodos para ejemplares
    public DefaultListModel getEjemplaresNeo() {
        DefaultListModel dlm = new DefaultListModel();

        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consultotas = new CriteriaQuery(Modelo.CEjemplares.class, Where.equal("Status", "1"));
        Objects<Modelo.CEjemplares> objects = odb.getObjects(consultotas);

        while (objects.hasNext()) {
            Modelo.CEjemplares cli = objects.next();
            dlm.addElement(cli);
        }
        odb.close();

        return dlm;
    }

    public void eliminar_EjemNeo(int id) {

        ODB odbe = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            IQuery query = new CriteriaQuery(Modelo.CEjemplares.class, Where.equal("ID", id));
            Object obj1 = odbe.getObjects(query).getFirst();
            //OID oid1=odbe.getObjectId(obj1);
            //odbe.deleteObjectWithId(oid1);
            odbe.delete(obj1);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El Ejemplar no existe.");
        } catch (ODBRuntimeException exc) {
            System.out.println("El Ejemplar no existe.");
        } finally {
            odbe.close();
        }
    }

    public void modificarEjemNeo(int id, String valor, String Columna) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
            IQuery consultss = new CriteriaQuery(Modelo.CEjemplares.class, Where.equal("ID", id));
            Objects<Modelo.CEjemplares> obj2 = odbf.getObjects(consultss);
            Modelo.CEjemplares act = (Modelo.CEjemplares) obj2.getFirst();

            if (Columna.equals("PELICULA")) {
                act.setPelicula(valor);
                odbf.store(act);
            }
            if (Columna.equals("CONSERVACIÓN")) {
                act.setConservacion(valor);
                odbf.store(act);
            }
            if (Columna.equals("STATUS")) {
                act.setStatus(valor);
                odbf.store(act);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        } finally {
            odbf.close();
        }

    }

    public void modificarSTEjemNeo(int id, String valor) {
        ODB odbf = ODBFactory.open("DATOS_PELICULAS.DB");
        try {
            //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
            IQuery consultss = new CriteriaQuery(Modelo.CEjemplares.class, Where.equal("ID", id));
            Objects<Modelo.CEjemplares> obj2 = odbf.getObjects(consultss);
            Modelo.CEjemplares act = (Modelo.CEjemplares) obj2.getFirst();

            act.setStatus(valor);
            odbf.store(act);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        } catch (ODBRuntimeException exc) {
            System.out.println(exc.toString());
        }

    }
}

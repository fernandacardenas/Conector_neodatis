/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import javax.management.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.layers.layer2.meta.serialization.ObjectContainer;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Omar Olmedo
 */
public class Alta_Rentas extends javax.swing.JDialog {

    DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombo3 = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombo4 = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombo5 = new DefaultComboBoxModel();
    DefaultTableModel datoscli;
    private DefaultTableModel dtm;
    Controlador.COperaciones op = new Controlador.COperaciones();

    /**
     * Creates new form Alta_Ventas
     */
    public Alta_Rentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        op = new Controlador.COperaciones();
        comboejemplar();
        comboIDSocio();
    }

    void limpiar() {

        txt_IDrenta.setText("");
        txtst.setText("");
        //txt_st_ejemplar.setText("");
        //cbxsocio.setModel(new DefaultComboBoxModel());
        modeloCombo5 = new DefaultComboBoxModel();
        modeloCombo3 = new DefaultComboBoxModel();
        /* modeloCombo5.addElement("Seleccione");
        cbxsocio.setModel(modeloCombo5);*/

    }

    void comboejemplar() {

        modeloCombo2.addElement("Seleccione");
        cbxpelinom.setModel(modeloCombo2);

        try {
            //cn=cc.GetConnection();
            ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");

            Objects<Modelo.CPeliculas> objects = odb.getObjects(Modelo.CPeliculas.class);

            while (objects.hasNext()) {
                Modelo.CPeliculas pro = objects.next();
                cbxpelinom.addItem(pro.getTitulo());

            }
            odb.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void comboIDEjem() {

        modeloCombo3.addElement("Seleccione");
        cbxejemplar.setModel(modeloCombo3);
        //String peli = cbxpelinom.getSelectedItem().toString();
        // String pelicula = cbxpelinom.getItemAt(WIDTH).toString();
        try {
            //cn=cc.GetConnection();
            ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
            //IQuery consultotas = new CriteriaQuery(Modelo.CEjemplares.class, Where.equal("Pelicula", this.cbxpelinom.getSelectedItem().toString()));
            IQuery consultotas = new CriteriaQuery(Modelo.CEjemplares.class, Where.and().add(Where.equal("Pelicula", this.cbxpelinom.getSelectedItem().toString())).add(Where.equal("Status", "1")));
            Objects<Modelo.CEjemplares> objects = odb.getObjects(consultotas);

            while (objects.hasNext()) {
                Modelo.CEjemplares pro = objects.next();
                String cade = String.valueOf(pro.getID());
                cbxejemplar.addItem(cade);

            }
            odb.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void comboIDSocio() {

        modeloCombo4.addElement("Seleccione");
        cbxidsocio.setModel(modeloCombo4);

        try {
            //cn=cc.GetConnection();
            ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
            IQuery consultotas = new CriteriaQuery(Modelo.CSocios.class, Where.equal("Status", "1"));
            Objects<Modelo.CSocios> objects = odb.getObjects(consultotas);

            while (objects.hasNext()) {
                Modelo.CSocios pro = objects.next();
                String cade = String.valueOf(pro.getID());
                cbxidsocio.addItem(cade);

            }
            odb.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void combosocio() {

        modeloCombo5.addElement("Seleccione");
        cbxsocio.setModel(modeloCombo5);
        //String peli = cbxpelinom.getSelectedItem().toString();
        // String pelicula = cbxpelinom.getItemAt(WIDTH).toString();
        try {
            //cn=cc.GetConnection();
            ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
            String id = this.cbxidsocio.getSelectedItem().toString();
            IQuery consultotas = new CriteriaQuery(Modelo.CSocios.class, Where.equal("ID", Integer.parseInt(id)));
            Objects<Modelo.CSocios> objects = odb.getObjects(consultotas);

            while (objects.hasNext()) {
                Modelo.CSocios pro = objects.next();
                // String cade = String.valueOf(pro.getID);
                cbxsocio.addItem(pro.getNombre());

            }
            odb.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void checkdisponibilidad() {
        /* ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        IQuery consultotas = new CriteriaQuery(Modelo.CRentas.class, Where.and().add(Where.equal("Status", "1")).add(Where.equal("ID_Socio", Integer.parseInt(idsocio))));
        Objects<Modelo.CRentas> objects = odb.getObjects(consultotas);
        if (objects.size() >= 4) {
            JOptionPane.showMessageDialog(null, "Límite de rentas alcanzado");
        }
        odb.close();*/
        // return dlm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_IDrenta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdtfecha2 = new com.toedter.calendar.JDateChooser();
        jdtfecha = new com.toedter.calendar.JDateChooser();
        cbxsocio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxidsocio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxejemplar = new javax.swing.JComboBox<>();
        cbxpelinom = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtst = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Renta");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Socio");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No_Ejemplar");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de Renta");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de Devolución");

        cbxsocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxsocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxsocioItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Película");

        cbxidsocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxidsocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxidsocioItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Socio");

        cbxejemplar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxpelinom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxpelinom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxpelinomItemStateChanged(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/shopping-add.png"))); // NOI18N
        jButton3.setText("Guardar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxsocio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxidsocio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_IDrenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxejemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbxpelinom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtst, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdtfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_IDrenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxidsocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxsocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxpelinom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbxejemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdtfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxsocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxsocioItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxsocioItemStateChanged

    private void cbxpelinomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxpelinomItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (this.cbxpelinom.getSelectedIndex() > 0) {

                comboIDEjem();
            }
        }
    }//GEN-LAST:event_cbxpelinomItemStateChanged

    private void cbxidsocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxidsocioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (this.cbxidsocio.getSelectedIndex() > 0) {

                combosocio();
            }
        }
    }//GEN-LAST:event_cbxidsocioItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id = txt_IDrenta.getText();
        String idsocio = cbxidsocio.getSelectedItem().toString();
        String socio = cbxsocio.getSelectedItem().toString();
        String ejemplar = cbxpelinom.getSelectedItem().toString();
        String idejemp = cbxejemplar.getSelectedItem().toString();
        String dia = Integer.toString(jdtfecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jdtfecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(jdtfecha.getCalendar().get(Calendar.YEAR));
        String Fecha1 = (dia + "/" + mes + "/" + year);
        String dia2 = Integer.toString(jdtfecha2.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes2 = Integer.toString(jdtfecha2.getCalendar().get(Calendar.MONTH) + 1);
        String year2 = Integer.toString(jdtfecha2.getCalendar().get(Calendar.YEAR));
        String Fecha2 = (dia2 + "/" + mes2 + "/" + year2);
        String status = txtst.getText();

        // String aval = txt_aval.getText();
        //Insertar
        ODB odb = ODBFactory.open("DATOS_PELICULAS.DB");
        if (id != null) {
            IQuery consultotas = new CriteriaQuery(Modelo.CRentas.class, Where.and().add(Where.equal("Status", "1")).add(Where.equal("ID_Socio", Integer.parseInt(idsocio))));
            Objects<Modelo.CRentas> objects = odb.getObjects(consultotas);
            if (objects.size() >= 4) {
                JOptionPane.showMessageDialog(null, "Límite de rentas alcanzado");
                odb.close();
            } else {
                Modelo.CRentas cl = new Modelo.CRentas(Integer.parseInt(id), Integer.parseInt(idsocio), socio, ejemplar, Integer.parseInt(idejemp), Fecha1, Fecha2, status);
                odb.store(cl);
                //op.modificarSTEjemNeo(Integer.parseInt(idejemp), "0");
                try {
                    //  IQuery consult = new CriteriaQuery(Modelo.CSocios.class, Where.and().add(Where.equal("ID", id)).add(Where.equal("STATUS", "Activo")));
                    IQuery consultss = new CriteriaQuery(Modelo.CEjemplares.class, Where.and().add(Where.equal("ID", Integer.parseInt(idejemp))).add(Where.equal("Pelicula", ejemplar)));
                    Objects<Modelo.CEjemplares> obj2 = odb.getObjects(consultss);
                    Modelo.CEjemplares act = (Modelo.CEjemplares) obj2.getFirst();

                    act.setStatus("0");
                    odb.store(act);

                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.toString());
                } catch (ODBRuntimeException exc) {
                    System.out.println(exc.toString());
                }
                //final
                odb.close();
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Necesita un ID de Renta");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alta_Rentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Rentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Rentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Rentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Alta_Rentas dialog = new Alta_Rentas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxejemplar;
    private javax.swing.JComboBox<String> cbxidsocio;
    private javax.swing.JComboBox<String> cbxpelinom;
    private javax.swing.JComboBox<String> cbxsocio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdtfecha;
    private com.toedter.calendar.JDateChooser jdtfecha2;
    private javax.swing.JTextField txt_IDrenta;
    private javax.swing.JTextField txtst;
    // End of variables declaration//GEN-END:variables
}

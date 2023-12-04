/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_Pasajeros;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Cristian Aguiluz
 */
public class Registro_Pasajeros extends javax.swing.JFrame {

    /**
     * Creates new form Registro_Pasajeros
     */
    public Registro_Pasajeros() {
        initComponents();
        setLocationRelativeTo(null);  
        model =  (DefaultTableModel) Tabla_Datos.getModel();
    }
    
    
    //variables importantes
    String url = "jdbc:sqlite:C:/Users/Rachel/Documents/TriCARdb.db";
    Connection conectar;
    DefaultTableModel model;
    
    //metodos de conexion
     void connect(){
         try{
            
          conectar =DriverManager.getConnection(url);
          if(conectar!=null){
          //JOptionPane.showMessageDialog(this, "Conectado correctamente");    
           }    
        
        }catch(Exception x){
          JOptionPane.showMessageDialog(this, "Error"+x.getMessage().toString());
        }
     
     }
    
    //Metodos jcombobox 
     
     void rutase(){
        try{
          
          connect();  
            //select * from Rutas
          this.NumRuta.removeAllItems();
           PreparedStatement st = conectar.prepareStatement("select * from Rutas");
           ResultSet result = st.executeQuery();
                  
          while(result.next()){
              this.NumRuta.addItem(result.getString("No_Rutas"));
          }         
          
          conectar.close();
        }catch(Exception x){
          JOptionPane.showMessageDialog(this, "Error"+x.getMessage().toString());
        }
         
     
     }
     void numAsi(){
      
          try{
          
           this.cbNum_Asiento.removeAllItems();
          connect();  
          
          //Solo así me funciono, no lo toque
           String sql = "SELECT\n" +
                        "        * \n" +
                        "    FROM\n" +
                        "        Pasajeros a \n" +
                        "    INNER JOIN\n" +
                        "        Rutas b \n" +
                        "            ON a.Num_Ruta = b.No_Rutas \n" +
                        "    INNER JOIN\n" +
                        "        buses c \n" +
                        "            ON c.Num_bus = b.No_Bus \n" +
                        "    WHERE\n" +
"                         a.Num_ruta = '"+NumRuta.getSelectedItem()+"'";
           
           this.NumRuta.removeAllItems();
           PreparedStatement st = conectar.prepareStatement(sql);
           ResultSet result = st.executeQuery();
              
         
                  
          //capacidad del bus
          int num_asiento = result.getInt("num_asien"); 
          int asientos[] =new int[num_asiento];
          
          while(result.next()){
              asientos[result.getInt("Num_Asiento")] = result.getInt("Num_Asiento");
          }          
          
         for(int x=0; x<num_asiento; x++){
             if(asientos[x] == 0){
                this.cbNum_Asiento.addItem(String.valueOf(x));
             }
         
         }
          
         rutase(); 
         
         conectar.close();
          
        }catch(Exception x){
          JOptionPane.showMessageDialog(this, "Error"+x.getMessage().toString());
        }
         
     
     }
    

    //Metodo tabla
     
     void tabla(){
        try{
        model.setRowCount(0);
            
        String datos[] = new String[8];
        connect();   
        PreparedStatement st = conectar.prepareStatement("select * from Pasajeros");
        ResultSet result = st.executeQuery();
        
        while(result.next()){
                datos[0] = result.getString("ID_cliente");
                datos[1] = result.getString("Nombre_cliente");
                datos[2] = result.getString("Edad_cliente");
                datos[3] = result.getString("Genero_cliente");
                datos[4] = result.getString("Num_ruta");
                datos[5] = result.getString("Num_Asiento");
                datos[6] = result.getString("Condicion_Cliente");
                datos[7] = result.getString("Equipaje");
                model.addRow(datos);
        } 
        
        conectar.close();
        
        }catch(Exception x){
          JOptionPane.showMessageDialog(this, "Error"+x.getMessage().toString());
        }
        
     }
     
    //metodo boleto
     
    void boletoGen(){
        boleto bl = new boleto();
        bl.setVisible(true);
        
        bl.jLabel3Boleto.setText("Nombre: "+this.txtNombre.getText());
        bl.jLabel4.setText("No ruta: "+this.NumRuta.getSelectedItem().toString());
        bl.jLabel5.setText("Edad: "+this.txtEdad.getText());
        bl.jLabel6.setText("Genero: "+this.ComboBxGen.getSelectedItem().toString());
        bl.jLabel7.setText(this.cbNum_Asiento.getSelectedItem().toString());    
    
    } 
    
    //Otros metodos
    int pos=0;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txtEdad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbNum_Asiento = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Datos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ComboBxGen = new javax.swing.JComboBox<>();
        txtCondi = new javax.swing.JTextField();
        CheckBoxEqui = new javax.swing.JCheckBox();
        NumRuta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel4.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, -1));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edad");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("REGISTRO DE PASAJEROS");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 200, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Num de Asiento");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        cbNum_Asiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jPanel4.add(cbNum_Asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 160, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 250, 30));

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 250, 30));

        Tabla_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Edad", "Género", "Num Ruta ", "Num Asiento ", "Condición", "Equipaje"
            }
        ));
        Tabla_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_DatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Datos);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 720, 430));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Género");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Num Ruta");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Condición Médica");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Equipaje");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        ComboBxGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Femenino", "Masculino", "Otro" }));
        jPanel4.add(ComboBxGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 200, -1));
        jPanel4.add(txtCondi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 200, -1));

        CheckBoxEqui.setText("Equipaje");
        jPanel4.add(CheckBoxEqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        NumRuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NumRutaFocusLost(evt);
            }
        });
        NumRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NumRutaMouseClicked(evt);
            }
        });
        NumRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumRutaActionPerformed(evt);
            }
        });
        jPanel4.add(NumRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 90, -1));

        jButton1.setText("Disponibilidad");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 120, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_tricar/ICONOS/Recurso 4.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    void limpiar(){
    
            
      txtNombre.setText(""); 
      txtCondi.setText("");   
      txtEdad.setText(""); 
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        try{
            connect();
            
            String nombre = txtNombre.getText(),
                   genero = ComboBxGen.getSelectedItem().toString(),
                   condicion = txtCondi.getText()   
                  ;
                
            Boolean equi = CheckBoxEqui.isSelected();
            
            int num_ruta = Integer.valueOf(NumRuta.getSelectedItem().toString()),
                edad = Integer.valueOf(txtEdad.getText()),
                num_asientos = Integer.valueOf(cbNum_Asiento.getSelectedItem().toString())
                  
                ;
            
                    
           String sql = "INSERT INTO\n" +
                        "  Pasajeros (\n" +
                        "    Nombre_cliente,\n" +
                        "    Edad_cliente,\n" +
                        "    Genero_Cliente,\n" +
                        "    Num_ruta,\n" +
                        "    Num_Asiento,\n" +
                        "    Condicion_Cliente,\n" +
                        "    Equipaje\n" +
                        "  )\n" +
                        "VALUES\n" +
                        "  (\n" +
                        "    '"+nombre+"',\n" +
                        "    '"+edad+"',\n" +
                        "    '"+genero+"',\n" +
                        "    '"+num_ruta+"',\n" +
                        "    '"+num_asientos+"',\n" +
                        "    '"+condicion+"',\n" +
                        "    '"+equi+"'\n" +
                        "  )";
            
           PreparedStatement st = conectar.prepareStatement(sql);
           st.executeUpdate();
           
           JOptionPane.showMessageDialog(this, "Dato guardado");
           
           boletoGen();
           tabla();
           limpiar();
           
        }catch(Exception x){
          JOptionPane.showMessageDialog(this, "Error"+x.getMessage().toString());
        }
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        rutase();
        tabla();

    }//GEN-LAST:event_formWindowOpened

    private void NumRutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NumRutaFocusLost
       
    }//GEN-LAST:event_NumRutaFocusLost

    private void NumRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NumRutaMouseClicked

    }//GEN-LAST:event_NumRutaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void Tabla_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_DatosMouseClicked
//
    }//GEN-LAST:event_Tabla_DatosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          numAsi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NumRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumRutaActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_Pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Pasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Pasajeros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxEqui;
    private javax.swing.JComboBox<String> ComboBxGen;
    private javax.swing.JComboBox<String> NumRuta;
    private javax.swing.JTable Tabla_Datos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbNum_Asiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCondi;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro_empleado;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
/**
 *
 * @author Rachel
 */

public class Registro_EMP extends javax.swing.JFrame {

    /**
     * Creates new form Registro_EMP
     */
    public Registro_EMP() {
        initComponents();
        setLocationRelativeTo(null);
        emple=(DefaultTableModel) jTable1.getModel(); 
    }
     ArrayList<Empleados> arr= new ArrayList(); 
    DefaultTableModel emple; 
    String url="jdbc:sqlite:C:/Users/Rachel/Documents/TriCARdb.db"; 
    Connection conectar; 
    int posi=0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNomb = new javax.swing.JTextField();
        comboEmp = new javax.swing.JComboBox<>();
        btn_agre = new javax.swing.JButton();
        btn_cerr = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        ComBoxGen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Identidad", "Nombre", "Edad", "Género", "Empleado"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 590, 340));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo Empleado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 50));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Empleado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, -1));
        jPanel1.add(txtNomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 180, -1));

        comboEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Empleado", "Conductor", "Asistente de viaje" }));
        jPanel1.add(comboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, -1));

        btn_agre.setText("Agregar");
        btn_agre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agreActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 290, -1));

        btn_cerr.setText("Cerrar");
        btn_cerr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cerr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 290, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Género");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 180, -1));

        ComBoxGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Género", "Femenino", "Masculino", "Otro" }));
        jPanel1.add(ComBoxGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_tricar/ICONOS/Recurso 4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agreActionPerformed
        try{
       conectar =DriverManager.getConnection(url); 
       if(conectar!=null){
       String agg="insert into Empleados (Identidad_emple, Nombre_Emple, Edad_Empleado, Género_Emple, Tipo_Emple)" + "values "
+ "('"+this.txtId.getText()+"','"+this.txtNomb.getText()+"',"+this.txtEdad.getText()+",'"+this.ComBoxGen.getSelectedItem().toString()+"',"
               + "'"+this.comboEmp.getSelectedItem().toString()+"')";
       
       PreparedStatement bd= conectar.prepareStatement(agg);
       bd.execute();
       JOptionPane.showMessageDialog(this, "Registro realizado correctamente");
       
       ResultSet result=null; 
       bd= conectar.prepareStatement("select  ID_Empleado, Identidad_emple, Nombre_Emple, Edad_Empleado, "
                                                       + "Género_Emple, Tipo_Emple from Empleados");
       result=bd.executeQuery();
       
       while(result.next()){
       emple.addRow(new Object []{result.getInt("ID_Empleado"),result.getInt("Identidad_emple"),result.getString("Nombre_Emple"),
                                 result.getInt("Edad_Empleado"),result.getString("Género_Emple"),result.getString("Tipo_Emple")});
       } 
       conectar.close();
       }
       }catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());
       }
    }//GEN-LAST:event_btn_agreActionPerformed

    private void btn_cerrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrActionPerformed
          System.exit(0);
    }//GEN-LAST:event_btn_cerrActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         DefaultTableModel model=(DefaultTableModel)this .jTable1.getModel();
int i=jTable1.getSelectedRow();

if(i>7000){
    
}else{
   txtId.setText(String.valueOf(jTable1.getValueAt(i, 1)));
   txtNomb.setText(String.valueOf(jTable1.getValueAt(i, 2)));
   txtEdad.setText(String.valueOf(jTable1.getValueAt(i, 3)));
   ComBoxGen.setSelectedItem(String.valueOf(jTable1.getValueAt(i, 4)));
   comboEmp.setSelectedItem(String.valueOf(jTable1.getValueAt(i, 5)));
   
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
       conectar =DriverManager.getConnection(url); 
       if(conectar!=null){
       
       emple.setRowCount(0); 
       
      ResultSet result=null; 
       PreparedStatement bd= conectar.prepareStatement("select  ID_Empleado, Identidad_emple, Nombre_Emple, Edad_Empleado, "
                                                       + "Género_Emple, Tipo_Emple from Empleados");
       result=bd.executeQuery();
       
       while(result.next()){
       emple.addRow(new Object []{result.getInt("ID_Empleado"),result.getInt("Identidad_emple"),result.getString("Nombre_Emple"),
                                 result.getInt("Edad_Empleado"),result.getString("Género_Emple"),result.getString("Tipo_Emple")});
       } 
       conectar.close();
       }
       }catch(Exception x){
       JOptionPane.showMessageDialog(null, x.getMessage().toString());
       }
    }//GEN-LAST:event_jButton1ActionPerformed
  
      void limpiar(){

    this.txtEdad.setText("");
    this.txtId.setText("");
    this.txtNomb.setText("");
   
    }
      
    
       
       
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
            java.util.logging.Logger.getLogger(Registro_EMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_EMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_EMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_EMP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_EMP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComBoxGen;
    private javax.swing.JButton btn_agre;
    private javax.swing.JButton btn_cerr;
    private javax.swing.JComboBox<String> comboEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomb;
    // End of variables declaration//GEN-END:variables
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.PreparedStatement; // Importa PreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author PC
 */
public class A_RPR_ELIMINAR extends javax.swing.JDialog {

    Conexion con = new Conexion();
    Connection cn = con.conectar();

    /**
     * Creates new form A_RD_ELIMINAR
     */
    public A_RPR_ELIMINAR(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        mostrarDatos();
        configurarTabla();
        añadirListenerTabla();
    }

    private void configurarTabla() {
        JTableHeader header = tblPersonal.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setOpaque(false);
        header.setBackground(new Color(16, 62, 131));
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(16, 62, 131));
        headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblPersonal.getColumnModel().getColumnCount(); i++) {
            tblPersonal.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Aumentar el alto de las filas
        tblPersonal.setRowHeight(30);
    }

    private void añadirListenerTabla() {
        tblPersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int column = tblPersonal.columnAtPoint(evt.getPoint());
                int row = evt.getY() / tblPersonal.getRowHeight();

                if (row < tblPersonal.getRowCount() && row >= 0 && column < tblPersonal.getColumnCount() && column >= 0) {
                    if (column == 14) { // Suponiendo que la columna 14 es la de Historial Profesional
                        String pdfPath = (String) tblPersonal.getValueAt(row, column);
                        if (pdfPath != null && !pdfPath.isEmpty()) {
                            try {
                                File pdfFile = new File(pdfPath);
                                if (pdfFile.exists()) {
                                    Desktop.getDesktop().open(pdfFile);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El archivo PDF no existe.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al abrir el PDF: " + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        });
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBNombre = new javax.swing.JTextField();
        txtBDNI = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ELIMINAR PERSONAL");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clinica-san-juan-de-dios-logo (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(124, 124, 124)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(16, 62, 131));
        jLabel3.setText("CÓDIGO PERSONAL");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(16, 62, 131));
        jLabel4.setText("DNI");

        txtBNombre.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtBNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBNombreKeyReleased(evt);
            }
        });

        txtBDNI.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtBDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBDNIKeyReleased(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(153, 38));
        btnEliminar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEliminarMouseMoved(evt);
            }
        });
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ELIMINAR");

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEliminarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel16)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPersonal.setFocusable(false);
        tblPersonal.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblPersonal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPersonal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel3)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 317, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBNombreKeyReleased
        String texto = txtBNombre.getText();
        DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblPersonal.setRowSorter(sorter);

        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1)); // Filtra por la columna "Codigo" (índice 1)
        }
    }//GEN-LAST:event_txtBNombreKeyReleased

    private void txtBDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBDNIKeyReleased
        String texto = txtBDNI.getText();
        DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblPersonal.setRowSorter(sorter);

        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 5)); // Filtra por la columna "DNI/PASAPORTE" (índice 4)
        }
    }//GEN-LAST:event_txtBDNIKeyReleased

    private void btnEliminarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseMoved
        btnEliminar.setBackground(new Color(153, 0, 0));
    }//GEN-LAST:event_btnEliminarMouseMoved

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // Verificar si hay una fila seleccionada
        int selectedRowView = tblPersonal.getSelectedRow();
        if (selectedRowView == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir índice de vista a índice de modelo
        int selectedRowModel = tblPersonal.convertRowIndexToModel(selectedRowView);

        // Obtener los datos del doctor de la fila seleccionada
        DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
        String idPersonal = (String) modelo.getValueAt(selectedRowModel, 0);
        String codigo = (String) modelo.getValueAt(selectedRowModel, 1);
        String nombres = (String) modelo.getValueAt(selectedRowModel, 2);
        String apellidoPaterno = (String) modelo.getValueAt(selectedRowModel, 3);
        String apellidoMaterno = (String) modelo.getValueAt(selectedRowModel, 4);
        String dni = (String) modelo.getValueAt(selectedRowModel, 5);
        String genero = (String) modelo.getValueAt(selectedRowModel, 6);
        String correoElectronico = (String) modelo.getValueAt(selectedRowModel, 7);
        String telefono = (String) modelo.getValueAt(selectedRowModel, 8);
        String fechaNacimiento = (String) modelo.getValueAt(selectedRowModel, 9);
        String ocupacion = (String) modelo.getValueAt(selectedRowModel, 10);
        String distrito = (String) modelo.getValueAt(selectedRowModel, 11);
        String direccion = (String) modelo.getValueAt(selectedRowModel, 12);
        String nacionalidad = (String) modelo.getValueAt(selectedRowModel, 13);
        String fechaInicio = (String) modelo.getValueAt(selectedRowModel, 14);

        // Crear el mensaje de confirmación con los detalles del doctor
        String mensaje = "¿Estás seguro de que deseas eliminar el siguiente personal?\n\n"
                + "ID Personal: " + idPersonal + "\n"
                + "Codigo Personal: " + codigo + "\n"
                + "Nombres: " + nombres + "\n"
                + "Apellido Paterno: " + apellidoPaterno + "\n"
                + "Apellido Materno: " + apellidoMaterno + "\n"
                + "DNI/Pasaporte: " + dni + "\n"
                + "Género: " + genero + "\n"
                + "Correo Electrónico: " + correoElectronico + "\n"
                + "Teléfono: " + telefono + "\n"
                + "Fecha Nacimiento: " + fechaNacimiento + "\n"
                + "Ocupación: " + ocupacion + "\n"
                + "Distrito: " + distrito + "\n"
                + "Dirección: " + direccion + "\n"
                + "Nacionalidad: " + nacionalidad + "\n"
                + "Fecha Inicio: " + fechaInicio + "\n";

        // Mostrar cuadro de diálogo de confirmación con los detalles del doctor
        int confirm = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Eliminar el registro de la base de datos
                String deleteSQL = "DELETE FROM registro_personal WHERE id = ?";
                PreparedStatement pst = cn.prepareStatement(deleteSQL);
                pst.setString(1, idPersonal);
                pst.executeUpdate();

                // Eliminar la fila seleccionada del modelo de la tabla
                modelo.removeRow(selectedRowModel);
                JOptionPane.showMessageDialog(this, "Doctor eliminado correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(204, 0, 0));
    }//GEN-LAST:event_btnEliminarMouseExited

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
            java.util.logging.Logger.getLogger(A_RPR_ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A_RPR_ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A_RPR_ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A_RPR_ELIMINAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                A_RPR_ELIMINAR dialog = new A_RPR_ELIMINAR(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtBDNI;
    private javax.swing.JTextField txtBNombre;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        // Columnas existentes
        modelo.addColumn("ID Personal");
        modelo.addColumn("Codigo Personal");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("DNI/PASAPORTE");
        modelo.addColumn("Genero");
        modelo.addColumn("Correo Electronico");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Ocupacion");
        modelo.addColumn("Distrito");
        modelo.addColumn("Direccion");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Fecha Inicio");

        tblPersonal.setModel(modelo);
        String consultasql = "select * from registro_personal";
        String[] data = new String[modelo.getColumnCount()]; // Tamaño del arreglo una columna menos

        int rowCount = 0; // Contador de filas

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consultasql);
            while (rs.next()) {
                for (int i = 0; i < modelo.getColumnCount(); i++) { // Recorrer una columna menos
                    data[i] = rs.getString(i + 1); // Acceder a las columnas por índice (1-based)
                }
                modelo.addRow(data);
                rowCount++;
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar Datos " + e);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.JTable;
import org.apache.commons.io.FileUtils;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author jr860
 */
public class A_RPV extends javax.swing.JInternalFrame {
    
    Conexion con = new Conexion();
    Connection cn = con.conectar();
    /**
     * Creates new form A_RPV
     */
    public A_RPV() {
        initComponents();

        mostrarDatos();
        configurarTabla();
        añadirListenerTabla();

        // Llamar para inicializar el contador
        actualizarContador();
    }
    
    private void actualizarContador() {
        int rowCount = tblProveedor.getRowCount();
        labelContador.setText(""+ rowCount);
    }

    private void configurarTabla() {
        JTableHeader header = tblProveedor.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setOpaque(false);
        header.setBackground(new Color(16, 62, 131));
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(16, 62, 131));
        headerRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < tblProveedor.getColumnModel().getColumnCount(); i++) {
            tblProveedor.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Aumentar el alto de las filas
        tblProveedor.setRowHeight(30);

    }

    private void añadirListenerTabla() {
        tblProveedor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int column = tblProveedor.columnAtPoint(evt.getPoint());
                int row = evt.getY() / tblProveedor.getRowHeight();

                if (row < tblProveedor.getRowCount() && row >= 0 && column < tblProveedor.getColumnCount() && column >= 0) {
                    if (column == 15) { // Suponiendo que la columna 14 es la de Historial Profesional
                        String pdfPath = (String) tblProveedor.getValueAt(row, column);
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
        btnActualizar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnPDF = new javax.swing.JLabel();
        btnEXCEL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAñadir = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtFiltrarPorCodigoProv = new javax.swing.JTextField();
        txtFiltrarPorEmpresa = new javax.swing.JTextField();
        btnActualizarTabla = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelContador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null), "CRUD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sincronizar.png"))); // NOI18N
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 24, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/borrar.png"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 24, -1, -1));

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 24, -1, -1));

        btnEXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sobresalir.png"))); // NOI18N
        btnEXCEL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnEXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 24, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 8, 80));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setText("EXCEL");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel7.setText("AÑADIR");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setText("ELIMINAR");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel10.setText("PDF");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mas.png"))); // NOI18N
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirMouseClicked(evt);
            }
        });
        jPanel2.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel12.setText("ACTUALIZAR");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null), "MAS OPCIONES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtFiltrarPorCodigoProv.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtFiltrarPorCodigoProv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFiltrarPorCodigoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltrarPorCodigoProvActionPerformed(evt);
            }
        });
        txtFiltrarPorCodigoProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarPorCodigoProvKeyReleased(evt);
            }
        });

        txtFiltrarPorEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtFiltrarPorEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFiltrarPorEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltrarPorEmpresaActionPerformed(evt);
            }
        });
        txtFiltrarPorEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarPorEmpresaKeyReleased(evt);
            }
        });

        btnActualizarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar.png"))); // NOI18N
        btnActualizarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarTablaMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel9.setText("ACTUALIZAR TABLA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtFiltrarPorCodigoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFiltrarPorEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnActualizarTabla)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFiltrarPorCodigoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiltrarPorEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizarTabla, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedor.setFocusable(false);
        tblProveedor.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblProveedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProveedor);

        jPanel4.setBackground(new java.awt.Color(174, 96, 27));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        labelContador.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelContador.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PROVEEDORES REGISTRADOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelContador, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        A_RPV_ACTUALIZAR a;
        Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame) {
            a = new A_RPV_ACTUALIZAR((JFrame) window, true); // Assuming the second argument is a boolean for modality
            a.setVisible(true);
        } else {
            // Handle the case where the ancestor is not a JFrame
            System.err.println("Ancestor is not a JFrame");
        }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        A_RPV_ELIMINAR a;
        Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame) {
            a = new A_RPV_ELIMINAR((JFrame) window, true); // Assuming the second argument is a boolean for modality
            a.setVisible(true);
        } else {
            // Handle the case where the ancestor is not a JFrame
            System.err.println("Ancestor is not a JFrame");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMouseClicked
        A_RPV_AÑADIR a;
        Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame) {
            a = new A_RPV_AÑADIR((JFrame) window, true); // Assuming the second argument is a boolean for modality
            a.setVisible(true);
        } else {
            // Handle the case where the ancestor is not a JFrame
            System.err.println("Ancestor is not a JFrame");
        }
    }//GEN-LAST:event_btnAñadirMouseClicked

    private void txtFiltrarPorCodigoProvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarPorCodigoProvKeyReleased
        String texto = txtFiltrarPorCodigoProv.getText();
        DefaultTableModel modelo = (DefaultTableModel) tblProveedor.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblProveedor.setRowSorter(sorter);

        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1)); // Filtra por la columna "Codigo" (índice 1)
        }
    }//GEN-LAST:event_txtFiltrarPorCodigoProvKeyReleased

    private void txtFiltrarPorEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarPorEmpresaKeyReleased
        String texto = txtFiltrarPorEmpresa.getText();
        DefaultTableModel modelo = (DefaultTableModel) tblProveedor.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tblProveedor.setRowSorter(sorter);

        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 2)); // Filtra por la columna "Empresa" (índice 4)
        }
    }//GEN-LAST:event_txtFiltrarPorEmpresaKeyReleased

    private void btnActualizarTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarTablaMouseClicked
        mostrarDatos();
        configurarTabla();
        actualizarContador();
    }//GEN-LAST:event_btnActualizarTablaMouseClicked

    private void txtFiltrarPorCodigoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltrarPorCodigoProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltrarPorCodigoProvActionPerformed

    private void txtFiltrarPorEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltrarPorEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltrarPorEmpresaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnActualizarTabla;
    private javax.swing.JLabel btnAñadir;
    private javax.swing.JLabel btnEXCEL;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelContador;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtFiltrarPorCodigoProv;
    private javax.swing.JTextField txtFiltrarPorEmpresa;
    // End of variables declaration//GEN-END:variables
    
    private void mostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        // Columnas existentes
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Codigo Proveedor");
        modelo.addColumn("Empresa");
        modelo.addColumn("RUC");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");

        tblProveedor.setModel(modelo);
        String consultasql = "select * from registro_proveedor";
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

        // Actualizar el contador
        labelContador.setText("Total de Proveedores Registrados: " + rowCount);
    }
    
}

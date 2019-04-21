
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Conexion;
import model.Producto;
import model.ProductoDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msi
 */
public class Categorias extends javax.swing.JFrame {
    private Conexion con = new Conexion();
    private Connection cn = con.conectar();
    ArrayList<Categoria> catArray = new ArrayList<Categoria>();
    ArrayList<Producto> infoProducto = new ArrayList<Producto>();
    ProductoDAO pDAO = new ProductoDAO();
    Categoria cat = new Categoria();
    int id = 1;
     

    /**
     * Creates new form Categoria
     */
    public Categorias() {
        initComponents();
        this.setLocationRelativeTo(null); 
        cat.getAllCategoria(catArray, jCatNom);
        cargarTabla(id);
        
    }
//HACE LA TABLA
     public void cargarTabla(int i){
        DefaultTableModel dmodel=null;
        String cabecera[]={"id","Nombre","Precio","Descuento","Categoria"};
        pDAO.getInfoProductoCat(infoProducto, i);
        dmodel=new DefaultTableModel(null,cabecera);
        String campo[]=new String[5];
        for(Producto p:infoProducto){
            //campo[0]=p.getId_persona().toString();
            campo[0]=String.valueOf(p.getProducte_id());
            campo[1]=p.getProducte_nom();  
            campo[2]=String.valueOf(p.getProducte_preu());
            campo[3]=String.valueOf(p.getProducte_descompte());
           //JOptionPane.showMessageDialog(null,p.getProducte_id() );
            cat.nomCategoria(p.getProducte_id());
            String nomCat = cat.nomCategoria(p.getProducte_id()).getCategoria_nom();
           // JOptionPane.showMessageDialog(null,);
            campo[4]=String.valueOf(nomCat);

            dmodel.addRow(campo);
        }
        this.tablaProducto.setModel(dmodel);
        
       // return dmodel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jCatNom = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuVerUsuarios = new javax.swing.JMenuItem();
        jMenuCrearUsuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuVerProductos = new javax.swing.JMenuItem();
        jMenuVerCategorias = new javax.swing.JMenuItem();
        jMenuModificarCategoria = new javax.swing.JMenuItem();
        ofertasBtn = new javax.swing.JMenu();
        jMenuVerOfertas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        pedidosBtn = new javax.swing.JMenu();
        jMenuCrearPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("CATEGORIA:");

        jCatNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCatNomActionPerformed(evt);
            }
        });

        jMenu1.setText("Usuarios");

        jMenuVerUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuVerUsuarios.setText("Ver Todos");
        jMenuVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuVerUsuarios);

        jMenuCrearUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuCrearUsuarios.setText("Crear");
        jMenuCrearUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCrearUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCrearUsuarios);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");

        jMenuVerProductos.setText("Ver Todos");
        jMenuVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerProductosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuVerProductos);

        jMenuVerCategorias.setText("Buscar por Categoria");
        jMenuVerCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerCategoriasActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuVerCategorias);

        jMenuModificarCategoria.setText("Modificar Categoria");
        jMenuModificarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificarCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuModificarCategoria);

        jMenuBar1.add(jMenu2);

        ofertasBtn.setText("Ofertas");

        jMenuVerOfertas.setText("Ver Todas");
        jMenuVerOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerOfertasActionPerformed(evt);
            }
        });
        ofertasBtn.add(jMenuVerOfertas);

        jMenuItem1.setText("desde -50%");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        ofertasBtn.add(jMenuItem1);

        jMenuItem2.setText("desde -25%");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        ofertasBtn.add(jMenuItem2);

        jMenuItem3.setText("desde -1%");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        ofertasBtn.add(jMenuItem3);

        jMenuBar1.add(ofertasBtn);

        pedidosBtn.setText("Pedidos");

        jMenuCrearPedido.setText("Crear Pedido");
        jMenuCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCrearPedidoActionPerformed(evt);
            }
        });
        pedidosBtn.add(jMenuCrearPedido);

        jMenuBar1.add(pedidosBtn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCatNom, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jCatNom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CLICKS
    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked

        int i=tablaProducto.getSelectedRow()+1;
       
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void jCatNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCatNomActionPerformed
        // TODO add your handling code here:
        //hacer el desplegable de categoria
        int i= this.jCatNom.getSelectedIndex()+1;
       // JOptionPane.showMessageDialog(null, i);
        cargarTabla(i);

    }//GEN-LAST:event_jCatNomActionPerformed

    private void jMenuVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerUsuariosActionPerformed
        // TODO add your handling code here:
        openUsuarios();
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuVerUsuariosActionPerformed

    private void jMenuCrearUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCrearUsuariosActionPerformed
        // TODO add your handling code here:
        openCrearUsu();
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuCrearUsuariosActionPerformed

    private void jMenuVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerProductosActionPerformed
        // TODO add your handling code here:
        openHome();
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuVerProductosActionPerformed

    private void jMenuVerCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerCategoriasActionPerformed
        // TODO add your handling code here:
        openCategoria();
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMenuVerCategoriasActionPerformed

    private void jMenuModificarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificarCategoriaActionPerformed
        // TODO add your handling code here:
        //abrir un frame con categorias para elegir.
    }//GEN-LAST:event_jMenuModificarCategoriaActionPerformed

    private void jMenuVerOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerOfertasActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ops! parece que todavía no hay ofertas");
    }//GEN-LAST:event_jMenuVerOfertasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ops! parece que todavía no hay ofertas");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ops! parece que todavía no hay ofertas");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ops! parece que todavía no hay ofertas");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCrearPedidoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ops! parece que estamos en mantenimiento");
    }//GEN-LAST:event_jMenuCrearPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categorias().setVisible(true);
            }
        });
    }
 private void openUsuarios(){
        java.awt.EventQueue.invokeLater(() -> {
            new Usuarios().setVisible(true);
        });
    }
    private void openHome(){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home(null).setVisible(true);
            }
        });
    }
    private void openCategoria(){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categorias().setVisible(true);
            }
        });
    }
    private void openCrearUsu(){
        java.awt.EventQueue.invokeLater(() -> {
            new CrearUsu().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCatNom;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCrearPedido;
    private javax.swing.JMenuItem jMenuCrearUsuarios;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuModificarCategoria;
    private javax.swing.JMenuItem jMenuVerCategorias;
    private javax.swing.JMenuItem jMenuVerOfertas;
    private javax.swing.JMenuItem jMenuVerProductos;
    private javax.swing.JMenuItem jMenuVerUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu ofertasBtn;
    private javax.swing.JMenu pedidosBtn;
    private javax.swing.JTable tablaProducto;
    // End of variables declaration//GEN-END:variables
}
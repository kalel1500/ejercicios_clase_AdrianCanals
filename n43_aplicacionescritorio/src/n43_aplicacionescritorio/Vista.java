/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n43_aplicacionescritorio;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import model.PersonaDAO;

/**
 *
 * @author Usuario
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    PersonaDAO pdao = new PersonaDAO();

    String cabecera[] = {"id", "nombre", "apellido", "edad", "sexo", "departamento"};
    DefaultTableModel dmodel = new DefaultTableModel(null, cabecera);

    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    int i = 0;
    String accion;

    public void limpiarTabla() {
        for (int i = dmodel.getRowCount() - 1; i >= 0; i--) {
            dmodel.removeRow(i);
        }

    }

    public void actualizarTabla() {
        // vaciar model
        limpiarTabla();
        // cargar la tabla
        dmodel = cargarTabla();
        this.tabla.setModel(dmodel);
        // Actualizar mi array
        listaPersonas.clear();
        pdao.getListaPersonas(listaPersonas);
        // ir al ultimo objeto de la lista
        refrescar(listaPersonas.size() - 1);
        i = listaPersonas.size() - 1;
    }

    public DefaultTableModel cargarTabla() {
        // vacio la lista
        listaPersonas.clear();

        pdao.getListaPersonas(listaPersonas);
        String campo[] = new String[6]; // 6 es el numero de campos de la bd
        for (Persona p : listaPersonas) {
            campo[0] = String.valueOf(p.getId_persona()); //campo[0] = p.getId_persona().toString();
            campo[1] = p.getNombre_persona();
            campo[2] = p.getApellido_persona();
            campo[3] = String.valueOf(p.getEdad_persona()); //campo[0] = p.getId_persona().toString();
            campo[4] = p.getSexo_persona();
            campo[5] = String.valueOf(p.getId_departamento());
            dmodel.addRow(campo);
        }
        return dmodel;
    }

    public void vaciarCampos() {
        this.tf_nombre.setText("");
        this.tf_apellido.setText("");
        this.tf_edad.setText("");
        this.tf_id.setText("");
        this.tf_indice.setText("");

        this.tf_nombre.setEditable(true);
        this.tf_apellido.setEditable(true);
        this.tf_edad.setEditable(true);
    }

    public void refrescar(int i) {
        this.tf_id.setText(String.valueOf(listaPersonas.get(i).getId_persona()));
        this.tf_nombre.setText(listaPersonas.get(i).getNombre_persona());
        this.tf_apellido.setText(listaPersonas.get(i).getApellido_persona());
        this.tf_edad.setText(String.valueOf(listaPersonas.get(i).getEdad_persona()));
        this.tf_indice.setText(String.valueOf(i));

        i = 0;
    }

    public void activarPostUlt(boolean ac) {
        this.btn_posterior.setEnabled(ac);
        this.btn_ultimo.setEnabled(ac);
    }

    public void activarAntPrim(boolean ac) {
        this.btn_anterior.setEnabled(ac);
        this.btn_primero.setEnabled(ac);
    }

    public Vista() {
        initComponents();
        PersonaDAO pdao = new PersonaDAO();
        pdao.getListaPersonas(listaPersonas);
        refrescar(0);

        activarPostUlt(true);
        activarAntPrim(false);

        this.btn_guardar.setEnabled(false);

        this.error_nombre.setVisible(false);
        this.error_apellido.setVisible(false);
        this.error_edad.setVisible(false);

        DefaultTableModel dmodel = cargarTabla();
        this.tabla.setModel(dmodel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JpAnimal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_edad = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_recuperar = new javax.swing.JButton();
        btn_primero = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        btn_posterior = new javax.swing.JButton();
        btn_ultimo = new javax.swing.JButton();
        tf_indice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_insertar = new javax.swing.JButton();
        error_nombre = new javax.swing.JLabel();
        error_apellido = new javax.swing.JLabel();
        error_edad = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rb_hombre = new javax.swing.JRadioButton();
        rb_mujer = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        cb_departamento = new javax.swing.JComboBox<>();
        rb_otros = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JpAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar persona"));

        jLabel1.setText("nombre:");
        jLabel1.setToolTipText("Introduce el nombre");

        tf_nombre.setEditable(false);
        tf_nombre.setToolTipText("Debes de introducir un nombre");

        jLabel2.setText("apellido");

        tf_apellido.setEditable(false);

        jLabel3.setText("edad");

        tf_edad.setEditable(false);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel4.setText("id");

        tf_id.setEditable(false);
        tf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_modificar.setText("modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_recuperar.setText("Recuperar");
        btn_recuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recuperarActionPerformed(evt);
            }
        });

        btn_primero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/primer.png"))); // NOI18N
        btn_primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primeroActionPerformed(evt);
            }
        });

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/enrere.png"))); // NOI18N
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });

        btn_posterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/endavant.png"))); // NOI18N
        btn_posterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_posteriorActionPerformed(evt);
            }
        });

        btn_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ultim.png"))); // NOI18N
        btn_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoActionPerformed(evt);
            }
        });

        tf_indice.setEditable(false);

        jLabel5.setText("Indice:");

        btn_insertar.setText("Insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });

        error_nombre.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        error_nombre.setForeground(new java.awt.Color(255, 51, 51));
        error_nombre.setText("Debes de introducir un nombre");

        error_apellido.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        error_apellido.setForeground(new java.awt.Color(255, 0, 51));
        error_apellido.setText("Debes de introducir un apellido");

        error_edad.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        error_edad.setForeground(new java.awt.Color(255, 0, 51));
        error_edad.setText("Debes de introducir una edad correcta");
        error_edad.setToolTipText("");

        jLabel6.setText("sexo");

        buttonGroup1.add(rb_hombre);
        rb_hombre.setText("Hombre");

        buttonGroup1.add(rb_mujer);
        rb_mujer.setText("Mujer");
        rb_mujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_mujerActionPerformed(evt);
            }
        });

        jLabel7.setText("Departamento");

        cb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_otros);
        rb_otros.setText("Otros");

        javax.swing.GroupLayout JpAnimalLayout = new javax.swing.GroupLayout(JpAnimal);
        JpAnimal.setLayout(JpAnimalLayout);
        JpAnimalLayout.setHorizontalGroup(
            JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAnimalLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tf_indice, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpAnimalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_primero)
                .addGap(18, 18, 18)
                .addComponent(btn_anterior)
                .addGap(38, 38, 38)
                .addComponent(btn_posterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ultimo)
                .addGap(179, 179, 179))
            .addGroup(JpAnimalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAnimalLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpAnimalLayout.createSequentialGroup()
                        .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpAnimalLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_insertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_modificar)
                                .addGap(51, 51, 51))
                            .addGroup(JpAnimalLayout.createSequentialGroup()
                                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(JpAnimalLayout.createSequentialGroup()
                                            .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel4))
                                            .addGap(39, 39, 39)
                                            .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(JpAnimalLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tf_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(JpAnimalLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(51, 51, 51)
                                        .addComponent(rb_hombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_mujer)
                                        .addGap(12, 12, 12)
                                        .addComponent(rb_otros)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                        .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error_nombre)
                            .addComponent(error_apellido)
                            .addComponent(error_edad)
                            .addGroup(JpAnimalLayout.createSequentialGroup()
                                .addComponent(btn_recuperar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpAnimalLayout.setVerticalGroup(
            JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAnimalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAnimalLayout.createSequentialGroup()
                        .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error_nombre))
                        .addGap(18, 18, 18)
                        .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(error_apellido)
                            .addComponent(jLabel2)))
                    .addGroup(JpAnimalLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btn_guardar)))
                .addGap(18, 18, 18)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error_edad))
                .addGap(18, 18, 18)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_hombre)
                        .addComponent(rb_mujer)
                        .addComponent(rb_otros)))
                .addGap(21, 21, 21)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insertar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_recuperar)
                    .addComponent(btn_eliminar))
                .addGap(62, 62, 62)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ultimo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_posterior, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_anterior, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_primero, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(7, 7, 7)
                .addGroup(JpAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_indice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        tabla.getAccessibleContext().setAccessibleName("Tabla");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        btn_salir.setText("salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir))
                    .addComponent(JpAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // ocultar errores
        this.error_nombre.setVisible(false);
        this.error_apellido.setVisible(false);
        this.error_edad.setVisible(false);

        // que no haya campos vacios
        if (this.tf_nombre.getText().equals("") || this.tf_apellido.getText().equals("") || this.tf_edad.getText().equals("")) {
            if (tf_nombre.getText().equals("")) {
                this.error_nombre.setVisible(true);
            }
            if (this.tf_apellido.getText().equals("")) {
                this.error_apellido.setVisible(true);
            }
            if (this.tf_edad.getText().equals("")) {
                this.error_edad.setVisible(true);
            }
        } else {
            // insertar
            if (accion.equals("insertar")) {
                // cuando pulse el boton
                // JOptionPane.showMessageDialog(null, "Estas a punto de insertar un usuario");

                // crear una persona
                Persona persona = new Persona();

                // recuperar a la persona de los jtextfild
                String nombre = this.tf_nombre.getText();
                String apellido = this.tf_apellido.getText();
                int edad = 0;
                boolean pasa = true;
                try {
                    edad = Integer.valueOf(this.tf_edad.getText());
                } catch (Exception e) {
                    while (pasa) {
                        JOptionPane.showMessageDialog(null, "No estas introduciendo un numero");
                        try {
                            edad = Integer.valueOf(JOptionPane.showInputDialog("Introduce la edad"));
                            pasa = false;
                        } catch (Exception ex) {
                            pasa = true;
                        }

                    }
                }

                // insertar a la persona
                persona.setNombre_persona(nombre);
                persona.setApellido_persona(apellido);
                persona.setEdad_persona(edad);
                PersonaDAO pdao = new PersonaDAO();
                try {
                    pdao.insertarPersona(persona);
                    JOptionPane.showMessageDialog(null, "Persona insertada");
                    // actualizar tabla
                    actualizarTabla();

                    // restaurar botones (menos le posterior y el ultimo)
                    this.btn_insertar.setEnabled(true);
                    this.btn_recuperar.setEnabled(true);
                    this.btn_modificar.setEnabled(true);
                    this.btn_eliminar.setEnabled(true);
                    this.btn_guardar.setEnabled(false);

                    this.btn_primero.setEnabled(true);
                    //this.btn_posterior.setEnabled(true);
                    this.btn_anterior.setEnabled(true);
                    //this.btn_ultimo.setEnabled(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }

            } else if (accion.equals("modificar")) {
                // modificar persona
                PersonaDAO pdao = new PersonaDAO();
                Persona persona = new Persona();
                persona.setId_persona(Integer.valueOf(this.tf_id.getText()));
                persona.setNombre_persona(this.tf_nombre.getText());
                persona.setApellido_persona(this.tf_apellido.getText());
                
                
                //int edad = 0;
                boolean pasa = true;
                try {
                    //edad = Integer.valueOf(this.tf_edad.getText());
                    persona.setEdad_persona(Integer.valueOf(this.tf_edad.getText()));
                } catch (Exception e) {
                    while (pasa) {
                        JOptionPane.showMessageDialog(null, "No estas introduciendo un numero");
                        try {
                            //edad = Integer.valueOf(JOptionPane.showInputDialog("Introduce la edad"));
                            persona.setEdad_persona(Integer.valueOf(JOptionPane.showInputDialog("Introduce la edad")));
                            pasa = false;
                        } catch (Exception ex) {
                            pasa = true;
                        }

                    }
                }
                try {
                    pdao.modificarPersona(persona);
                    JOptionPane.showMessageDialog(rootPane, "Persona modificada correctamente");

                    // Actualizar mi array
                    listaPersonas.clear();
                    pdao.getListaPersonas(listaPersonas);

                    // restaurar botones (menos le posterior y el ultimo)
                    this.btn_insertar.setEnabled(true);
                    this.btn_recuperar.setEnabled(true);
                    this.btn_modificar.setEnabled(true);
                    this.btn_eliminar.setEnabled(true);
                    this.btn_guardar.setEnabled(false);

                    this.btn_primero.setEnabled(true);
                    this.btn_posterior.setEnabled(true);
                    this.btn_anterior.setEnabled(true);
                    this.btn_ultimo.setEnabled(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
            }

            this.tf_nombre.setEditable(false);
            this.tf_apellido.setEditable(false);
            this.tf_edad.setEditable(false);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Estas seguro de que quieres eliminar este usuario", "Atencion", dialogButton);
        if (dialogResult == 0) {
            // Eliminar a la persona
            PersonaDAO pdao = new PersonaDAO();
            pdao.eliminarPersona(Integer.valueOf(this.tf_id.getText()));
            JOptionPane.showMessageDialog(null, "Persona eliminada");
            // Actualizar mi array
            listaPersonas.clear();
            pdao.getListaPersonas(listaPersonas);
            // ir al ultimo objeto de la lista
            refrescar(listaPersonas.size() - 1);
            i = listaPersonas.size() - 1;
            activarPostUlt(false);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
        }


    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        this.tf_nombre.setEditable(true);
        this.tf_apellido.setEditable(true);
        this.tf_edad.setEditable(true);

        this.btn_insertar.setEnabled(false);
        this.btn_recuperar.setEnabled(false);
        this.btn_modificar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.btn_guardar.setEnabled(true);

        activarPostUlt(false);
        activarAntPrim(false);

        accion = "modificar";


    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_recuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recuperarActionPerformed
        // Recuperar persona
//        PersonaDAO pdao = new PersonaDAO();
//        Persona persona = pdao.recuperarPersona(Integer.valueOf(this.tf_id.getText()));
//        this.tf_nombre.setText(persona.getNombre_persona());
//        this.tf_apellido.setText(persona.getApellido_persona());
//        this.tf_edad.setText(String.valueOf(persona.getEdad_persona()));
    }//GEN-LAST:event_btn_recuperarActionPerformed

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        // boton anterior
        activarPostUlt(true);
        if (i == 1) {
            i = 0;
            activarAntPrim(false);
        } else {
            i = i - 1;
        }
        refrescar(i);
    }//GEN-LAST:event_btn_anteriorActionPerformed

    private void btn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoActionPerformed
        // boton ultimo
        i = listaPersonas.size() - 1;
        refrescar(i);

        activarPostUlt(false);
        activarAntPrim(true);
    }//GEN-LAST:event_btn_ultimoActionPerformed

    private void btn_posteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_posteriorActionPerformed
        // boton posterior
        activarAntPrim(true);
        if (i == listaPersonas.size() - 2) {
            i = listaPersonas.size() - 1;
            activarPostUlt(false);
        } else {
            i = i + 1;
        }
        refrescar(i);
    }//GEN-LAST:event_btn_posteriorActionPerformed

    private void btn_primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeroActionPerformed
        refrescar(0);
        activarPostUlt(true);
        activarAntPrim(false);
    }//GEN-LAST:event_btn_primeroActionPerformed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        // TODO add your handling code here:
        vaciarCampos();
        this.btn_insertar.setEnabled(false);
        this.btn_recuperar.setEnabled(false);
        this.btn_modificar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.btn_guardar.setEnabled(true);

        activarPostUlt(false);
        activarAntPrim(false);

        accion = "insertar";
    }//GEN-LAST:event_btn_insertarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void rb_mujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_mujerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_mujerActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // row es la fila seleccionada que la obtendre cuando me hagan un click en la tabla
        // el click de la tabla me lo recupera el evt.getPoint()
        int row = tabla.rowAtPoint(evt.getPoint());
        // A traves de la fila seleccionada, obtenemos el nombre
        // Me quedo con el valor de fila y de la columna
//        String id = (String) tabla.getValueAt(row, 0);
//        String nombre = (String) tabla.getValueAt(row, 1);
//        String apellido = (String) tabla.getValueAt(row, 2);
//        String edad = (String) tabla.getValueAt(row, 3);
//        
//        this.tf_id.setText(id);
//        this.tf_nombre.setText(nombre);
//        this.tf_apellido.setText(apellido);
//        this.tf_edad.setText(edad);
        i = row;
        refrescar(row);

    }//GEN-LAST:event_tablaMouseClicked

    private void cb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_departamentoActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpAnimal;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_posterior;
    private javax.swing.JButton btn_primero;
    private javax.swing.JButton btn_recuperar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_ultimo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_departamento;
    private javax.swing.JLabel error_apellido;
    private javax.swing.JLabel error_edad;
    private javax.swing.JLabel error_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_hombre;
    private javax.swing.JRadioButton rb_mujer;
    private javax.swing.JRadioButton rb_otros;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tf_apellido;
    private javax.swing.JTextField tf_edad;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_indice;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}

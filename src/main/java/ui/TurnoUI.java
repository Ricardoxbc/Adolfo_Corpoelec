/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import conexion.Conn;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.CellRenderedColours;
import model.TurnoX;

/**
 *
 * @author Ricardo Bermudez
 */
public class TurnoUI extends javax.swing.JInternalFrame {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private final int STEP = 7;
    private String DAYS[] = {
        "LUNES",
        "MARTES",
        "MIÉRCOLES",
        "JUEVES",
        "VIERNES",
        "SÁBADO",
        "DOMINGO"
    };

    private final DateChooser dateChooser;
    private TurnoX turnoActual = new TurnoX();
    private int[] selectedCell = new int[2];
    private int diaTablaSel = 0;

    private List<TurnoX> listaTurnos;

    /**
     * Creates new form TurnoUI
     */
    public TurnoUI() {
        initComponents();
        listaTurnos = new ArrayList<>();
        dateChooser = new DateChooser();
        initDateChooser();
        paintTabla();
        labelDia.setBackground(CellRenderedColours.CELL_DIA);
        labelNoche.setBackground(CellRenderedColours.CELL_NOCHE);
        labelMixto.setBackground(CellRenderedColours.CELL_MIXTO);
        labelLibre.setBackground(CellRenderedColours.CELL_LIBRE);
    }

    private void initDateChooser() {
        dateChooser.addEventDateChooser((a, sd) -> {
            if (a.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser.hidePopup();
                LocalDate ld = LocalDate.of(sd.getYear(), sd.getMonth(), sd.getDay());
                txtFechaInicio.setText(ld.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
                calculate();
                updateTablaLista();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCreacion = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        boxDescansos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtJornada = new javax.swing.JTextField();
        btnCrearTurno = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();
        btnEliminarTurno = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelDia = new javax.swing.JLabel();
        labelNoche = new javax.swing.JLabel();
        labelMixto = new javax.swing.JLabel();
        labelLibre = new javax.swing.JLabel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Turnos");

        tablaCreacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaCreacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCreacion.setRowHeight(35);
        tablaCreacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCreacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCreacion.setShowHorizontalLines(true);
        tablaCreacion.setShowVerticalLines(true);
        tablaCreacion.getTableHeader().setResizingAllowed(false);
        tablaCreacion.getTableHeader().setReorderingAllowed(false);
        tablaCreacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaCreacionMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCreacion);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Descansos");

        boxDescansos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes - Martes", "Martes - Miércoles", "Miércoles - Jueves", "Jueves - Viernes", "Viernes - Sábado", "Sábado - Domingo", "Domingo - Lunes" }));
        boxDescansos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDescansosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Fecha inicio");

        txtFechaInicio.setEditable(false);
        txtFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFechaInicio.setText("insertar fecha");
        txtFechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtFechaInicioMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Jornada");

        txtJornada.setEditable(false);
        txtJornada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJornada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtJornadaMouseReleased(evt);
            }
        });
        txtJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJornadaActionPerformed(evt);
            }
        });

        btnCrearTurno.setText("Crear turno");
        btnCrearTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTurnoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("( D, N, M )");

        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descansos", "Jornadas", "Fecha inicio", "Fecha fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLista.setRowHeight(30);
        tablaLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaLista.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaLista);
        tablaLista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnEliminarTurno.setText("Eliminar Turno");
        btnEliminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTurnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Leyenda");

        labelDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDia.setForeground(new java.awt.Color(0, 0, 0));
        labelDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDia.setText("Día");
        labelDia.setOpaque(true);

        labelNoche.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNoche.setForeground(new java.awt.Color(0, 0, 0));
        labelNoche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNoche.setText("Noche");
        labelNoche.setOpaque(true);

        labelMixto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMixto.setForeground(new java.awt.Color(0, 0, 0));
        labelMixto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMixto.setText("Mixto");
        labelMixto.setOpaque(true);

        labelLibre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelLibre.setForeground(new java.awt.Color(0, 0, 0));
        labelLibre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLibre.setText("Libre");
        labelLibre.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDia, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(labelNoche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(labelMixto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(labelLibre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMixto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelLibre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boxDescansos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCrearTurno))
                                    .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEliminarTurno, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(boxDescansos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearTurno)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarTurno))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaCreacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCreacionMouseReleased
        int row = tablaCreacion.rowAtPoint(evt.getPoint());
        int col = tablaCreacion.columnAtPoint(evt.getPoint());
        int count = evt.getClickCount();
        if (count > 1 && row >= 0 && col >= 0) {
            // Calcular rango de dias disponibles para trabajar
            if (tablaCreacion.getValueAt(row, col) == null || tablaCreacion.getValueAt(row, col).toString().isEmpty()) {
                txtJornada.setEditable(false);
                return;
            }
            selectedCell[0] = row;
            selectedCell[1] = col;
            diaTablaSel = (row) * STEP + (col + 1);
            txtJornada.setEditable(true);
            txtJornada.requestFocus();
        }
    }//GEN-LAST:event_tablaCreacionMouseReleased

    private void boxDescansosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDescansosActionPerformed
        calculate();
    }//GEN-LAST:event_boxDescansosActionPerformed

    private void txtFechaInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaInicioMouseReleased
        dateChooser.showPopup(txtFechaInicio, 0, txtFechaInicio.getHeight());
    }//GEN-LAST:event_txtFechaInicioMouseReleased

    private void txtJornadaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJornadaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJornadaMouseReleased

    private void btnCrearTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTurnoActionPerformed
        if (!(JOptionPane.showConfirmDialog(this, "Confirmar", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
            return;
        }
        int asignados = 0;
        if (turnoActual != null) {
            for (TurnoX.Turno t : turnoActual.getTurnos()) {
                if (t != null) {
                    asignados++;
                }
            }
        }

        if (asignados < 4) {
            Main.log("Debes asignar al menos 4 turnos");
            return;
        }
        boolean res = Conn.insertTurno(turnoActual);
        if (res) {
            Main.log("Guardado");
            reset();
        } else {
            Main.log(Main.GENERIC_ERROR);
        }
    }//GEN-LAST:event_btnCrearTurnoActionPerformed

    private void txtJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJornadaActionPerformed
        String txt = txtJornada.getText().trim().toUpperCase();
        int recorrido = 0;
        for (int i = diaTablaSel - 1; i >= 1; i--) {
            int r = Math.floorDiv(i, STEP);
            int c = i % STEP;
            String data = tablaCreacion.getValueAt(r, c).toString();
            if (data.contains("L")) {
                recorrido++;
                i--;
            }
        }
        if (tablaCreacion.getValueAt(0, 0).toString().contains("L") && recorrido > 0) {
            recorrido--;
        }
        try {
            turnoActual.getTurnos()[recorrido] = TurnoX.Turno.valueOf(txt);
            calculate();
            txtJornada.setText("");
            txtJornada.setEditable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dato no permitido");
        }
    }//GEN-LAST:event_txtJornadaActionPerformed

    private void btnEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTurnoActionPerformed
        int r = tablaLista.getSelectedRow();
        if (r < 0) {
            return;
        }
        if (!(JOptionPane.showConfirmDialog(this, "Confirmar", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
            return;
        }

        boolean res = Conn.eliminarTurno(listaTurnos.get(r));

        if (res) {
            Main.log("Eliminado");
            reset();
        } else {
            Main.log(Main.GENERIC_ERROR);
        }
    }//GEN-LAST:event_btnEliminarTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDescansos;
    private javax.swing.JButton btnCrearTurno;
    private javax.swing.JButton btnEliminarTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDia;
    private javax.swing.JLabel labelLibre;
    private javax.swing.JLabel labelMixto;
    private javax.swing.JLabel labelNoche;
    private javax.swing.JTable tablaCreacion;
    private javax.swing.JTable tablaLista;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtJornada;
    // End of variables declaration//GEN-END:variables

    private void calculate() {
        LocalDate ld = LocalDate.parse(txtFechaInicio.getText(), DateTimeFormatter.ofPattern(DATE_FORMAT));
        turnoActual
                .setInicioTurnoX(ld)
                .setDescanso(TurnoX.Descanso.values()[boxDescansos.getSelectedIndex()]);
        updateTablaCreacion();
    }

    private void updateTablaCreacion() {
        DefaultTableModel model = (DefaultTableModel) tablaCreacion.getModel();
        model.setRowCount(0);

        int descanso1 = turnoActual.getDescanso().ordinal();
        int descanso2 = descanso1 < (DAYS.length - 1) ? (descanso1 + 1) : 0;

        String nameColumns[] = new String[STEP];

        int firtsDay = turnoActual.getFinTurnoX().minusDays(turnoActual.getFinTurnoX().getDayOfMonth() - 1).getDayOfWeek().getValue() - 1;
        int dayAux = firtsDay;
        for (int i = 0; i < STEP; i++) {
            nameColumns[i] = DAYS[firtsDay++];
            if (firtsDay >= DAYS.length) {
                firtsDay = 0;
            }
        }

        boolean add = false;
        for (int i = 1, count = 0; i <= turnoActual.getFinTurnoX().getDayOfMonth(); i += STEP) {
            String row[] = new String[STEP];
            for (int j = 0; j < row.length && (i + j) <= turnoActual.getFinTurnoX().getDayOfMonth() && count < turnoActual.getTurnos().length; j++) {
                String data = "" + (i + j);

                if (descanso1 == dayAux || descanso2 == dayAux) {
                    data += " L";
                    if (add) {
                        count++;
                    }
                    add = false;
                } else {
                    add = true;
                    if (turnoActual.getTurnos()[count] != null) {
                        data += " " + turnoActual.getTurnos()[count].toString();
                    }
                }

                dayAux++;
                if (dayAux >= DAYS.length) {
                    dayAux = 0;
                }
                row[j] = data;
            }
            model.addRow(row);
        }

        model.setColumnIdentifiers(nameColumns);

        tablaCreacion.setModel(model);
        paintTabla();
    }

    private void updateTablaLista() {
        LocalDate ld = null;
        try {
            ld = LocalDate.parse(txtFechaInicio.getText(), DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (Exception e) {
            return;
        }
        listaTurnos = Conn.getTurnos(ld);
        DefaultTableModel model = (DefaultTableModel) tablaLista.getModel();
        model.setRowCount(0);

        String row[];
        for (TurnoX t : listaTurnos) {
            row = new String[]{
                t.getId() + "",
                t.getDescanso().toString(),
                Arrays.toString(t.getTurnos()),
                t.getInicioTurnoX().format(DateTimeFormatter.ofPattern(DATE_FORMAT)),
                t.getFinTurnoX().format(DateTimeFormatter.ofPattern(DATE_FORMAT))
            };
            model.addRow(row);
        }

        tablaLista.setModel(model);
    }

    private void reset() {
        txtJornada.setText("");
//        txtFechaInicio.setText("");
        turnoActual = new TurnoX();
        DefaultTableModel model = (DefaultTableModel) tablaCreacion.getModel();
        model.setRowCount(0);
        tablaCreacion.setModel(model);
        updateTablaLista();
    }

    private void paintTabla() {
        tablaCreacion.setDefaultRenderer(String.class, new CellRenderedColours());
    }

}
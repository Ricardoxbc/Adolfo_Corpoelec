/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedAction;
import conexion.Conn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.CellRenderedColours;
import model.TurnoX;
import model.Usuario;

/**
 *
 * @author Ricardo Bermudez
 */
public class ConsultaUI extends javax.swing.JInternalFrame {

    private final DateChooser dateChooser;
    private TurnoX turno;

    /**
     * Creates new form ConsultaUI
     */
    public ConsultaUI() {
        initComponents();
        dateChooser = new DateChooser();
        labels();
//        initDateChooser();
    }

    private void labels() {
        labelDia.setBackground(CellRenderedColours.CELL_DIA);
        labelNoche.setBackground(CellRenderedColours.CELL_NOCHE);
        labelMixto.setBackground(CellRenderedColours.CELL_MIXTO);
        labelLibre.setBackground(CellRenderedColours.CELL_LIBRE);
    }

//    private void initDateChooser() {
//        dateChooser.addEventDateChooser((a, sd) -> {
//            if (a.getAction() == SelectedAction.DAY_SELECTED) {
//                dateChooser.hidePopup();
//                LocalDate ld = LocalDate.of(sd.getYear(), sd.getMonth(), sd.getDay());
//                txtFechaInicio.setText(ld.format(DateTimeFormatter.ofPattern(TurnoUI.DATE_FORMAT)));
//                getTurno(ld);
//            }
//        });
//    }
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
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labelDia = new javax.swing.JLabel();
        labelNoche = new javax.swing.JLabel();
        labelMixto = new javax.swing.JLabel();
        labelLibre = new javax.swing.JLabel();
        btnMostrrarHorario = new javax.swing.JButton();
        txtInfo = new javax.swing.JTextField();
        btnExportar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultas");

        tabla.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setRowHeight(35);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(true);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

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

        btnMostrrarHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMostrrarHorario.setText("Mostrar Horario");
        btnMostrrarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrrarHorarioActionPerformed(evt);
            }
        });

        txtInfo.setEditable(false);
        txtInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnExportar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelMixto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelNoche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelLibre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportar)
                            .addComponent(btnMostrrarHorario)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(labelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelMixto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelLibre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrrarHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrrarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrrarHorarioActionPerformed
        if (Main.getUsuario() == null) {
            return;
        }

        Usuario usuarioAct = Conn.getUsuario(Main.getUsuario())
                .stream()
                .findFirst()
                .orElse(null);

        if (usuarioAct == null || usuarioAct.getHorarioId() == null) {
            Main.log("Error. Este usuario no tiene asignado un horario.");
            return;
        }
        
        turno = Conn.getTurno(usuarioAct.getHorarioId());
        TurnoUI.updateTablaHorario(turno, tabla);
        txtInfo.setText("Asignados del "
                + turno.getInicioTurnoX().format(DateTimeFormatter.ofPattern(TurnoUI.DATE_FORMAT)) + " al "
                + turno.getFinTurnoX().format(DateTimeFormatter.ofPattern(TurnoUI.DATE_FORMAT)));
    }//GEN-LAST:event_btnMostrrarHorarioActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        if (turno == null) {
            Main.log("No hay datos para exportar");
            return;
        }
        TurnoUI.exportar(turno, null);
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnMostrrarHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDia;
    private javax.swing.JLabel labelLibre;
    private javax.swing.JLabel labelMixto;
    private javax.swing.JLabel labelNoche;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtInfo;
    // End of variables declaration//GEN-END:variables

    private void getTurno(LocalDate ld) {

    }
}

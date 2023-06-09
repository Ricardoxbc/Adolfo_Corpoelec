/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ui;

import conexion.Conn;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.SetFondo;
import model.TurnoX;
import model.Usuario;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.PageMargin;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import static ui.TurnoUI.DAYS;
import static ui.TurnoUI.DIA;
import static ui.TurnoUI.FONT_SIZE;
import static ui.TurnoUI.LIBRE;
import static ui.TurnoUI.MIXTO;
import static ui.TurnoUI.NOCHE;
import static ui.TurnoUI.ROW_I;
import static ui.TurnoUI.ROW_P;

/**
 *
 * @author Ricardo Bermudez
 */
public class Main extends javax.swing.JFrame {

    public static final String GENERIC_ERROR = "Ha ocurrido un error, detalles en la consola";
    public static final int ADMINISTRADOR = 1, COORDINADOR = 2, USUARIO = 0;

    private static Usuario usuario;

    /**
     * Creates new form Principal
     */
    public Main() {
        initComponents();
        try {
            desktopPane.setBorder(new SetFondo(this.getClass().getResource("/fondo.jpg")));
            menuBar.setBorder(new SetFondo(this.getClass().getResource("/fondoLogin.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        iniciar.doClick();
    }

    public void iniciarSesion(Usuario u) {
        this.usuario = u;
        sesionMenu.setEnabled(false);

        if (usuario.getId().equals(1L)) {
            administradorMenu.setVisible(true);
            administradorMenu.setEnabled(true);
            coordinadorMenu.setEnabled(true);
            coordinadorMenu.setVisible(true);
            usuarioMenu.setEnabled(true);
            usuarioMenu.setVisible(true);
            return;
        }

        String title = "Bienvenido/a " + u.getNombre() + " " + u.getApellido() + " - ";

        switch (u.getAcceso()) {
            case ADMINISTRADOR: {
                administradorMenu.setVisible(true);
                administradorMenu.setEnabled(true);
                title += "Administrador";
                break;
            }
            case COORDINADOR: {
                coordinadorMenu.setEnabled(true);
                coordinadorMenu.setVisible(true);
                title += "Coordinador";
                break;
            }
            case USUARIO: {
                usuarioMenu.setEnabled(true);
                usuarioMenu.setVisible(true);
                title += "Usuario";
                break;
            }
            default: {
                sesionMenu.setEnabled(true);
            }

            labelInfo.setText(title);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        labelInfo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        administradorMenu = new javax.swing.JMenu();
        personal = new javax.swing.JMenuItem();
        horarios = new javax.swing.JMenuItem();
        coordinadorMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        sesionMenu = new javax.swing.JMenu();
        iniciar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        labelInfo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        labelInfo.setForeground(new java.awt.Color(250, 250, 250));
        desktopPane.add(labelInfo);
        labelInfo.setBounds(0, 0, 800, 50);

        menuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        administradorMenu.setText("Administrador");
        administradorMenu.setEnabled(false);

        personal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        personal.setText("Gestión de personal");
        personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalActionPerformed(evt);
            }
        });
        administradorMenu.add(personal);

        horarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        horarios.setText("Gestión de horarios");
        horarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horariosActionPerformed(evt);
            }
        });
        administradorMenu.add(horarios);

        menuBar.add(administradorMenu);
        administradorMenu.setVisible(false);

        coordinadorMenu.setText("Coordinador");
        coordinadorMenu.setEnabled(false);

        cutMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cutMenuItem.setText("Asignar horarios");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        coordinadorMenu.add(cutMenuItem);

        copyMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyMenuItem.setText("Impresiones");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        coordinadorMenu.add(copyMenuItem);

        menuBar.add(coordinadorMenu);
        coordinadorMenu.setVisible(false);

        usuarioMenu.setText("Usuario");
        usuarioMenu.setEnabled(false);

        contentMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contentMenuItem.setText("Consultar horario");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        usuarioMenu.add(contentMenuItem);

        menuBar.add(usuarioMenu);
        usuarioMenu.setVisible(false);

        sesionMenu.setText("Sesión");
        sesionMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        iniciar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        iniciar.setText("Iniciar sesión");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        sesionMenu.add(iniciar);

        menuBar.add(sesionMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalActionPerformed
        desktopPane.removeAll();

        UsuarioUI u = new UsuarioUI();
        u.setVisible(true);
        try {
            u.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        desktopPane.add(u);
        desktopPane.revalidate();
        desktopPane.repaint();
    }//GEN-LAST:event_personalActionPerformed

    private void horariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horariosActionPerformed
        desktopPane.removeAll();

        TurnoUI t = new TurnoUI();
        t.setVisible(true);
        try {
            t.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopPane.add(t);
        desktopPane.revalidate();
        desktopPane.repaint();
    }//GEN-LAST:event_horariosActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        desktopPane.removeAll();

        Login login = new Login(this);
        login.setVisible(true);
        login.setLocation(desktopPane.getWidth() / 2 - login.getWidth() / 2, desktopPane.getHeight() / 2 - login.getHeight() / 2);

        desktopPane.add(login);
        desktopPane.revalidate();
        desktopPane.repaint();

        login.getTxtCedula().requestFocus();
    }//GEN-LAST:event_iniciarActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        desktopPane.removeAll();

        HorarioUI h = new HorarioUI();
        h.setVisible(true);
        try {
            h.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopPane.add(h);
        desktopPane.revalidate();
        desktopPane.repaint();
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        desktopPane.removeAll();

        ConsultaUI c = new ConsultaUI();
        c.setVisible(true);
        try {
            c.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopPane.add(c);
        desktopPane.revalidate();
        desktopPane.repaint();
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // Escojer el mes
        if (JOptionPane.showConfirmDialog(this, "Generar los horarios asignados a el mes actual", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        exportar();

    }//GEN-LAST:event_copyMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu administradorMenu;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenu coordinadorMenu;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem horarios;
    private javax.swing.JMenuItem iniciar;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem personal;
    private javax.swing.JMenu sesionMenu;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void log(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    private void setDocumentHeader(HSSFWorkbook libroExcel, Sheet hoja, HSSFPalette palette, int index) throws IOException {
        Row headerImg = hoja.createRow(index++);
        headerImg.setHeightInPoints(FONT_SIZE * 4);
        Cell celdaImg = headerImg.createCell(0);

        InputStream imgStream = TurnoUI.class.getResourceAsStream("/logo.png");
        byte[] imgByte = imgStream.readAllBytes();
        int imgIndex = libroExcel.addPicture(imgByte, libroExcel.PICTURE_TYPE_PNG);

        HSSFClientAnchor anchorImg = new HSSFClientAnchor(0, 0, 0, 0, (short) celdaImg.getColumnIndex(), celdaImg.getRowIndex(), (short) (celdaImg.getColumnIndex() + 2), celdaImg.getRowIndex() + 1);
        anchorImg.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
        Drawing drawingImg = hoja.createDrawingPatriarch();
        drawingImg.createPicture(anchorImg, imgIndex);
    }

    private void exportar() {
        LocalDate fechaFin = LocalDate.now(ZoneId.systemDefault());
        LocalDate fechaInit = fechaFin.plusMonths(1);
        fechaFin = fechaInit.minusDays(fechaInit.getDayOfMonth());
        fechaInit = fechaFin.minusDays(fechaFin.getDayOfMonth() - 1);
        List<Usuario> usuarios = Conn.getUsuario(null);

        try {
            HSSFWorkbook libroExcel = new HSSFWorkbook();
            HSSFPalette palette = TurnoUI.crearPaletaColores(libroExcel);

            Sheet hoja = libroExcel.createSheet(fechaFin.getMonthValue() + "-" + fechaFin.getYear());
            hoja.getPrintSetup().setLandscape(true);
            hoja.setMargin(PageMargin.LEFT, 10);

            int index = 0;
            int days = 0;
//            int diaSemInit = turno.getInicioTurnoX().getDayOfWeek().getValue() - 1;
//            int descanso1 = turno.getDescanso().ordinal();
//            int descanso2 = descanso1 < (TurnoUI.DAYS.length - 1) ? (descanso1 + 1) : 0;
//            boolean add = false;

            //Cabecera, logo, etc
            setDocumentHeader(libroExcel, hoja, palette, index++);
            index++;

            for (int iSem = 1, semanaN = 1; iSem <= fechaFin.getDayOfMonth(); iSem += DAYS.length, semanaN++, index++) {
                // Columnas header
                Row headerTitle = hoja.createRow(index++);
                Cell cellTitle = headerTitle.createCell(0);
                CellStyle cs = cellTitle.getCellStyle();
                cs.setFont(TurnoUI.getArialFont(libroExcel, (int) (FONT_SIZE * 1.5f), true));
                cellTitle.setCellValue("Semana " + semanaN);
                cellTitle.setCellStyle(cs);

                Row header = hoja.createRow(index++);
                Cell cellFecha = header.createCell(0);
                TurnoUI.setCellStyle(libroExcel, cellFecha, palette, ROW_P, true);
                cellFecha.setCellValue(getRango(fechaInit.plusDays((semanaN - 1) * DAYS.length)));
                for (int i = 0; i < DAYS.length; i++) {
                    header.setHeightInPoints(FONT_SIZE * 3);
                    hoja.setColumnWidth(i + 1, 16 * 255);
                    Cell celda = header.createCell(i + 1);
                    TurnoUI.setCellStyle(libroExcel, celda, palette, ROW_P, true);
                    celda.setCellValue(DAYS[i]);
                }

//                days = (iSem - 1) * 
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario u = usuarios.get(i);
                    Row rowUser = hoja.createRow(index++);
                    rowUser.setHeightInPoints(FONT_SIZE * 3);
                    hoja.setColumnWidth(0, 36 * 255);
                    Cell celdaUser = rowUser.createCell(0);
                    TurnoUI.setCellStyle(libroExcel, celdaUser, palette, ROW_P, false);
                    celdaUser.setCellValue(u.getNombre() + " " + u.getApellido() + " - " + u.getCargo());
                    for (int j = 0, daysAux = (semanaN - 1) * DAYS.length; j < DAYS.length && daysAux < fechaFin.getDayOfMonth(); j++, daysAux++) {
                        hoja.setColumnWidth(j + 1, 16 * 255);
                        Cell celda = rowUser.createCell(j + 1);

                        short colorIndex = ROW_I;
                        String value = getTurno(u, fechaInit.plusDays(daysAux));
                        if (Objects.equals(value, TurnoX.Turno.D.toString())) {
                            colorIndex = DIA;
                        } else if (Objects.equals(value, TurnoX.Turno.N.toString())) {
                            colorIndex = NOCHE;
                        } else if (Objects.equals(value, TurnoX.Turno.M.toString())) {
                            colorIndex = MIXTO;
                        } else if (Objects.equals(value, "L")) {
                            colorIndex = LIBRE;
                        } else {
                            colorIndex = ROW_P;
                        }
                        TurnoUI.setCellStyle(libroExcel, celda, palette, colorIndex, true);

                        celda.setCellValue(fechaInit.plusDays(daysAux).toString());
                    }
                }
//                days += diasTranscurridos;
            }

            // Crear un archivo de salida para el libro de Excel
            LocalDate dateFileName = LocalDate.now();
            String fileName = "Reporte" + "_" + System.currentTimeMillis() + "_" + dateFileName.format(DateTimeFormatter.ofPattern("MM_yyyy")) + ".xls";
            FileOutputStream archivoSalida = new FileOutputStream(fileName);

            // Guardar el libro de Excel en el archivo de salida
            libroExcel.write(archivoSalida);

            // Cerrar el archivo de salida y el libro de Excel
            archivoSalida.close();
            libroExcel.close();
//            Main.log("Archivo guardado");
            if (JOptionPane.showConfirmDialog(this, "Documento Guardado, Desea abrirlo?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().open(new File(fileName));
            }
        } catch (IOException ex) {
            Logger.getLogger(TurnoUI.class.getName()).log(Level.SEVERE, null, ex);
            Main.log("Error exportando el documento, revisa la consola para más detalles.");
        }
    }

    private String getRango(LocalDate fechaInit) {
        String s1 = fechaInit.format(DateTimeFormatter.ofPattern("dd-MM"));
        LocalDate f2 = fechaInit.plusDays(7);
        if (f2.getMonthValue() > fechaInit.getMonthValue()) {
            f2 = f2.minusDays(f2.getDayOfMonth());
        }
        String s2 = f2.format(DateTimeFormatter.ofPattern("dd-MM"));
        return "Del " + s1 + " al " + s2;
    }

    private String getTurno(Usuario u, LocalDate day) {
        if (u.getHorario() == null) {
            return null;
        }
        int descanso1 = u.getHorario().getDescanso().ordinal() + 1;
        int descanso2 = descanso1 < (TurnoUI.DAYS.length) ? (descanso1 + 1) : 1;
//        int diaSem = day.getDayOfWeek().getValue() - 1;
//        if (diaSem == descanso1 || diaSem == descanso2) {
//            return "L";
//        }

        int desc = 0;
        boolean add = false;
        String sel = "";
        LocalDate dayAux = day.minusDays(day.getDayOfMonth() - 1);
        for (int i = 1; i <= day.getDayOfMonth() && desc < u.getHorario().getTurnos().length; i++, dayAux = dayAux.plusDays(1)) {
            int sem = dayAux.getDayOfWeek().getValue();
            if (sem == descanso1 || sem == descanso2) {
                if (add) {
                    desc++;
                }
                sel = "L";
                add = false;
                continue;
            }

            add = true;
            sel = u.getHorario().getTurnos()[desc] != null
                    ? u.getHorario().getTurnos()[desc].toString() : null;
        }
        return sel;
    }

}

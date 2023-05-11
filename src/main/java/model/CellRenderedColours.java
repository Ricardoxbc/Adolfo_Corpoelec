/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Ricardo Bermudez
 */
public class CellRenderedColours extends DefaultTableCellRenderer {

    //Colores
    public static final Color ROW_PAR = new Color(240, 240, 240);
    public static final Color ROW_IMPAR = new Color(220, 220, 220);
    public static final Color ROW_SELECTED = new Color(50, 80, 240);
    
    public static final Color CELL_LIBRE = new Color(40, 240, 40);
    public static final Color CELL_DIA = new Color(255, 181, 70);
    public static final Color CELL_NOCHE = new Color(19, 180, 255);
    public static final Color CELL_MIXTO = new Color(240, 60, 240);
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        TurnoX.Turno turno = null;
        Component component = null;
        boolean par = row % 2 == 0;
        if (value != null) {
            String val[] = value.toString().split(" ");
            if (val.length == 2) {
                component = super.getTableCellRendererComponent(table, val[0], isSelected, hasFocus, row, column);
                component.setForeground(Color.BLACK);
                if (val[1].equalsIgnoreCase("L")) {
                    component.setBackground(CELL_LIBRE);
                    return component;
                }

                turno = TurnoX.Turno.valueOf(val[1]);
                if (turno == TurnoX.Turno.D) {
                    component.setBackground(CELL_DIA);
                    return component;
                }
                if (turno == TurnoX.Turno.N) {
                    component.setBackground(CELL_NOCHE);
                    return component;
                }
                if (turno == TurnoX.Turno.M) {
                    component.setBackground(CELL_MIXTO);
                    return component;
                }

            }
        }

        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setForeground(Color.BLACK);
        if (par) {
            component.setBackground(ROW_PAR);
        } else {
            component.setBackground(ROW_IMPAR);
        }
        
        if (false && isSelected) {
            component.setBackground(ROW_SELECTED);
        }
        
        return component;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Ricardo Bermudez
 */
public class SetFondo implements Border{
    
    Image imagen = null;

    public SetFondo(String path) throws IOException {
        File file = new File(path);
        BufferedImage img = ImageIO.read(file);
        imagen = img;
    }
    
    public SetFondo(URL path) throws IOException {
        BufferedImage img = ImageIO.read(path);
        imagen = img;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

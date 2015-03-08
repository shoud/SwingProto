package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PImage extends JButton {

    private BufferedImage image;
    private JLabel picLabel;
    private File file;

    public PImage()
    {
        try
        {
            ///home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif
            file = new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
            image = ImageIO.read(file);
            picLabel = new JLabel(new ImageIcon(image));
        }catch (IOException ex)
        {
            System.out.println("Impossible d'ouvrir l'image par defaut");
        }
    }
    public PImage(String chemin)
    {
        try
        {
            file = new File(chemin);
            image = ImageIO.read(file);
            picLabel = new JLabel(new ImageIcon(image));
        }catch (IOException ex)
        {
            System.out.println("Impossible d'ouvrir l'image par defaut");
        }
    }
    public void setImage(File file)
    {
        try
        {
            image = ImageIO.read(file);
            picLabel = new JLabel(new ImageIcon(image));
        }catch (IOException ex)
        {
            System.out.println("Impossible d'ouvrir l'image par defaut");
        }
    }
    public JLabel getImage()
    {
        return this.picLabel;
    }
    public File getFile() { return this.file; }
}
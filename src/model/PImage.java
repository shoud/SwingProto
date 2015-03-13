package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PImage extends JPanel
{

    private BufferedImage image;
    private JLabel picLabel;
    private File file;
    private ImageIcon imageIcon;

    public PImage()
    {
        try
        {
            ///home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif
            file = new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
            image = ImageIO.read(file);
            //this.setIcon((Icon) image);
        }catch (IOException ex)
        {
            System.out.println("Impossible d'ouvrir l'image par defaut");
        }
    }
    public PImage(File file)
    {
        try
        {
            this.file = file;
            image = ImageIO.read(file);
            //ImageIcon imageIcon = new ImageIcon("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.jpg");
            //this.setIcon(imageIcon);
            ImageIcon imageIcon = new ImageIcon(image);
            picLabel = new JLabel(imageIcon);
            picLabel.setPreferredSize(new Dimension(400, 300));
            this.add(picLabel);
        }catch (IOException ex)
        {
            System.out.println("Impossible d'ouvrir l'image par defaut");
        }
    }
    public void setImage(File file)
    {
        if(file != null)
        {
            try
            {
                this.file = file;
                image = ImageIO.read(file);
                ImageIcon imageIcon = new ImageIcon(image);
                picLabel.setIcon(imageIcon);
                picLabel.setPreferredSize(new Dimension(400, 300));

            }catch (IOException ex)
            {
                System.out.println("Impossible d'ouvrir l'image par defaut");
            }
        }
        else
        {
            System.out.println("Ce n'est pas une image");
        }
    }
    public ImageIcon getIcon(){return this.imageIcon;};
    public File getFile() { return this.file; }
}
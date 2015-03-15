package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


//JPanel
public class PImage extends JButton
{

    private BufferedImage image;
    private JLabel picLabel;
    private File file;
    private ImageIcon imageIcon;
    private int Width;
    private int Height;

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
            Redimensionner();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(this.Width, this.Height, Image.SCALE_DEFAULT));
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
                Redimensionner();
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(this.Width, this.Height, Image.SCALE_DEFAULT));
                picLabel.setIcon(imageIcon);
                //picLabel.setPreferredSize(new Dimension(400, 300));

            }catch (IOException ex)
            {
                //System.out.println("Impossible d'ouvrir l'image par defaut");
            }
        }
    }
    private void Redimensionner()
    {
        this.Width = 400;
        this.Height = 300;
        if(image.getWidth() < 400)
            this.Width = image.getWidth();
        if(image.getHeight() < 300)
            this.Height = image.getHeight();

    }
    public ImageIcon getIcon(){return this.imageIcon;};
    public File getFile() { return this.file; }
}
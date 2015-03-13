package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImageCourante extends JLabel
{
    Image img;
    File file;
    Graphics g;

    public ImageCourante(File file)
    {
        this.file = file;
    }
    public void paintComponent(Graphics g){
        this.g = g;
        try {
            img = ImageIO.read(file);
            //Permet d'afficher l'image dans tout le JPanel
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setFile(File file)
    {
        this.file = file;
    }
}

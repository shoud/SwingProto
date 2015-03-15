package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe permettant de réprésenter graphiquement les miniatures
 */
public class Miniature extends JPanel
{
    Image img;
    File file;

    public void paintComponent(Graphics g){
        try {
            //Le chemin de l'image
            file = new File("D:/GitHub/SwingProto/src/rsc/default.gif");
            img = ImageIO.read(file);
            //Permet d'afficher l'image dans tout le JPanel
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

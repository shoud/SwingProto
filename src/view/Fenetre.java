package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.*;
import java.io.File;

/**
 * Classe permettant de créer une fenêtre
 */
public class Fenetre extends JFrame {

    //Composants


    public Fenetre()
    {
        //On rajoute un titre à la fenêtre
        this.setTitle("Gestion d'image");
        //Taille de la fenêtre
        this.setSize(1280, 720);
        //Afficher la fenêtre au centre de l'écran
        this.setLocationRelativeTo(null);
        //Empêche le redimensionnement
        this. setResizable(false);
        //Permet de d'arrêter le programme lors de la fermeture de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //On crée nos différents conteneurs de couleur différente

        //Titre de l'application
        JPanel titreApplication = new JPanel();
        titreApplication.setBackground(Color.YELLOW);
        titreApplication.setPreferredSize(new Dimension(200, 50));
        titreApplication.add(new JLabel("Gestion d'images"));

        //Permet de rechercher une image
        JPanel recherchePanel = new JPanel();
        recherchePanel.setBackground(Color.red);
        recherchePanel.setPreferredSize(new Dimension(200, 50));
        JTextField m_textRecherche = new JTextField("Recherche");
        recherchePanel.add(m_textRecherche);

        //Permet de changer la langue du programme
        JPanel langagePanel = new JPanel();
        langagePanel.setBackground(Color.green);
        langagePanel.setPreferredSize(new Dimension(200, 50));
        String[] items = {"Français", "English", "中国"};
        JComboBox m_choixLangue = new JComboBox(items);
        langagePanel.add(m_choixLangue);

        //Bouton permettant d'afficher l'aide
        JPanel aidePanel = new JPanel();
        aidePanel.setBackground(Color.black);
        aidePanel.setPreferredSize(new Dimension(680, 50));
        JButton btAide = new JButton("Aide");
        aidePanel.add(btAide);

        //L'arbre des fichiers
        File fileArbre = new File(".");
        ArbreChemin arbrePanel = new ArbreChemin();
        arbrePanel.setBackground(Color.cyan);
        arbrePanel.setPreferredSize(new Dimension(200, 670));

        //Image courante
        ImageCourante imageCourante = new ImageCourante();
        imageCourante.setBackground(Color.BLUE);
        imageCourante.setPreferredSize(new Dimension(400, 300));

        //Titre de l'image courante
        JPanel titreImagePanel = new JPanel();
        titreImagePanel.setBackground(Color.PINK);
        titreImagePanel.setPreferredSize(new Dimension(680, 50));
        JTextField titreImage = new JTextField("Titre de l'image");
        titreImage.setPreferredSize(new Dimension(679, 49));
        titreImagePanel.add(titreImage);

        //Les tags de l'image courante
        JPanel tagImageCourantePanel = new JPanel();
        tagImageCourantePanel.setBackground(Color.darkGray);
        tagImageCourantePanel.setPreferredSize(new Dimension(680, 250));
        JTextField tagImage = new JTextField("Tag de l'image");
        tagImage.setPreferredSize(new Dimension(679, 249));
        tagImageCourantePanel.add(tagImage);

        //Le bouton précèdent
        JPanel boutonprecedentPanel = new JPanel();
        boutonprecedentPanel.setPreferredSize(new Dimension(50, 50));
        JButton btPrecedent = new JButton("<-");
        boutonprecedentPanel.add(btPrecedent);

        //La première miniature
        Miniature miniature01 = new Miniature();
        miniature01.setPreferredSize(new Dimension(250, 125));

        //La deuxième image
        Miniature miniature02 = new Miniature();
        miniature02.setPreferredSize(new Dimension(250, 125));

        //La troisième image
        Miniature miniature03 = new Miniature();
        miniature03.setPreferredSize(new Dimension(250, 125));

        //La quatrième image
        Miniature miniature04 = new Miniature();
        miniature04.setPreferredSize(new Dimension(250, 125));

        //La cinquième image
        Miniature miniature05 = new Miniature();
        miniature05.setPreferredSize(new Dimension(250, 125));

        //Le bouton suivant
        JPanel boutonSuivantPanel = new JPanel();
        boutonSuivantPanel.setPreferredSize(new Dimension(50, 50));
        JButton btSuivant = new JButton("->");
        boutonSuivantPanel.add(btSuivant);

        //Le conteneur principal
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(1280, 720));
        content.setBackground(Color.WHITE);
        //On définit le layout manager
        content.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        content.add(titreApplication, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.gridx = 1;
        content.add(recherchePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.gridx = 2;
        content.add(langagePanel, gbc);
        //---------------------------------------------
        //Cette instruction informe le layout que c'est une fin de ligne
        //On positionne la case de départ du composant
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(aidePanel, gbc);
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridheight = 3;
        //Celle-ci indique que la cellule se réplique de façon verticale
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(arbrePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.gridx = 1;
        gbc.gridheight = 2;
        content.add(imageCourante, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.gridx = 3;
        gbc.gridheight = 1;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(titreImagePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.gridx = 3;
        gbc.gridy = 2;
        //gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(tagImageCourantePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        /*gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        content.add(boutonprecedentPanel, gbc);
        //---------------------------------------------
        gbc.gridx = 2;
        content.add(miniature01, gbc);
        //---------------------------------------------
        gbc.gridx = 3;
        content.add(miniature02, gbc);
        //---------------------------------------------
        gbc.gridx = 4;
        content.add(miniature03, gbc);
        //---------------------------------------------
        gbc.gridx = 5;
        content.add(miniature04, gbc);
        //---------------------------------------------
        gbc.gridx = 6;
        content.add(miniature05, gbc);
        //---------------------------------------------
        gbc.gridx = 7;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(boutonSuivantPanel, gbc);*/
        //---------------------------------------------

        //On ajoute le conteneur
        this.setContentPane(content);

        //Rend visible la fenêtre
        this.setVisible(true);
    }
}

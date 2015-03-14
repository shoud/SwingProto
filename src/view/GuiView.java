package view;

import javax.swing.*;

import controller.CounterController;
import model.CounterModel;
import model.PImage;

import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe permetttant de gérer l'affichage graphique
 */
public class GuiView implements Observer {
    //Le model
    private CounterModel m_model;
    //Composants
    private ArbreChemin arbrePanel;
    private JButton btPrecedent = new JButton("<-");
    private JTextField titreImage;
    private PImage imageCourante;
    private PImage miniature01 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    private PImage miniature02 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    private PImage miniature03 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    private PImage miniature04 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    private JPanel imageCourantePanel;
    private JPanel principalePanel;
    private JPanel menu;
    private JPanel miniaturePanel;
    private JButton btSuivant = new JButton("->");
    private JTextField m_textRecherche;
    private JLabel gestionImage;
    private JComboBox m_choixLangue;
    private JButton btModifier = new JButton("Modifier");;
    private JTextField tagImage;

    /**
     * Conttructeur de GuiView
     * Permet de créer l'interface graphique
     *
     * @param m_model Le CounterModel
     */
    public GuiView(CounterModel m_model)
    {
        this.m_model = m_model;
        this.m_model. addObserver(this);
        SwingUtilities . invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Permet de créer la fenêtre en placant tout ses composants.
     */
    public void createAndShowGUI()
    {
        JFrame frame = new JFrame();

        //Panel Principale
        principalePanel = new JPanel();
        principalePanel.setPreferredSize(new Dimension(1280, 705));
        principalePanel.setLayout(new GridBagLayout());
        principalePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        miniaturePanel = new JPanel();
        miniaturePanel.setPreferredSize(new Dimension(1079, 350));
        miniaturePanel.setLayout(new FlowLayout());
        miniaturePanel.setBorder(BorderFactory.createTitledBorder("Images suivantes"));

        menu = new JPanel();
        menu.setPreferredSize(new Dimension(1279, 50));
        FlowLayout flowLayoutMenu = new FlowLayout();
        menu.setLayout(flowLayoutMenu);
        menu.setBorder(BorderFactory.createTitledBorder("Options"));

        //Titre de l'application
        gestionImage = new JLabel("Gestion d'images");

        //Permet de rechercher une image
         m_textRecherche = new JTextField("Recherche");

        //Permet de changer la langue du programme
        String[] items = {"Français", "English", "中国"};
        m_choixLangue = new JComboBox(items);

        //L'arbre des fichiers
        arbrePanel = new ArbreChemin(m_model);
        arbrePanel.setPreferredSize(new Dimension(200, 670));
        arbrePanel.setBorder(BorderFactory.createTitledBorder("Dossier"));

        //Image courante
        imageCourante = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.jpg"));
        imageCourante.setPreferredSize(new Dimension(400, 300));
        imageCourante.setBorder(BorderFactory.createTitledBorder("Visualisation de l'image courante"));

        //Titre de l'image courante
        titreImage = new JTextField("Titre de l'image");
        titreImage.setPreferredSize(new Dimension(679, 49));
        titreImage.setBorder(BorderFactory.createTitledBorder("Nom de l'image"));

        //Les tags de l'image courante
        tagImage = new JTextField("Tag de l'image");
        tagImage.setPreferredSize(new Dimension(679, 249));
        tagImage.setBorder(BorderFactory.createTitledBorder("Tag de l'image"));

        //La première miniature
        miniature01.setPreferredSize(new Dimension(200, 350));


        //La deuxième image
        miniature02.setPreferredSize(new Dimension(200, 350));

        //La troisième image
        miniature03.setPreferredSize(new Dimension(200, 350));

        //La quatrième image
        miniature04.setPreferredSize(new Dimension(200, 350));

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        menu.add(gestionImage);
        menu.add(m_textRecherche);
        menu.add(m_choixLangue);
        menu.add(btModifier);

        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight= 1;
        principalePanel.add(menu, gbc);
        //---------------------------------------------
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 3.0;
        gbc.gridwidth = 1;
        gbc.gridheight= 3;
        principalePanel.add(arbrePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        gbc.gridwidth = 2;
        gbc.gridheight= 2;
        principalePanel.add(imageCourante, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridheight= 1;
        gbc.ipady =0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        principalePanel.add(titreImage, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridheight= 1;
        gbc.ipady =0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        principalePanel.add(tagImage, gbc);
        //---------------------------------------------
        miniaturePanel.add(btPrecedent);
        miniaturePanel.add(miniature01);
        miniaturePanel.add(miniature02);
        miniaturePanel.add(miniature03);
        miniaturePanel.add(miniature04);
        miniaturePanel.add(btSuivant);

        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        principalePanel.add(miniaturePanel, gbc);

        frame.add(principalePanel);
        frame.pack();
        //On rajoute un titre à la fenêtre
        frame.setTitle("Gestion d'image");
        //Taille de la fenêtre
        frame.setSize(1281, 721);
        frame.setSize(1280, 720);
        //Afficher la fenêtre au centre de l'écran
        frame.setLocationRelativeTo(null);
        //Empêche le redimensionnement
        frame.setResizable(false);
        //Permet de d'arrêter le programme lors de la fermeture de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Rend visible la fenêtre
        frame.setVisible(true);
    }
    public JButton getBtModifier() { return btModifier; }
    public JButton getBtPrecedent() { return btPrecedent; }
    public JButton getBtSuivant() { return btSuivant; }
    public PImage getMiniature01() {return miniature01; }
    public PImage getMiniature02() {return miniature02; }
    public PImage getMiniature03() {return miniature03; }
    public PImage getMiniature04() {return miniature04; }
    @Override
    public void update(Observable o, Object arg)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //titreImage.setText("" + m_model.getValue());
                imageCourante.setImage(m_model.getFile());
                titreImage.setText(m_model.getNomImage());
                miniature01.setImage(m_model.getMiniature01());
                miniature02.setImage(m_model.getMiniature02());
                miniature03.setImage(m_model.getMiniature03());
                miniature04.setImage(m_model.getMiniature04());

            }
        });
    }
    /**
     * On rajoute les elements de l'ui dans le listener
     * @param cont
     */
    public void addListenersToView( CounterController cont )
    {
        btModifier.addActionListener(cont);
        btPrecedent.addActionListener(cont);
        btSuivant.addActionListener(cont);
        miniature01.addActionListener(cont);
        miniature02.addActionListener(cont);
        miniature03.addActionListener(cont);
        miniature04.addActionListener(cont);
    }
    public String getNomImage()
    {
        return this.titreImage.getText();
    }
}

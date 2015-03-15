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
    private JButton btPrecedent = new JButton("\u2190");
    private JTextField titreImage;
    private PImage imageCourante;
    //private PImage miniature02 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    //private PImage miniature02 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    //private PImage miniature02 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    //private PImage miniature02 = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
    private PImage miniature01 = new PImage(new File("D:/GitHub/SwingProto/src/rsc/default.gif"));
    private PImage miniature02 = new PImage(new File("D:/GitHub/SwingProto/src/rsc/default.gif"));
    private PImage miniature03 = new PImage(new File("D:/GitHub/SwingProto/src/rsc/default.gif"));
    private PImage miniature04 = new PImage(new File("D:/GitHub/SwingProto/src/rsc/default.gif"));
    private JPanel imageCourantePanel;
    private JPanel principalePanel;
    private JPanel menu;
    private JPanel miniaturePanel;
    private JButton btSuivant = new JButton("\u2192");
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
        miniaturePanel.setPreferredSize(new Dimension(1079, 201));
        miniaturePanel.setLayout(new FlowLayout());
        miniaturePanel.setBorder(BorderFactory.createTitledBorder("Images suivantes"));

        menu = new JPanel();
        menu.setPreferredSize(new Dimension(1279, 100));
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
        arbrePanel.setPreferredSize(new Dimension(100, 100)); // 200, 670
        arbrePanel.setBorder(BorderFactory.createTitledBorder("Dossier"));

        //Image courante
        //imageCourante = new PImage(new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif"));
        imageCourante = new PImage(new File("D:/GitHub/SwingProto/src/rsc/default.gif"));
        imageCourante.setPreferredSize(new Dimension(100, 100)); //new Dimension(400, 300));
        imageCourante.setBorder(BorderFactory.createTitledBorder("Visualisation de l'image courante"));

        //Titre de l'image courante
        titreImage = new JTextField("Titre de l'image");
        titreImage.setPreferredSize(new Dimension(200, 100));//(new Dimension(679, 49));
        titreImage.setBorder(BorderFactory.createTitledBorder("Nom de l'image"));

        //Les tags de l'image courante
        tagImage = new JTextField("Tag de l'image");
        tagImage.setPreferredSize(new Dimension(200, 100));///(new Dimension(679, 49));
        tagImage.setBorder(BorderFactory.createTitledBorder("Tag de l'image"));

        //La première miniature
        miniature01.setPreferredSize(new Dimension(200, 200));//new Dimension(200, 350));


        //La deuxième image
        miniature02.setPreferredSize(new Dimension(200, 200));//new Dimension(200, 350));

        //La troisième image
        miniature03.setPreferredSize(new Dimension(200, 200));//new Dimension(200, 350));

        //La quatrième image
        miniature04.setPreferredSize(new Dimension(200, 200));//new Dimension(200, 350));

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        //x 12 cases | y 12 cases

        menu.add(gestionImage);
        menu.add(m_textRecherche);
        menu.add(m_choixLangue);
        menu.add(btModifier);

        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0; // % de la place libre que prendra l'objet
        gbc.weighty = 0;// % de la place libre que prendra l'objet
        gbc.gridwidth = GridBagConstraints.REMAINDER; // nombre de case que prendra l'objet
        gbc.gridheight= 2;// nombre de case que prendra l'objet
        principalePanel.add(menu, gbc);
        //---------------------------------------------
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.gridwidth = 3;
        gbc.gridheight= 7;
        principalePanel.add(arbrePanel, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.gridwidth = 6;
        gbc.gridheight= 7;
        principalePanel.add(imageCourante, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 9;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 0.5;
        gbc.gridwidth = 3;
        gbc.gridheight= 3;
        gbc.ipady =0;
        principalePanel.add(titreImage, gbc);
        //---------------------------------------------
        //On positionne la case de départ du composant
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 9;
        gbc.gridy = 5;
        gbc.weightx = 0.3;
        gbc.weighty = 0.5;
        gbc.gridwidth = 3;
        gbc.gridheight= 3;
        gbc.ipady =0;
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
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 0.16;
        gbc.gridheight= 3;
        gbc.gridwidth = 12;
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

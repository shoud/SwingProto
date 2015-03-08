package view;

import javax.swing.*;
import java.util.*;
import model.CounterModel;

/**
 * Classe permetttant de gérer l'affichage graphique
 */
public class GuiView implements Observer {
    private CounterModel m_model;

    //La fenêtre principale
    Fenetre fenetre;


    /**
     * Conttructeur de GuiView
     * Permet de créer l'interface graphique
     *
     * @param m Le CounterModel
     */
    public GuiView(CounterModel m) {
        m_model = m;
        m.addObserver(this);
        SwingUtilities.invokeLater(new Runnable() {
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
        //Creation de la fenêtre
        fenetre = new Fenetre();
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
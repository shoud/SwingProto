package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CounterModel;
import view.GuiView;

/**
 * Classe permettant de gérer l'application
 */
public class CounterController implements ActionListener
{
    //Le model de l'application
    private CounterModel m_model;
    //La vue de l'application
    private GuiView m_view;

    //Variable de l'image courante



    /**
     * Constructeur de la classe CounterController
     * @param m Le CounterModel de l'application
     * @param v Le GuiView de l'application
     */
    public CounterController(CounterModel m, GuiView v)
    {
        m_model = m;
        m_view = v;
        //v.addListenersToView(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        /*if(e.getSource() == m_view.getIncBtn())
            m_model.incValue();
        if(e.getSource() == m_view.getTree())
            m_model.nouveauChemin();
        if(e.getSource() == m_view.getPImage01())
            m_model.ChangerImageCourante(m_view.getPImage01().getFile());
        if(e.getSource() == m_view.getPImage02())
            m_model.ChangerImageCourante(m_view.getPImage02().getFile());
        if(e.getSource() == m_view.getPImage03())
            m_model.ChangerImageCourante(m_view.getPImage03().getFile());
        if(e.getSource() == m_view.getPImage04())
            m_model.ChangerImageCourante(m_view.getPImage04().getFile());*/

    }
}
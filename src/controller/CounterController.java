package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import model.CounterModel;
import model.Path;
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
     * @param m_model Le CounterModel de l'application
     * @param m_view Le GuiView de l'application
     */
    public CounterController(CounterModel m_model, GuiView m_view)
    {
        this.m_model = m_model;
        this.m_view = m_view;
        this.m_view.addListenersToView(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == m_view.getBtModifier())
            m_model.modifier(m_view.getNomImage());
    }
}
package model;

import java.io.File;
import java.util.Observable;

/**
 * Classe permettant de gérer le model
 */
public class CounterModel extends Observable
{

    private int valeur;
    //Le chemin de l'image courante
    private File file;
    private String emplacement;
    /**
     * Constructeur de la classe CounterModel
     */
    public CounterModel()
    {

        valeur = 1;

    }
    public void incValue()
    {
        this.valeur++;
        setChanged();
        notifyObservers();
    }
    public int getValeur()
    {
        return this.valeur;
    }
    /**
     * Permet de mettre à jour l'emplacement des images.
     */
    public void nouveauChemin()
    {

    }
    public void ChangerImageCourante(File file)
    {
        this.file = file;
        System.out.println("COUCOU");
        System.out.println(file);
    }
    public File setImageCourante()
    {
        return this.file;
    }
}
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
    private String imageCourante;
    /**
     * Constructeur de la classe CounterModel
     */
    public CounterModel()
    {
        this.file = null;
    }
    public void FileChanged(File file)
    {
        this.file = file;
        String extension = null;
        String chemin = file.toString();
        int pos = chemin.lastIndexOf('.');
        if (pos > 0 && pos < chemin.length() - 1) {
            extension = chemin.substring(pos + 1).toLowerCase();
        }
        if (extension != null){
            if (extension.equals("jpeg")
                    || extension.equals("jpg")
                    || extension.equals("gif")
                    || extension.equals("png"))
            {
                //On change l'image courante
                imageCourante = chemin;

            }
        }
        else
        {
            //On est dans un dossier
            file = null;
        }
        setChanged();
        notifyObservers();
    }
    public File getFile()
    {
        return this.file;
    }
}
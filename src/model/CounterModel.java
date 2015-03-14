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
    private File file = null;
    private String emplacement;
    private String imageCourante;
    private String nomImage;
    /**
     * Constructeur de la classe CounterModel
     */
    public CounterModel()
    {
        this.file = null;
    }
    public void FileChanged(File file)
    {
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
                nomImage = file.toString();
                this.file = file;

            }
            else
                this.file = null;
        }
        else
        {
            //On est dans un dossier
            this.file = null;
        }
        setChanged();
        notifyObservers();
    }
    public void modifier(String nom)
    {
        if(nom != null)
        {
            String str = file.getPath().toString();
            str = str.substring(0, str.length() - this.nomImage.length());
            this.nomImage = nom;
            file.renameTo(new File(str + this.nomImage));
        }
        setChanged();
        notifyObservers();
    }
    public String getNomImage()
    {
        return this.nomImage;
    }
    public File getFile()
    {
        return this.file;
    }
}
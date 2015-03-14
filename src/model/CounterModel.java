package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
    private String dossier = null;
    private File fileDossier = null;
    private File[] images = null;
    private ArrayList<File> listeMiniatures = new ArrayList<File>();
    private ArrayList<File> listeMiniaturesAffichable = new ArrayList<File>();
    private ArrayList<ArrayList<File>> listePrecedente = new ArrayList<ArrayList<File>>();
    private ArrayList<ArrayList<File>> liste = new ArrayList<ArrayList<File>>();
    private ArrayList<File> listeMiniaturesPrecedente = new ArrayList<File>();
    private Iterator<File> it;
    private int index = 0;
    /**
     * Constructeur de la classe CounterModel
     */
    public CounterModel()
    {
        this.file = null;
    }
    public void FileChanged(File file)
    {
        this.file = null;
        this.imageCourante = null;
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
                dossier = file.getPath().toString();
                dossier = dossier.substring(0, dossier.length() - this.nomImage.length());
            }
            else
            {
                nomImage = file.toString();
                dossier = file.getPath().toString();
                dossier = dossier.substring(0, dossier.length() - this.nomImage.length());
                nomImage = null;
                this.file = null;
            }
        }
        else
        {
            //On est dans un dossier
            dossier = file.getPath().toString();
        }
        this.fileDossier = new File(dossier);
        images = fileDossier.listFiles();
        listeMiniatures.clear();
        for(File f:images)
        {
            extension = null;
            chemin = f.toString();
            pos = chemin.lastIndexOf('.');
            if (pos > 0 && pos < chemin.length() - 1) {
                extension = chemin.substring(pos + 1).toLowerCase();
            }
            if (extension != null) {
                if (extension.equals("jpeg")
                        || extension.equals("jpg")
                        || extension.equals("gif")
                        || extension.equals("png")) {
                    listeMiniatures.add(f);
                }
            }
        }
        if(!listeMiniatures.isEmpty())
        {
            index = 0;
            int compteur = 0;
            liste.clear();
            listeMiniaturesAffichable.clear();
            it = listeMiniatures.iterator();
            while((it.hasNext()))
            {
                listeMiniaturesAffichable.add(it.next());
                compteur++;
                if(compteur > 3 )
                {
                    liste.add((ArrayList<File>) listeMiniaturesAffichable.clone());
                    listeMiniaturesAffichable.clear();
                    compteur = 0;
                }
            }
            if (!listeMiniaturesAffichable.isEmpty())
                liste.add((ArrayList<File>) listeMiniaturesAffichable.clone());
            listeMiniaturesAffichable.clear();
        }
        listePrecedente.clear();
        setChanged();
        notifyObservers();
    }
    public void modifier(String nom)
    {
        if(nom != null)
        {
            this.nomImage = nom;
            file.renameTo(new File(dossier + this.nomImage));
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
    public File getMiniature01()
    {
        if(!liste.isEmpty())
            if(liste.get(index).size() >= 1)
                return this.liste.get(index).get(0);

        return new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
    }
    public File getMiniature02()
    {
        if(!liste.isEmpty())
            if(liste.get(index).size() > 1)
                return this.liste.get(index).get(1);
        return new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
    }
    public File getMiniature03()
    {
        if(!liste.isEmpty())
            if(liste.get(index).size() > 2)
                return this.liste.get(index).get(2);
        return new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
    }
    public File getMiniature04()
    {
        if(!liste.isEmpty())
            if(liste.get(index).size() > 3)
                return this.liste.get(index).get(3);
        return new File("/home/thomas/IdeaProjects/SwingProto/src/rsc/default.gif");
    }
    public void setImageCourante(int index)
    {
        if(!this.liste.isEmpty())
            if (this.liste.get(this.index).size() > index )
            {
                String extension = null;
                this.file = this.liste.get(this.index).get(index);
                String chemin = this.file.toString();
                int pos = chemin.lastIndexOf('/');
                if (pos > 0 && pos < chemin.length() - 1) {
                    extension = chemin.substring(pos + 1).toLowerCase();
                }
                if (extension != null)
                    this.nomImage = extension;
                setChanged();
                notifyObservers();
            }
    }
    public void precedent()
    {
        if(index > 0)
        {
            this.index--;
            setChanged();
            notifyObservers();
        }
    }
    public void suivant()
    {
        if(!liste.isEmpty())
        {
            if(liste.size()-1 > index )
            {
                this.index++;
                setChanged();
                notifyObservers();
            }
        }
    }
}
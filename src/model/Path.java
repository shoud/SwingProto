package model;
import java.util.Observable;
import java.io.File;

public class Path extends Observable {

    private String chemin;
    private static String selected;

    public Path(String chemin) {
        this.chemin = chemin;
        selected = null;
    }

    public String getChemin() {
        return chemin;
    }

    void setChemin(String chemin) {
        this.chemin = chemin;
    }

    /*public void set(File f) {
        if (f == null)
            return;
        selected = null;
        if(!f.isDirectory()) {
            if(ImagePanel.isImage(f.getName()))
                selected = f.getName();
            f = f.getParentFile();
        }
        setChemin(f.getAbsolutePath());
        setChanged();
        notifyObservers("path");
    }*/

    public static boolean isSelected(String nom) {
        return nom.equals(selected);
    }
}
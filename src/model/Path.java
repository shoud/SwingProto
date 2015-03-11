package model;
import java.awt.*;
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
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }



}
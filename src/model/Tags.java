package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Tags {

    //Le nom de la base de données
    public static final String dbName = "jdbc:sqlite:tags.db";
    //Le nom de la table
    public static final String tableName = "tagsImage";

    /**
     * Fonction permettant de rajouter ou de mettre à jour les tags d'une image
     * @param file le chemin de l'image
     * @param tags Les tags de l'image
     */
    public static void setTags(String file, String tags)
    {
        try
        {
            Connection connection = GestionBD.getConnection();
            if(connection != null)
            {
                PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO " + tableName + " (file, tags)" + " VALUES(?, ?)");
                statement.setQueryTimeout(15);
                statement.setString(1, file);
                statement.setString(2,tags);
                statement.executeUpdate();
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    public static void deleteTags(String file)
    {
        try
        {
            Connection connection = GestionBD.getConnection();
            if(connection != null)
            {
                PreparedStatement statement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE file = ?");
                statement.setString(1,file);
                statement.setQueryTimeout(15);
                statement.executeQuery();
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    /**
     * Fonction permettant de renvoyer les tags d'une images grâce à son chemin sur le disque
     * @param file l'emplacement de l'image
     * @return Les tags de l'image
     */
    public static String getTags(String file)
    {
        String tags = null;
        try
        {
            Connection connection = GestionBD.getConnection();
            if(connection != null)
            {
                PreparedStatement statement = connection.prepareStatement("SELECT tags FROM " + tableName + " WHERE file = ?");
                statement.setString(1,file);
                statement.setQueryTimeout(15);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next())
                    tags = resultSet.getString("tags");
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return tags;
    }
    public static ArrayList<String> recherche(String tags)
    {
        ArrayList<String> resultatFile = new ArrayList<String>();
        try
        {
            Connection connection = GestionBD.getConnection();
            if(connection != null)
            {
                PreparedStatement statement = connection.prepareStatement("SELECT file FROM " + tableName + " WHERE tags LIKE ? COLLATE nocase");
                statement.setString(1, "%" + tags + "%");
                statement.setQueryTimeout(15);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                    resultatFile.add(resultSet.getString("file"));
            }


        }catch (Exception e)
        {
            System.err.println(e.getMessage());
            resultatFile = null;
        }
        return resultatFile;
    }
}


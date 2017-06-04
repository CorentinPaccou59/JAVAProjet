
import java.sql.*;
import java.util.Vector;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */
public class PersistenceSQL {
    private String ipBase;
    private int port;
    private String nomBDD;
    private Connection conn;
    private ResultSet resultat;
    private Statement etat;
    
    public PersistenceSQL(){
        //**** Connexion à la bdd ****
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/ppe";
            String user = "root";
            String passwd = "root";

            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");         
         
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public Object ChargerDepuisBase(String id, String nomClasse) throws Exception{
        Object objet = null;
        switch(nomClasse){
            case("Produit"):
                String rProd = "select * from lot, variete, typeproduit where id_Lot='"+id+"' AND lot.id_variete = variete.id_variete AND lot.id_typeProduit = typeproduit.id_typeProduit";
                etat = conn.createStatement();
                resultat = etat.executeQuery(rProd);
                
                while(resultat.next()){
                    objet = new Produit(resultat.getString("id_Lot"), resultat.getString("libelle"), resultat.getString("libelle_typeProduit"), resultat.getDouble("calibre"));
                }
                break;
        }
        return objet;
    }
    
    public void ChargerListe(JComboBox liste, String nomClasse) throws Exception{
        switch(nomClasse){
            case("Produit"):
                String rProd = "select id_Lot from lot";
                etat = conn.createStatement();
                resultat = etat.executeQuery(rProd);
        
                while(resultat.next()){
                    liste.addItem(resultat.getString("id_Lot"));
                }
                break;
        }
    }
    
    public boolean connexion(String identifiant, String motDePasse) throws Exception
    {
        boolean existe = false;
            String rConn = "select * from connexion where login = '"+identifiant+"' and mdp = '"+motDePasse+"'";
            etat = conn.createStatement();
            resultat = etat.executeQuery(rConn);
                
            while(resultat.next()){
                existe = true;
            }
        return existe;
    }
}

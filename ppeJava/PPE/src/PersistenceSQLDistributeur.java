
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class PersistenceSQLDistributeur {
    private String ipBase;
    private int port;
    private String nomBDD;
    private Connection conn;
    private ResultSet resultat;
    private Statement etat;
    
    public PersistenceSQLDistributeur(){
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
    
    public Object ChargerDepuisBaseDistributeur(String id, String nomClasse) throws Exception{
        Object objet = null;
        boolean objetExistant = false;

        switch(nomClasse){
            case("Distributeur"):
            
                Distributeur distributeur = null;
                    String rDistrib = "select * from distributeurjava where idDistributeur = '"+id+"'";
                    resultat = etat.executeQuery(rDistrib);

			while(resultat.next())
			{			
                            distributeur = new Distributeur(resultat.getString("idDistributeur"), resultat.getString("nomDistributeur"));
                            objetExistant = true;
	    		}
			if(objetExistant)
			{
                            String rDistributeur = "select * from distributeurjava as d, commande as c, lot as l, variete as v, typeproduit as tp where d.idDistributeur = '"+distributeur.getId()+"' and d.idDistributeur = c.idDistributeur and c.id_Lot = l.id_Lot and l.id_variete = v.id_variete and l.id_typeProduit = tp.id_typeProduit";
                            resultat = etat.executeQuery(rDistributeur);
                            Commande lesCommandes = null;
                            while(resultat.next())
                            {
				lesCommandes = new Commande(resultat.getInt("numCommande"), resultat.getInt("quantite"), resultat.getString("conditionnement"), resultat.getString("date_Conditionnement"), resultat.getString("dateEnvoi"), resultat.getString("idDistributeur"));
                                Produit unProduit = new Produit(resultat.getString("id_Lot"), resultat.getString("libelle"), resultat.getString("libelle_typeProduit"), resultat.getDouble("calibre"));
                                lesCommandes.setLeProduit(unProduit);
                                distributeur.getLesCommandes().add(lesCommandes);
                            }
                            
                            objet = distributeur;
			}
                        else
	    		{
                            objet = null;
	    		}
            break;
        }
        return objet;
    }
    
    public void ChargerListeDistributeur(JComboBox liste, String nomClasse) throws Exception{
        switch(nomClasse){
            case("Distributeur"):
                String rDistrib = "select * from distributeurjava";
                etat = conn.createStatement();
                resultat = etat.executeQuery(rDistrib);
        
                while(resultat.next()){
                    liste.addItem(resultat.getString("idDistributeur"));
                }
                break;
        }
    }
}


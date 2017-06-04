
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
public class PersistenceSQLCommande {
    private String ipBase;
    private int port;
    private String nomBDD;
    private Connection conn;
    private ResultSet resultat;
    private Statement etat;
    
    public PersistenceSQLCommande(){
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
    
    public Object ChargerDepuisBaseCommande(String id, String nomClasse) throws Exception{
        Object objet = null;
        boolean objetExistant = false;

        switch(nomClasse){
            case("Commande"):
            
                Commande commande = null;
                    String rComm = "select * from commande where numCommande = '"+id+"'";
                    resultat = etat.executeQuery(rComm);

			while(resultat.next())
			{			
                            commande = new Commande(resultat.getInt("numCommande"), resultat.getInt("quantite"), resultat.getString("conditionnement"), resultat.getString("date_conditionnement"),resultat.getString("dateEnvoi"), resultat.getString("idDistributeur"));
                            objetExistant = true;
	    		}
			if(objetExistant)
			{
                            String rProduit = "select * from commande as c, lot as l, variete as v, typeproduit as tp where c.numCommande = '"+commande.getId()+"' and l.id_Lot = c.id_Lot and l.id_variete = v.id_variete and l.id_typeProduit = tp.id_typeProduit";
                            resultat = etat.executeQuery(rProduit);
                            Produit leProduit = null;
                            while(resultat.next())
                            {
				leProduit = new Produit(resultat.getString("id_Lot"),resultat.getString("libelle"),resultat.getString("libelle_typeProduit"),resultat.getDouble("calibre"));
                            }
                            commande.setLeProduit(leProduit);
                            objet = commande;
			}
                        else
	    		{
                            objet = null;
	    		}
            break;
        }
        return objet;
    }
    
    public void ChargerListeCommande(JComboBox liste, String nomClasse) throws Exception{
        switch(nomClasse){
            case("Commande"):
                String rComm = "select numCommande from commande";
                etat = conn.createStatement();
                resultat = etat.executeQuery(rComm);
        
                while(resultat.next()){
                    liste.addItem(resultat.getString("numCommande"));
                }
                break;
        }
    }
}

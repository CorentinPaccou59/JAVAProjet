
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */
public class Distributeur {
    private String id, nom;
    private ArrayList <Commande> lesCommandes;
    
    //**** Constructeur ****
    public Distributeur(String unId, String unNom){
        this.id = unId;
        this.nom = unNom;
        lesCommandes = new ArrayList();
    }
    
    //**** Getteurs ****
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList <Commande> getLesCommandes() {
        return lesCommandes;
    }
    
    //**** Getteurs qui renvoie les commandes en cours quand la date d'envoi est null****
    public ArrayList <Commande> getCommandeEnCours(){
        ArrayList <Commande> commandeEnCours = new ArrayList();
        for (Commande c : lesCommandes){
            if(c.getDateEnvoi() == null){
                commandeEnCours.add(c);
            }
        }
        return commandeEnCours;
    }
    
    //**** Setteurs ****
    public void setLesCommandes(ArrayList <Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }  
}

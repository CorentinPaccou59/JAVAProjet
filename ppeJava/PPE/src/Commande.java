import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */
public class Commande {
    private int id, quantite;
    private Produit leProduit;
    private String conditionnement;
    private String dateConditionnement, dateEnvoi;
    private String idDistributeur;
    
    //**** Constructeur ****
    public Commande(int unId, int uneQuantite, String unConditionnement, String uneDateConditionnement, String uneDateEnvoi, String unDistributeur){
        this.id = unId;
        this.quantite = uneQuantite;
        this.conditionnement = unConditionnement;
        this.dateConditionnement = uneDateConditionnement;
        this.dateEnvoi = uneDateEnvoi;
        this.idDistributeur = unDistributeur;
    }
    
    //**** Getteurs ****
    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }
    
    public String getConditionnement() {
        return conditionnement;
    }

    public String getDateConditionnement() {
        return dateConditionnement;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }   
    public Produit getLeProduit()
    {
        return this.leProduit;
    }

    //**** Setteurs ****
    public void setLeProduit(Produit produit)
    {
        this.leProduit = produit;
    } 
    public String getIdDistributeur()
    {
        return this.idDistributeur;
    }
    public void setIdDistributeur(String distributeur)
    {
        this.idDistributeur = distributeur;
    }
}



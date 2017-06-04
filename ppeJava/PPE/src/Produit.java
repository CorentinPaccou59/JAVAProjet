/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */
public class Produit {
    private String id, variete, type;
    private double calibre;
    
    //**** Constructeur ****
    public Produit(String unId, String uneVariete, String unType, double unCalibre){
        this.id = unId;
        this.variete = uneVariete;
        this.type = unType;
        this.calibre = unCalibre;
    }
    
    //**** Getteurs ****
    public String getId(){
        return id;
    }
    
    public String getVariete(){
        return variete;
    }
    
    public String getType(){
        return type;
    }
    
    public double getCalibre(){
        return calibre;
    }
}

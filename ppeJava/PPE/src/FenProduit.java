
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */

//**** Fenêtre qui s'ouvre quand on clique sur le bouton Produit ****
public class FenProduit {
    private JFrame fenProduit;
    private JPanel panelFenProduit;
    private JComboBox listeProduit;
    private JButton chargeProduit;
    private PersistenceSQL persistenceProduit;
    private JLabel varieteProduit;
    private JLabel typeProduit;
    private JLabel calibreProduit;
    private JLabel detailProduit;
    
    //**** Constructeur ****
    public FenProduit(){
        //**** On créé une fenêtre avec son titre ****
        fenProduit = new JFrame("Produit - AGRUR");
        //**** On appelle la méthode InitialisationComposant() ****
        InitialisationComposant();
        //**** On définit la taille (largeur, hauteur) ****
        fenProduit.setSize(800, 500);
        //**** On définit sa position (null = au centre) ****
        fenProduit.setLocationRelativeTo(null);
        //**** On dit si la fenêtre est redimensionnable (false = non) ****
        fenProduit.setResizable(false);
        //**** On rend la fenêtre visible ****
        fenProduit.setVisible(true);
        InitialisationPersistence();
    }
    
    public void InitialisationComposant(){
        //**** On créé un panel ****
        panelFenProduit = new JPanel();
        panelFenProduit.setLayout(null);
        
        //**** Ajout d'une combobox ****
        listeProduit = new JComboBox();
        listeProduit.setBounds(230, 80, 150, 20);
        
        //**** Ajout des labels****
        detailProduit = new JLabel();
        detailProduit.setBounds(230, 150, 400, 20);
        detailProduit.setForeground(Color.red);
        varieteProduit = new JLabel();
        varieteProduit.setBounds(230, 170, 200, 20);
        varieteProduit.setForeground(Color.gray);
        typeProduit = new JLabel();
        typeProduit.setBounds(230, 200, 250, 20);
        typeProduit.setForeground(Color.gray);
        calibreProduit = new JLabel();
        calibreProduit.setBounds(230, 230, 200, 20);
        calibreProduit.setForeground(Color.gray);
        
        //**** Ajout du bouton ****
        //**** Action listener qui permettra de charger le produit concerné ****
        chargeProduit = new JButton ("Charger le produit");
        chargeProduit.setBounds(400, 70, 150, 40);
        chargeProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Produit afficheProduit = (Produit)persistenceProduit.ChargerDepuisBase(listeProduit.getSelectedItem().toString(), "Produit");
                    detailProduit.setText("----------- DETAILS DU PRODUIT "+afficheProduit.getId()+" -----------");
                    varieteProduit.setText("Variété du produit : "+afficheProduit.getVariete());
                    typeProduit.setText("Type du produit : "+afficheProduit.getType());
                    calibreProduit.setText("Calibre du produit : "+afficheProduit.getCalibre());
                }catch(Exception ex){
                    
                }
            }
        });
        
        //**** Ajout de tout au panel ****
        panelFenProduit.add(listeProduit);
        panelFenProduit.add(chargeProduit);
        panelFenProduit.add(varieteProduit);
        panelFenProduit.add(typeProduit);
        panelFenProduit.add(calibreProduit);
        panelFenProduit.add(detailProduit);
        
        //**** On ajoute le panel à la fenêtre Produit ****
        fenProduit.setContentPane(panelFenProduit);
    }
    
    public void InitialisationPersistence(){
        persistenceProduit = new PersistenceSQL();
        try{
            persistenceProduit.ChargerListe(listeProduit, "Produit");
        }catch(Exception e){
            
        } 
    }
}

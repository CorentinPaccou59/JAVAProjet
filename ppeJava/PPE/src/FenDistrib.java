import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

//**** Fenêtre qui s'ouvre quand on clique sur le bouton produit ****
public class FenDistrib {
    private JFrame fenDistrib;
    private JPanel PanelFenDistrib;
    private JComboBox listeDistrib;
    private JComboBox listeCommande;
    private JButton chargeDistrib;
    private JButton chargeXML;
    private JLabel nomDistrib;
    private JLabel quantiteCommande;
    private JLabel conditionnementCommande;
    private JLabel dateConditionnementCommande;
    private JLabel dateEnvoiCommande;
    private JLabel varieteProduit;
    private JLabel typeProduit;
    private JLabel calibreProduit;
    private JLabel produitConcerne;
    private JLabel detailCommande;
    private PersistenceSQLDistributeur persistenceDistrib;
    private Distributeur afficheDistrib;
    
    //**** Constructeur ****
    public FenDistrib(){
        //**** On créé une fenêtre avec son titre ****
        fenDistrib = new JFrame("Distributeur - AGRUR");
        //**** On appelle la méthode InitialisationComposant() ****
        InitialisationComposant();
        //**** On définit la taille (largeur, hauteur) ****
        fenDistrib.setSize(800, 500);
        //**** On définit sa position (null = au centre) ****
        fenDistrib.setLocationRelativeTo(null);
        //**** On dit si la fenêtre est redimensionnable (false = non) ****
        fenDistrib.setResizable(false);
        //**** On rend la fenêtre visible ****
        fenDistrib.setVisible(true);
        InitialisationPersistence();
        
    }
    
    public void InitialisationComposant(){
        //**** On créé un panel ****
        PanelFenDistrib = new JPanel();
        PanelFenDistrib.setLayout(null);
        
        //**** Ajout d'une combobox ****
        listeDistrib = new JComboBox();
        listeDistrib.setBounds(230, 80, 150, 20);

        //**** Ajout des labels ****
        nomDistrib = new JLabel();
        nomDistrib.setBounds(260, 140, 350, 20);
        nomDistrib.setForeground(Color.gray);
        detailCommande = new JLabel();
        detailCommande.setBounds(160, 170, 500, 20);
        detailCommande.setForeground(Color.red);
        quantiteCommande = new JLabel();
        quantiteCommande.setBounds(260, 190, 350, 20);
        quantiteCommande.setForeground(Color.gray);
        conditionnementCommande = new JLabel();
        conditionnementCommande.setBounds(260, 220, 350, 20);
        conditionnementCommande.setForeground(Color.gray);
        dateConditionnementCommande = new JLabel();
        dateConditionnementCommande.setBounds(260, 250, 400, 20);
        dateConditionnementCommande.setForeground(Color.gray);
        dateEnvoiCommande = new JLabel();
        dateEnvoiCommande.setBounds(260, 280, 400, 20);
        dateEnvoiCommande.setForeground(Color.gray);
        produitConcerne = new JLabel();
        produitConcerne.setBounds(160, 310, 500, 20);
        produitConcerne.setForeground(Color.red);
        varieteProduit = new JLabel();
        varieteProduit.setBounds(260, 330, 400, 20);
        varieteProduit.setForeground(Color.gray);
        typeProduit = new JLabel();
        typeProduit.setBounds(260, 360, 400, 20);
        typeProduit.setForeground(Color.gray);
        calibreProduit = new JLabel();
        calibreProduit.setBounds(260, 390, 400, 20);
        calibreProduit.setForeground(Color.gray);
        
        //**** Création du bouton ****
        //**** Appel à action listener qui permettra de charger les informations du distributeur que l'on désire ****
        chargeDistrib = new JButton ("Charger le distributeur");
        chargeDistrib.setBounds(400, 70, 200, 40);
        chargeDistrib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    afficheDistrib = (Distributeur)persistenceDistrib.ChargerDepuisBaseDistributeur(listeDistrib.getSelectedItem().toString(), "Distributeur");
                    System.out.println(afficheDistrib.getNom());
                    nomDistrib.setText("Nom du distributeur : "+afficheDistrib.getNom());
                    if(listeCommande.getItemCount()>0){
                        listeCommande.removeAllItems();        
                    }
                    if(afficheDistrib.getLesCommandes().size()>0){
                        for(Commande commande: afficheDistrib.getLesCommandes()){  
                        listeCommande.addItem(commande.getId());
                        } 
                    }
                    else{
                        detailCommande.setText("");
                        quantiteCommande.setText("");
                        conditionnementCommande.setText("");
                        dateConditionnementCommande.setText("");
                        produitConcerne.setText("");
                        dateEnvoiCommande.setText("");
                        varieteProduit.setText("");
                        typeProduit.setText("");
                        calibreProduit.setText("");
                        JOptionPane.showMessageDialog(fenDistrib, "Aucunes commandes pour le distributeur "+afficheDistrib.getId(),"Distributeur - AGRUR",JOptionPane.INFORMATION_MESSAGE);

                        }     
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        
        listeCommande = new JComboBox();
        listeCommande.setBounds(230, 110, 150, 20);
        listeCommande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(listeCommande.getItemCount()>0){
                        for(Commande commande : afficheDistrib.getLesCommandes()){
                            if(commande.getId() == (Integer.parseInt(listeCommande.getSelectedItem().toString()))){
                                detailCommande.setText("--------- DETAILS DE LA COMMANDE "+commande.getId()+" DU DISTRIBUTEUR "+afficheDistrib.getId()+" ---------");
                                quantiteCommande.setText("Quantité de la commande : "+commande.getQuantite());
                                conditionnementCommande.setText("Conditionnement de la commande : "+commande.getQuantite());
                                dateConditionnementCommande.setText("Date de conditionnement de la commande : "+commande.getDateConditionnement());
                                produitConcerne.setText("------- PRODUIT "+commande.getLeProduit().getId()+" DE LA COMMANDE "+commande.getId()+" ET DU DISTRIBUTEUR "+afficheDistrib.getId()+" -------");
                                dateEnvoiCommande.setText("Date d'envoi de la commande : "+commande.getDateEnvoi());
                                varieteProduit.setText("Variété du produit concerné : "+commande.getLeProduit().getVariete());
                                typeProduit.setText("Type du produit concerné : "+commande.getLeProduit().getType());
                                calibreProduit.setText("Calibre du produit concerné : "+commande.getLeProduit().getCalibre());
                            }
                        }
                    }  
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        
        //**** Chargement du XML en respectant le cahier des charges ****
        chargeXML = new JButton ("Charger le XML");
        chargeXML.setBounds(550, 400, 200, 40);
        chargeXML.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try{    
                BufferedWriter ecrireXML;
                File fichier;
                fichier = new File(afficheDistrib.getNom()+".xml");
                ecrireXML = new BufferedWriter(new FileWriter(fichier));
                ecrireXML.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                ecrireXML.newLine();
                ecrireXML.write("<commandes idDistributeur=\""+afficheDistrib.getId()+"\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
                ecrireXML.newLine();
                for(Commande comm: afficheDistrib.getCommandeEnCours()){
                    ecrireXML.write("<commande id=\""+comm.getId()+"\">");
                    ecrireXML.newLine();
                    ecrireXML.write("<produit variete=\""+comm.getLeProduit().getVariete()+"\" type=\""+comm.getLeProduit().getType()+"\" calibre=\""+comm.getLeProduit().getCalibre()+"\" />");
                    ecrireXML.newLine();
                    ecrireXML.write("<conditionnement type=\""+comm.getConditionnement()+"\" />");
                    ecrireXML.newLine();
                    ecrireXML.write("<quantite>"+comm.getQuantite()+"</quantite>");
                    ecrireXML.newLine();
                    ecrireXML.write("<date_conditionnement>"+comm.getDateConditionnement()+"</date_conditionnement>");
                    ecrireXML.newLine();
                    ecrireXML.write("<date_envoi>"+comm.getDateEnvoi()+"</date_envoi>");
                    ecrireXML.newLine();
                    ecrireXML.write("</commande>");
                }
                ecrireXML.newLine();
                ecrireXML.write("</commandes>");
                ecrireXML.close();
            }catch(Exception exe){
                
            }
            }
        });
        
        //**** Ajout de tout au panel ****
        PanelFenDistrib.add(chargeXML);
        PanelFenDistrib.add(nomDistrib);
        PanelFenDistrib.add(detailCommande);
        PanelFenDistrib.add(quantiteCommande);
        PanelFenDistrib.add(conditionnementCommande);
        PanelFenDistrib.add(dateConditionnementCommande);
        PanelFenDistrib.add(dateEnvoiCommande);
        PanelFenDistrib.add(produitConcerne);
        PanelFenDistrib.add(varieteProduit);
        PanelFenDistrib.add(typeProduit);
        PanelFenDistrib.add(calibreProduit);
        PanelFenDistrib.add(listeDistrib);
        PanelFenDistrib.add(listeCommande);
        PanelFenDistrib.add(chargeDistrib);
        
        //**** On ajoute le panel à la fenêtre fenDistrib ****
        fenDistrib.setContentPane(PanelFenDistrib);
        
    }
    
    public void InitialisationPersistence(){
        persistenceDistrib = new PersistenceSQLDistributeur();
        try{
            persistenceDistrib.ChargerListeDistributeur(listeDistrib, "Distributeur");
        }catch(Exception e){
            
        } 
    }
}

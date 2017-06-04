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

//**** Fenêtre qui s'ouvre quand on clique sur le bouton Commande ****
public class FenCommande {
    private JFrame fenCommande;
    private JPanel panelFenCommande;
    private JComboBox listeCommande;
    private JButton chargeCommande;
    private PersistenceSQLCommande persistenceCommande;
    private JLabel quantiteCommande;
    private JLabel conditionnementCommande;
    private JLabel dateConditionnementCommande;
    private JLabel dateEnvoiCommande;
    private JLabel varieteProduit;
    private JLabel typeProduit;
    private JLabel calibreProduit;
    private JLabel produitConcerne;
    private JLabel detailCommande;
    
    //**** Constructeur ****
    public FenCommande(){
        //**** On créé une fenêtre avec son titre ****
        fenCommande = new JFrame("Commande - AGRUR");
        //**** On appelle la méthode InitialisationComposant() ****
        InitialisationComposant();
        //**** On définit la taille (largeur, hauteur) ****
        fenCommande.setSize(800, 500);
        //**** On définit sa position (null = au centre) ****
        fenCommande.setLocationRelativeTo(null);
        //**** On dit si la fenêtre est redimensionnable (false = non) ****
        fenCommande.setResizable(false);
        //**** On rend la fenêtre visible ****
        fenCommande.setVisible(true);
        InitialisationPersistence();
    }
    
    public void InitialisationComposant(){
        //**** On créé un panel ****
        panelFenCommande = new JPanel();
        //**** On fait setLayout pour pouvoir placer où l'on veut les composants ****
        panelFenCommande.setLayout(null);
        
        //**** Ajout d'une combobox ****
        listeCommande = new JComboBox();
        listeCommande.setBounds(230, 80, 150, 20);
        
        //**** Ajout de tous les labels ****
        produitConcerne = new JLabel();
        produitConcerne.setBounds(240, 130, 400, 20);
        produitConcerne.setForeground(Color.red);
        varieteProduit = new JLabel();
        varieteProduit.setBounds(230, 150, 400, 20);
        varieteProduit.setForeground(Color.gray);
        typeProduit = new JLabel();
        typeProduit.setBounds(230, 180, 400, 20);
        typeProduit.setForeground(Color.gray);
        calibreProduit = new JLabel();
        calibreProduit.setBounds(230, 210, 400, 20);
        calibreProduit.setForeground(Color.gray);
        detailCommande = new JLabel();
        detailCommande.setBounds(240, 250, 400, 20);
        detailCommande.setForeground(Color.red);
        quantiteCommande = new JLabel();
        quantiteCommande.setBounds(230, 270, 400, 20);
        quantiteCommande.setForeground(Color.gray);
        conditionnementCommande = new JLabel();
        conditionnementCommande.setBounds(230, 300, 400, 20);
        conditionnementCommande.setForeground(Color.gray);
        dateConditionnementCommande = new JLabel();
        dateConditionnementCommande.setBounds(230, 330, 400, 20);
        dateConditionnementCommande.setForeground(Color.gray);
        dateEnvoiCommande = new JLabel();
        dateEnvoiCommande.setBounds(230, 360, 400, 20);
        dateEnvoiCommande.setForeground(Color.gray);
        
        //**** Ajout du bouton pour charger la commande ****
        chargeCommande = new JButton ("Charger la commande");
        chargeCommande.setBounds(400, 70, 200, 40);
        //**** Ajout de l'action listener qui permettra de charger la classe persistence commande pour afficher les infos de la commande que l'on désire ****
        chargeCommande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Commande afficheCommande = (Commande)persistenceCommande.ChargerDepuisBaseCommande(listeCommande.getSelectedItem().toString(), "Commande");
                    produitConcerne.setText("---- PRODUIT CONCERNE PAR LA COMMANDE "+afficheCommande.getId()+" ----");
                    varieteProduit.setText("Variété du produit concerné : "+afficheCommande.getLeProduit().getVariete());
                    typeProduit.setText("Type du produit concerné : "+afficheCommande.getLeProduit().getType());
                    calibreProduit.setText("Calibre du produit concerné : "+afficheCommande.getLeProduit().getCalibre());
                    detailCommande.setText("--------- DETAILS DE LA COMMANDE "+afficheCommande.getId()+" ---------");
                    quantiteCommande.setText("Quantité de la commande : "+afficheCommande.getQuantite());
                    conditionnementCommande.setText("Conditionnement de la commande : "+afficheCommande.getConditionnement());
                    dateConditionnementCommande.setText("Date de conditionnement de la commande : "+afficheCommande.getDateConditionnement());
                    dateEnvoiCommande.setText("Date d'envoi de la commande : "+afficheCommande.getDateEnvoi());
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        
        //**** Ajout de tout au panel ****
        panelFenCommande.add(quantiteCommande);
        panelFenCommande.add(conditionnementCommande);
        panelFenCommande.add(dateConditionnementCommande);
        panelFenCommande.add(dateEnvoiCommande);
        panelFenCommande.add(varieteProduit);
        panelFenCommande.add(typeProduit);
        panelFenCommande.add(calibreProduit);
        panelFenCommande.add(chargeCommande);
        panelFenCommande.add(produitConcerne);
        panelFenCommande.add(detailCommande);
        panelFenCommande.add(listeCommande);
        
        //**** On ajoute le panel à la fenêtre ****
        fenCommande.setContentPane(panelFenCommande);
    }
    
    public void InitialisationPersistence(){
        persistenceCommande = new PersistenceSQLCommande();
        try{
            persistenceCommande.ChargerListeCommande(listeCommande, "Commande");
        }catch(Exception e){
            
        } 
    }
}

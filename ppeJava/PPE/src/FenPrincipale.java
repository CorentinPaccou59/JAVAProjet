
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

//**** Fenêtre qui s'ouvre quand on lance le programme ****
public class FenPrincipale {
    private JFrame fenPrincipale;
    private JButton jDistrib, jCommande, jProduit;
    private JPanel PanelFenPrincipale;
    
    //**** Constructeur ****
    public FenPrincipale(){
        //**** On créé une fenêtre principale avec son titre ****
        fenPrincipale = new JFrame("Gestion des commandes - AGRUR");
        //**** On appelle la méthode InitialisationComposant() ****
        InitialisationComposant();
        //**** On définit la taille (largeur, hauteur) ****
        fenPrincipale.setSize(800, 500);
        //**** On définit sa position (null = au centre) ****
        fenPrincipale.setLocationRelativeTo(null);
        //**** On définit la fermeture de la fenêtre par le clique sur la croix rouge ****
        fenPrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //**** On dit si la fenêtre est redimensionnable (false = non) ****
        fenPrincipale.setResizable(false);
        //**** On rend la fenêtre visible ****
        fenPrincipale.setVisible(true);  
    }
    
    public void InitialisationComposant(){
        //**** On créé un panel ****
        PanelFenPrincipale = new JPanel();
        PanelFenPrincipale.setLayout(null);
        //**** On créé trois nouveaux boutons avec chacun leur titre ****
        jDistrib = new JButton("Distributeur");
        jCommande = new JButton("Commande");
        jProduit = new JButton("Produit");
        
        //**** On définit pour chaque boutons, sa position et la taille de ce dernier ****
        //**** (x, y, largeur, hauteur) ****
        jDistrib.setBounds(80, 150, 200, 40);
        jCommande.setBounds(290, 150, 200, 40);
        jProduit.setBounds(500, 150, 200, 40);
        
        //**** On ajoute chaque boutons au panel ****
        PanelFenPrincipale.add(jDistrib);
        PanelFenPrincipale.add(jCommande);
        PanelFenPrincipale.add(jProduit);
        //**** On cjoute le panel à notre JFrame soit la fenêtre principale ****
        fenPrincipale.setContentPane(PanelFenPrincipale);
        
        //**** On créé un ActionListener pour que lorsque l'on clique sur le bouton Produit ****
        //**** La fenêtre dont l'objet est FenProduit s'ouvre ****
        jProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenProduit fenProduit = new FenProduit();
                //fenPrincipale.dispose();
            }
        });
        
        //**** On créé un ActionListener pour que lorsque l'on clique sur le bouton Commande ****
        //**** La fenêtre dont l'objet est FenCommande s'ouvre ****
        jCommande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenCommande fenProduit = new FenCommande();
                //fenPrincipale.dispose();
            }
        });
        
        //**** On créé un ActionListener pour que lorsque l'on clique sur le bouton Distributeur ****
        //**** La fenêtre dont l'objet est FenDistrib s'ouvre ****
        jDistrib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenDistrib fenDistrib = new FenDistrib();
                //fenPrincipale.dispose();
            }
        });
        
    }
   
    
    
}

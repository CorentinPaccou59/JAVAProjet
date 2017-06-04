
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corentin
 */
public class FenConnexion {
    private JFrame fenConnexion;
    private JPanel panelFenConnexion;
    private JLabel id;
    private JLabel mdp;
    private JTextField valeurId;
    private JTextField valeurMdp;
    private JButton boutonConnexion;
    private PersistenceSQL sql;
    
    //**** Constructeur ****
    public FenConnexion(){
        //**** On créé une fenêtre avec son titre ****
        fenConnexion = new JFrame("Connexion - AGRUR");
        //**** On appelle la méthode InitialisationComposant() ****
        InitialisationComposant();
        sql = new PersistenceSQL();
        //**** On définit la taille (largeur, hauteur) ****
        fenConnexion.setSize(500, 300);
        //**** On définit sa position (null = au centre) ****
        fenConnexion.setLocationRelativeTo(null);
        //**** On dit si la fenêtre est redimensionnable (false = non) ****
        fenConnexion.setResizable(false);
        //**** On rend la fenêtre visible ****
        fenConnexion.setVisible(true);
        
    }
    
    public void InitialisationComposant(){
        //**** On créé un panel ****
        panelFenConnexion = new JPanel();
        panelFenConnexion.setLayout(null);
        
        //**** On créé les labels ****
        id = new JLabel();
        id.setBounds(150, 60, 150, 20);
        id.setText("Nom d'utilisateur :");
        valeurId = new JTextField();
        valeurId.setBounds(150, 80, 200, 20);
        mdp = new JLabel();
        mdp.setBounds(150, 100, 150, 20);
        mdp.setText("Mot de passe :");
        valeurMdp = new JTextField();
        valeurMdp.setBounds(150, 120, 200, 20);

        //**** Création du bouton ****
        boutonConnexion = new JButton("Connexion");
        boutonConnexion.setBounds(180, 180, 150, 20);

        //**** Ajout de tout au panel ****
        panelFenConnexion.add(id);
        panelFenConnexion.add(mdp);
        panelFenConnexion.add(valeurId);
        panelFenConnexion.add(valeurMdp);
        panelFenConnexion.add(boutonConnexion);
        
        //**** On ajoute le panel à la fenêtre fenDistrib ****
        fenConnexion.setContentPane(panelFenConnexion);
        
        //**** Action listener qui permettra de vérifier si l'identifiant et le mot de passe sont présents dans la bdd sinon il y aura un message d'erreur ****
        boutonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try
                {
                    if(sql.connexion(valeurId.getText(), valeurMdp.getText()))
                    {
                        new FenPrincipale();
                        fenConnexion.dispose();
                    }  
                    else{
                        JOptionPane.showMessageDialog(fenConnexion, "Identifiant ou mot de passe incorrect...","Oups !",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(fenConnexion, "Impossible de s'identifier à la BDD...","Oups !",JOptionPane.INFORMATION_MESSAGE);
                }               
            }
        });
    }
}

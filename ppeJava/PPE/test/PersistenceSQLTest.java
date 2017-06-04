/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JComboBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author corentin
 */
public class PersistenceSQLTest {
    
    public PersistenceSQLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //TRUCS A CHANGER ICI
    @Test
    public void testChargerDepuisBase() throws Exception {
        System.out.println("ChargerDepuisBase");
        String id = "01"; // a changer en fonction de l'id de l'objet a charger depuis la bdd
        String nomClasse = "Distributeur";
        PersistenceSQL instance = new PersistenceSQL();
        Object expResult = null; // distributeur a instancier en fonction des infos de l'objet a charger depuis la bdd
        Object result = instance.ChargerDepuisBase(id, nomClasse);
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testChargerListe() throws Exception {
        System.out.println("ChargerListe");
        JComboBox liste = new JComboBox();
        String nomClasse = "Distributeur";
        PersistenceSQL instance = new PersistenceSQL();
        instance.ChargerListe(liste, nomClasse);
        
    }

     //TRUCS A CHANGER ICI AUSSI

    @Test
    public void testConnexion() throws Exception {
        System.out.println("connexion");
        String identifiant = ""; //identifiant de la bdd
        String motDePasse = ""; // mot de passe de la bdd
        PersistenceSQL instance = new PersistenceSQL();
        boolean expResult = false;
        boolean result = instance.connexion(identifiant, motDePasse);
        assertEquals(expResult, result);
       
    }
    
}

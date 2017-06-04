/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class DistributeurTest {
    
    public DistributeurTest() {
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

    
    @Test
    public void testGetId() {
        System.out.println("getId");
        Distributeur instance = new Distributeur("01", "test01");
        String expResult = "01";
        String result = instance.getId();
        assertEquals(expResult, result);
           
    }

    
    @Test
    public void testGetNom() {
        
        System.out.println("getNom");
        Distributeur instance = new Distributeur("01", "test01");
        String expResult = "test01";
        String result = instance.getNom();
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testGetLesCommandes() {
        
        System.out.println("getLesCommandes");
        Distributeur instance = new Distributeur("01", "test01");
        Commande commande = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        ArrayList<Commande> expResult = new ArrayList<Commande>();
        expResult.add(commande);
        instance.setLesCommandes(expResult);
        ArrayList<Commande> result = instance.getLesCommandes();
        assertEquals(expResult, result);
      
    }

    
    @Test
    public void testGetCommandeEnCours() {
        
        System.out.println("getLesCommandesEnCours");
        Distributeur instance = new Distributeur("01", "test01");
        Commande commande = new Commande(1, 10, "condit","dateCond" , null, "01");
        ArrayList<Commande> expResult = new ArrayList<Commande>();
        expResult.add(commande);
        instance.setLesCommandes(expResult);
        ArrayList<Commande> result = instance.getCommandeEnCours();
        assertEquals(expResult, result);
       
    }

   
    @Test
    public void testSetLesCommandes() {
        
        System.out.println("setLesCommandes");
        Distributeur instance = new Distributeur("01", "test01");
        Commande commande = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        ArrayList<Commande> expResult = new ArrayList<Commande>();
        expResult.add(commande);
        instance.setLesCommandes(expResult);
        
    }
    
}

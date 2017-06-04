/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CommandeTest {
    
    public CommandeTest() {
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
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
       
    }

   
    @Test
    public void testGetQuantite() {
        System.out.println("getQuantite");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        int expResult = 10;
        int result = instance.getQuantite();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetConditionnement() {
        System.out.println("getConditionnement");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        String expResult = "condit";
        String result = instance.getConditionnement();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetDateConditionnement() {
        System.out.println("getDateConditionnement");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        String expResult = "dateCond";
        String result = instance.getDateConditionnement();
        assertEquals(expResult, result);
       
    }

   
    @Test
    public void testGetDateEnvoi() {
        System.out.println("getDateEnvoi");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        String expResult = "dateEnvoi";
        String result = instance.getDateEnvoi();
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testGetLeProduit() {
        System.out.println("getLeProduit");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        Produit expResult = new Produit("01", "variete", "type", 20);
        instance.setLeProduit(expResult);
        Produit result = instance.getLeProduit();
        assertEquals(expResult, result);
       
    }

   
    @Test
    public void testSetLeProduit() {
        System.out.println("setLeProduit");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        Produit expResult = new Produit("01", "variete", "type", 20);
        instance.setLeProduit(expResult);
       
    }

   
    @Test
    public void testGetIdDistributeur() {
        System.out.println("getIdDistributeur");
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        String expResult = "01";
        String result = instance.getIdDistributeur();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testSetIdDistributeur() {
        System.out.println("setIdDistributeur");
        String distributeur = "01";
        Commande instance = new Commande(1, 10, "condit","dateCond" , "dateEnvoi", "01");
        instance.setIdDistributeur(distributeur);
        
    }
    
}

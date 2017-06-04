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
public class ProduitTest {
    
    public ProduitTest() {
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
        Produit instance = new Produit("01", "variete", "type", 20);
        String expResult = "01";
        String result = instance.getId();
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testGetVariete() {
        System.out.println("getVariete");
        Produit instance = new Produit("01", "variete", "type", 20);
        String expResult = "variete";
        String result = instance.getVariete();
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testGetType() {
        System.out.println("getType");
        Produit instance = new Produit("01", "variete", "type", 20);
        String expResult = "type";
        String result = instance.getType();
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testGetCalibre() {
        System.out.println("getCalibre");
        Produit instance = new Produit("01", "variete", "type", 20);
        double expResult = 20;
        double result = instance.getCalibre();
        assertEquals(expResult, result, 20);
       
    }
    
}

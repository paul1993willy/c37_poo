/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulwillyjean
 */
public class ModelLaserVaisseauTest {

    private ModelLaserVaisseau instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("@Before");
        instance = new ModelLaserVaisseau();
    }

    @After
    public void tearDown() {
        System.out.println("@After");
        instance = new ModelLaserVaisseau();
    }

    /**
     * Test of deplacer method, of class ModelLaserVaisseau.
     */
    @Test
    public void testDeplacer() {
        System.out.println("deplacer");
        int expY = 0;
        int expX = 0;

        assertEquals(expY++, instance.getY());
        assertEquals(expX, instance.getX());
        instance.deplacer();
        assertEquals(expY, instance.getY());
        assertEquals(expX, instance.getX());
    }

    /**
     * Test of detruire method, of class ModelLaserVaisseau.
     */
    @Test
    public void testDetruire() {
        System.out.println("detruire");
        int expResult = 10;
        int result = instance.detruire();
        assertEquals(expResult, result);
    }

}

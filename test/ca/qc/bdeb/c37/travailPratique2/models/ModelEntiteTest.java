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
public class ModelEntiteTest {

    private ModelEntite instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("@Before");
        instance = new ModelEntiteImpl();
    }

    @After
    public void tearDown() {
        System.out.println("@After");
        instance = new ModelEntiteImpl();
    }

    /**
     * Test of getX method, of class ModelEntite.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class ModelEntite.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class ModelEntite.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int newX = 50;
        int expResult = 50;
        instance.setX(newX);
        assertEquals(expResult, instance.getX());
    }

    /**
     * Test of setY method, of class ModelEntite.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int newY = 50;
        int expResult = 50;
        instance.setY(newY);
        assertEquals(expResult, instance.getY());
    }

    public class ModelEntiteImpl extends ModelEntite {
    }

}
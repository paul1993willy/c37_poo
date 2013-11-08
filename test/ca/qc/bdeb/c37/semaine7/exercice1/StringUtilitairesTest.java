/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.semaine7.exercice1;

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
public class StringUtilitairesTest {

    public StringUtilitairesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("@Before");
    }

    @After
    public void tearDown() {
        System.out.println("@After");
    }

    /**
     * Test of stripA method, of class StringUtilitaires.
     */
    @Test
    public void testStripA() {
        System.out.println("stripA");
        StringUtilitaires instance = new StringUtilitaires("ABCD");

        instance.stripA();
        assertEquals("BCD" , instance.toString());

        instance.setText("AABB");
        instance.stripA();
        assertEquals("BB", instance.toString());

        instance.setText("CBAA");
        instance.stripA();
        assertEquals("CBAA", instance.toString());
    }

    /**
     * Test of isIdentique method, of class StringUtilitaires.
     */
    @Test
    public void testIsIdentique() {
        System.out.println("isIdentique");
        StringUtilitaires instance = new StringUtilitaires("ABCD");

        assertFalse(instance.isIdentique());

        instance.setText("AABC");
        assertTrue(instance.isIdentique());

        instance.setText("ABCC");
        assertTrue(instance.isIdentique());

        instance.setText("AABB");
        assertTrue(instance.isIdentique());

        instance.setText("aABC");
        assertFalse(instance.isIdentique());
    }

}

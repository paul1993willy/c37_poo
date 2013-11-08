/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.semaine3.exercice3;

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
public class FractionTest {

    public FractionTest() {
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
     * Test of getNumerateur method, of class Fraction.
     */
    @Test
    public void testGetNumerateur() {
        Fraction instance = new Fraction();
        assertEquals(0, instance.getNumerateur());

        instance.setNumerateur(5);
        assertEquals(5, instance.getNumerateur());

        instance = new Fraction(4,8);
        assertEquals(4, instance.getNumerateur());
    }

    /**
     * Test of setNumerateur method, of class Fraction.
     */
    @Test
    public void testSetNumerateur() {
        Fraction instance = new Fraction();
        assertEquals(0, instance.getNumerateur());

        instance.setNumerateur(5);
        assertEquals(5, instance.getNumerateur());
    }

    /**
     * Test of getDenominateur method, of class Fraction.
     */
    @Test
    public void testGetDenominateur() {
        Fraction instance = new Fraction(6, 8);

        assertEquals(8, instance.getDenominateur());

        instance.setDenominateur(12);
        assertEquals(12, instance.getDenominateur());
    }

    /**
     * Test of setDenominateur method, of class Fraction.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDenominateur() {
        Fraction instance = new Fraction();

        assertEquals(1, instance.getDenominateur());

        instance.setDenominateur(3);
        assertEquals(3, instance.getDenominateur());

        instance.setDenominateur(0);
        assertEquals(3, instance.getDenominateur());
    }

    /**
     * Test of plus method, of class Fraction.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Fraction instance = new Fraction(2,4).plus(new Fraction(1,4));

        assertTrue(instance.equals(new Fraction(3,4)));

        instance = new Fraction(1,4).plus(new Fraction(1,4));
        assertTrue(instance.equals(new Fraction(1,2)));

        instance = new Fraction(3,4).plus(new Fraction(6,8));
        assertTrue(instance.equals(new Fraction(3,2)));
    }

    /**
     * Test of moins method, of class Fraction.
     */
    @Test
    public void testMoins() {
        System.out.println("moins");
        Fraction fractionB = null;
        Fraction instance = new Fraction();
        Fraction expResult = null;
        Fraction result = instance.moins(fractionB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mult method, of class Fraction.
     */
    @Test
    public void testMult() {
        System.out.println("mult");
        Fraction fractionB = null;
        Fraction instance = new Fraction();
        Fraction expResult = null;
        Fraction result = instance.mult(fractionB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Fraction.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Fraction fractionB = null;
        Fraction instance = new Fraction();
        Fraction expResult = null;
        Fraction result = instance.div(fractionB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduire method, of class Fraction.
     */
    @Test
    public void testReduire() {
        System.out.println("reduire");
        Fraction instance = new Fraction();
        Fraction expResult = null;
        Fraction result = instance.reduire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Fraction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Fraction instance = new Fraction();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDouble method, of class Fraction.
     */
    @Test
    public void testToDouble() {
        System.out.println("toDouble");
        Fraction instance = new Fraction();
        double expResult = 0.0;
        double result = instance.toDouble();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class TestCercle {
	private Cercle cercle1, cercle2, cercle3;

	public void init()
	{
		this.cercle1 = new Cercle(0,0,2);
		this.cercle2 = new Cercle(0,0,2);

		System.out.println(this.cercle1.setX(2).toString());
		System.out.println(this.cercle2.toString());

		this.cercle2 = this.cercle1;

		System.out.println(this.cercle1.toString());
		System.out.println(this.cercle2.toString());

	}
	
	public static void main (String[] args)
	{
		TestCercle test = new TestCercle();
		test.init();
	}
}

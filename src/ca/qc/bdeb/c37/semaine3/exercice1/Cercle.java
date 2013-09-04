/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class Cercle extends Point {
	
	protected int r;

	public Cercle()
	{
		this(0,0,0);
	}

	public Cercle(int x, int y, int r)
	{
		super(x,y);
		this.r = r;
	}
}

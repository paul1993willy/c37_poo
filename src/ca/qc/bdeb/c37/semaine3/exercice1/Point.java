/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class Point {
	
	protected int x, y;

	public Point ()
	{
		this(0,0);

		System.out.println("Constructeur du point : " + this);
	}

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Point setX(int x)
	{
		this.x = x;
		return this;
	}

	public Point setY(int y)
	{
		this.y = y;
		return this;
	}

	public String toString()
	{
		return "{x:" + this.x + ", y:" + this.y +"}";
	}
}

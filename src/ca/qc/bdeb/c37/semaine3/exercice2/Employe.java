/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice2;

/**
 *
 * @author paulwillyjean
 */
public class Employe extends Personne {
	protected int id;

	public Employe()
	{
		this(null, null, 0, 0);
	}

	public Employe(String nom, String prenom, int age, int id)
	{
		super(nom, prenom, age);
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}

	public Employe setId(int id)
	{
		this.id = id;
		return this;
	}

	public String toString()
	{
		return super.toString() + "{id:" + this.id +"}";
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine4.exercice1;

/**
 *
 * @author paulwillyjean
 */
public abstract class Humain {
	protected Deplacement deplacement;
	protected Arme munition;
	
	public Humain()
	{
		this(new Marcher(), new Bazooka());
	}

	public Humain(Deplacement deplacement, Arme arme)
	{
		this.setMunition(arme);
		this.setDeplacement(deplacement);
	}

	public Arme getMunition()
	{
		return this.munition;
	}

	public Humain setMunition(Arme munition)
	{
		this.munition = munition;
		return this;
	}

	public Deplacement getDeplacement()
	{
		return this.deplacement;
	}

	public Humain setDeplacement(Deplacement deplacement)
	{
		this.deplacement = deplacement;
		return this;
	}

	public void seDeplacer()
	{
		this.deplacement.deplacer();
	}

	public void armer()
	{
		this.munition.armer();
	}
}

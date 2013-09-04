/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice2;

/**
 *
 * @author paulwillyjean
 */
public class Personne {
	protected String nom, prenom;
	protected int age;

	public Personne()
	{
		this(null, null, 0);
	}

	public Personne(String nom, String prenom, int age)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String getNom()
	{
		return this.nom;
	}

	public Personne setNom(String nom)
	{
		this.nom = nom;
		return this;
	}

	public String getPrenom()
	{
		return this.prenom;
	}

	public Personne setPrenom(String prenom)
	{
		this.prenom = prenom;
		return this;
	}

	public int getAge()
	{
		return this.age;
	}

	public Personne setAge(int age)
	{
		this.age = age;
		return this;
	}

	public String toString()
	{
		return "{nom:" + this.nom + ",prenom:" + this.prenom +",age:" + Integer.toString(this.age) + "}";
	}
}

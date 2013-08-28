/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine2.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class Personne {
	
	/**
	 * Servira de compteur pour connaître le nombre total
	 * d'instances de la classe
	 */
	private static int totalPersonnes;
	private String mNom;
	private String mPrenom;
	private int mId;

	public Personne() {
		this.mId = ++totalPersonnes;
	}

	public Personne(String nom, String prenom) {
		this();
		this.mNom = nom;
		this.mPrenom = prenom;
	}

	public String getNom() {
		return this.mNom;
	}

	public void setNom(String nom) {
		this.mNom = nom;
	}

	public String getPrenom() {
		return this.mPrenom;
	}

	public void setPrenom(String prenom) {
		this.mPrenom = prenom;
	}

	public int getId () {
		return this.mId;
	}

	@Override
	public String toString() {
		return "{Id:" + this.mId + ", Nom:" + this.mNom + ", Prenom:" + this.mPrenom + "}";
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine2.exercice2;
import ca.qc.bdeb.c37.semaine2.exercice1.Personne;
/**
 *
 * @author paulwillyjean
 */
public class Employe {
	private Personne personne;
	private String poste;

	public Employe(Personne personne) {
		this.personne = personne;
	}

	public Employe(Personne personne, String poste) {
		this(personne);
		this.poste = poste;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	@Override
	public String toString() {
		return "{Personne:" + this.personne.toString() + ", Poste:" + this.poste + "}";
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine2.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class TestPersonne {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Personne personne = new Personne("Jean", "Paul-Willy");
			System.out.println(personne.toString());
		}
	}
}

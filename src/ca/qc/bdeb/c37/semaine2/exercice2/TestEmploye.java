/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine2.exercice2;
import ca.qc.bdeb.c37.semaine2.exercice1.Personne;
import ca.qc.bdeb.c37.semaine2.exercice1.TestPersonne;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author paulwillyjean
 */
public class TestEmploye {
	ArrayList listeEmployes;

	TestEmploye() {
		this.listeEmployes = new ArrayList();

		for (int i = 0; i < 4; i++) {
			this.listeEmployes.add(new Employe(new Personne("Jean", "Paul-Willy"), "Développeur web"));
		}
	}

	public static void init() {
		TestEmploye test = new TestEmploye();
	}
}

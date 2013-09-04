/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice2;

/**
 *
 * @author paulwillyjean
 */
public class TestApplication {
	public static void main (String[] args)
	{
		Employe employe = new Employe("Jean", "Paul-Willy", 20, 1022680);
		System.out.println(employe.toString());
	}
}
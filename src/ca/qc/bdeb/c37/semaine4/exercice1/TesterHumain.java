/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine4.exercice1;
import java.util.ArrayList;
/**
 *
 * @author paulwillyjean
 */
public class TesterHumain {
	
	/**
	 * 
	 * @param args 
	 */
	public static void main (String[] args)
	{
		ArrayList<Humain> humains = new ArrayList();
		humains.add(new Guerrier());
		humains.add(new Zombi());

		for (Humain humain : humains)
		{
			System.out.println("Je suis un " + humain.getClass().getSimpleName());
			humain.seDeplacer();
			humain.armer();
		}
	}
}

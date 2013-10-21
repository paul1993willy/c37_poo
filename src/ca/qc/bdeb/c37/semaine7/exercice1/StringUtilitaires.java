/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.semaine7.exercice1;

/**
 *
 * @author paulwillyjean
 */
public class StringUtilitaires {
    private String chaine;

    public StringUtilitaires(String chaine) {
        this.chaine = chaine;
    }

    public void stripA() {
        String premieresLettres = this.chaine.substring(0, 2);
        String reste = this.chaine.substring(2);

        premieresLettres = premieresLettres.toUpperCase().replaceAll("A", "");

        this.chaine = premieresLettres + reste;
    }

    public boolean isIdentique() {

        return true;
    }
}

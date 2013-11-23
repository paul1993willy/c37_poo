/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

/**
 * Interface à utiliser pour tous les lasers générés dans le jeu
 * @author paulwillyjean
 */
public interface ModelLaser {
    /**
     * À utiliser pour déplacer les lasers dans l'espace
     */
    public void deplacer();

    /**
     * À utiliser pour détruire les objets spaciaux en cas de collision
     * Il devrait idéalement être appelé au moment de voir s'il y a intersection
     *
     * Retourne vrai s'il y a collision entre un laser et sa cible
     * @return
     */
    public boolean detruire();
}

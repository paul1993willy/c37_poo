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
     * Il devrait idéalement être appelé après qu'on se soit rendu compte qu'il y
     * a intersection entre les objets
     */
    public void detruire();
}

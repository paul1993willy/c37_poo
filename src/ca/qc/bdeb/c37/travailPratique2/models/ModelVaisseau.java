/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 *
 * @author paulwillyjean
 */
public class ModelVaisseau extends ModelEntite {

    private static ImageIcon iconeVaisseau;

    public ModelVaisseau() {
        init();
    }

    private void init() {
        this.setIcon(this.getClass().getResource("Ressource/vaisseau.png"));
    }

    /**
     * Définit une nouvelle icone pour le vaisseau
     * @param location
     */
    public void setIconeVaisseau(java.net.URL location) {
        iconeVaisseau = new javax.swing.ImageIcon(location);
    }
}

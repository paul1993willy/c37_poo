/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

/**
 *
 * @author paulwillyjean
 */
public class ModelVaisseau extends ModelEntite {

    private javax.swing.ImageIcon iconeVaisseau;

    public ModelVaisseau() {
        init();
    }

    private void init() {
        iconeVaisseau = new javax.swing.ImageIcon(this.getClass().getResource("vaisseau"));
    }

    /**
     * Définit une nouvelle icone pour le vaisseau
     * @param location
     */
    public void setIconeVaisseau(java.net.URL location) {
        iconeVaisseau = new javax.swing.ImageIcon(location);
    }
}

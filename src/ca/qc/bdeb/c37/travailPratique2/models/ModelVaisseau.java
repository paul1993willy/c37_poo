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
    public void setIcon(URL location) {
        ImageIcon oldIcon = new ImageIcon(iconeVaisseau.getImage());
        iconeVaisseau = new ImageIcon(location);
        this.firePropertyChange("IconeVaisseau", oldIcon , iconeVaisseau);
    }

    public void setIcon(String etat) {
        this.setIcon(this.getClass().getResource("vaisseau" + etat + ".png"));
    }

    @Override
    public ImageIcon getIcon() {
        return iconeVaisseau;
    }
}

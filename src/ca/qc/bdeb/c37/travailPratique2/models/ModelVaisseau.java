/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
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
        this.setBounds(new Rectangle(50, 50));
    }

    @Override
    public synchronized void setBounds(Rectangle bounds) {
        Rectangle oldBounds = this.getBounds();
        super.setBounds(bounds);
        this.firePropertyChange(ControllerCosmos.VAISSEAU_BOUNDS, oldBounds, this.getBounds());
    }
    /**
     * Définit une nouvelle icone pour le vaisseau
     * @param location
     */
    public synchronized void setIcon(URL location) {
        ImageIcon oldIcon = iconeVaisseau;
        iconeVaisseau = new ImageIcon(location);
        this.firePropertyChange(ControllerCosmos.VAISSEAU_ICON, oldIcon , iconeVaisseau);
    }

    public void setIcon(String etat) {
        this.setIcon(this.getClass().getResource("Ressources/vaisseau" + etat + ".png"));
    }

    @Override
    public ImageIcon getIcon() {
        return iconeVaisseau;
    }
}

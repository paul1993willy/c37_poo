/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
/**
 *
 * @author paulwillyjean
 */
public class ModelLaserVaisseau extends ModelEntite implements ModelLaser {
    static private final int POINTS_GAGNES = 10;
    private static ImageIcon iconeLaserVaisseau;

    public ModelLaserVaisseau() {
        init();
    }

    private void init() {
        this.setIcon(this.getClass().getResource("Ressources/laserVaisseau"));
    }

    @Override
    public synchronized void deplacer() {
        Rectangle oldBounds = new Rectangle(this.getBounds());

        this.getBounds().setLocation(oldBounds.x, oldBounds.y - 1);
        this.firePropertyChange(ControllerCosmos.LASER_BOUNDS, oldBounds, this.getBounds());
    }

    @Override
    public int detruire() {
        return POINTS_GAGNES;
    }

    @Override
    public ImageIcon getIcon() {
        return iconeLaserVaisseau;
    }

    public void setIcon(URL ressource) {
        iconeLaserVaisseau = new ImageIcon(ressource);
    }
}
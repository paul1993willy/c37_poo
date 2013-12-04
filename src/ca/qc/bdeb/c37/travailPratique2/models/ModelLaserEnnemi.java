/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import javax.swing.ImageIcon;

/**
 *
 * @author paulwillyjean
 */
public class ModelLaserEnnemi extends ModelEntite implements ModelLaser {
    private static final int POINTS_PERDUS = 10;
    private static ImageIcon iconLaserEnnemi;

    @Override
    public void deplacer() {
        this.setY(this.getBounds().y - 1);
        this.firePropertyChange("Y", this.getBounds().y + 1, this.getBounds().y);
    }

    @Override
    public int detruire() {
        return POINTS_PERDUS;
    }

    @Override
    public ImageIcon getIcon() {
        return iconLaserEnnemi;
    }
}

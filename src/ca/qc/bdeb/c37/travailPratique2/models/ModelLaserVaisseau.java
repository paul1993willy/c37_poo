/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.models;

import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
 *
 * @author paulwillyjean
 */
public class ModelLaserVaisseau extends ModelEntite implements ModelLaser {
    static private final int POINTS_GAGNES = 10;

    @Override
    public void deplacer() {
        this.setY(this.getY() + 1);
        this.firePropertyChange("Y", this.getY() - 1, this.getY());
    }

    @Override
    public int detruire() {
        return POINTS_GAGNES;
    }
}
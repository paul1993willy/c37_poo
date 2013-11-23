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
public class ModelLaserVaisseau extends ModelEntite implements ModelLaser {

    @Override
    public void deplacer() {
        this.setY(this.getY() + 1);
        this.firePropertyChange("Y", this.getY() - 1, this.getY());
    }

    public void detruire() {

    }
}

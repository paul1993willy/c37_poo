/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.controllers;

import ca.qc.bdeb.c37.travailPratique2.models.ModelLaserEnnemi;
import ca.qc.bdeb.c37.travailPratique2.models.ModelLaserVaisseau;
import ca.qc.bdeb.c37.travailPratique2.models.ModelVaisseau;
import ca.qc.bdeb.c37.travailPratique2.models.ModelEnnemi;
import ca.qc.bdeb.c37.travailPratique2.views.Cosmos;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author paulwillyjean
 */
public class ControllerCosmos extends Controller {

    public static final String VAISSEAU_ICON = "VaisseauIcon";
    public static final String VAISSEAU_BOUNDS = "VaisseauBounds";
    public static final String LASER_BOUNDS = "LaserBounds";

    private ModelVaisseau vaisseau;
    private Cosmos cosmos;

    private HashMap<ModelLaserVaisseau, JLabel> vaisseausLasers;
    private ArrayList<ModelLaserVaisseau> vaisseauLasers;
    private ArrayList<ModelLaserEnnemi> lasers;
    private ArrayList<ModelEnnemi> ennemis;

    public ControllerCosmos() {
        init();
    }

    /**
     * Initialise l'objet
     */
    private synchronized void init() {
        this.cosmos = new Cosmos(this);
        this.addView(cosmos);
        this.vaisseau = new ModelVaisseau();
        this.addModel(vaisseau);
        this.vaisseau.setIcon("");
        vaisseauLasers = new ArrayList<>();
        lasers = new ArrayList<>();
        ennemis = new ArrayList<>();
    }

    /**
     * Change la position du vaisseau selon les coordonées fournies
     * @param vaisseauPoint
     */
    public synchronized void setVaisseauPosition(Point vaisseauPoint) {
        Rectangle bounds = new Rectangle(vaisseauPoint, vaisseau.getBounds().getSize());
        vaisseau.setBounds(bounds);

        for (ModelLaserEnnemi laser : lasers) {
            if (laser.getBounds().intersects(vaisseau.getBounds())) {
                vaisseau.setIcon("Touche");
            }
        }

        for (ModelEnnemi ennemi : ennemis) {
            if (ennemi.getBounds().intersects(vaisseau.getBounds())) {
                vaisseau.setIcon("Touche");
            }
        }
    }

    public synchronized void setLaserVaisseau(Rectangle bounds) {
        ModelLaserVaisseau laser = new ModelLaserVaisseau();
        laser.setBounds(bounds);
    }
}

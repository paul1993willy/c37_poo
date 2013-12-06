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
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author paulwillyjean
 */
public class ControllerCosmos extends Controller {

    public static final Object ENNEMI_TIC = new Object();
    public static final Object ENNEMI_LASER_TIC = new Object();
    public static final String VAISSEAU_BOUNDS = "VaisseauBounds";
    public static final String VAISSEAU_ICON = "VaisseauIcon";
    public static final String VAISSEAU_LASER_BOUNDS = "LaserBounds";
    public static final String VAISSEAU_LASER_ICON = "VaisseauLaserIcon";
    public static final Object VAISSEAU_LASER_TIC = new Object();

    private ModelVaisseau vaisseau;
    private Cosmos cosmos;

    private List<ModelLaserVaisseau> vaisseauLasers;
    private List<ModelLaserEnnemi> ennemisLasers;
    private List<ModelEnnemi> ennemis;

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
        vaisseauLasers = Collections.synchronizedList(new ArrayList<ModelLaserVaisseau>());
        ennemisLasers = Collections.synchronizedList(new ArrayList<ModelLaserEnnemi>());
        ennemis = Collections.synchronizedList(new ArrayList<ModelEnnemi>());

        Thread laserThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (VAISSEAU_LASER_TIC) {
                            for (ModelLaserVaisseau vaisseauLaser : vaisseauLasers) {
                                vaisseauLaser.deplacer();
                            }
                        }
                        Thread.sleep(5);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        laserThread.start();
    }

    /**
     * Change la position du vaisseau selon les coordonées fournies
     * @param vaisseauPoint
     */
    public void setVaisseauPosition(Point vaisseauPoint) {
        if (vaisseauPoint.x > (Cosmos.MAX_X - vaisseau.getBounds().width)) {
            vaisseauPoint.x = (Cosmos.MAX_X - vaisseau.getBounds().width);
        }

        if (vaisseauPoint.y > (Cosmos.MAX_Y - vaisseau.getBounds().height)) {
            vaisseauPoint.y = (Cosmos.MAX_Y - vaisseau.getBounds().height);
        }

        Rectangle bounds = new Rectangle(vaisseauPoint, vaisseau.getBounds().getSize());
        vaisseau.setBounds(bounds);

        synchronized (ENNEMI_LASER_TIC) {
            for (ModelLaserEnnemi laser : ennemisLasers) {
                if (laser.getBounds().intersects(vaisseau.getBounds())) {
                    vaisseau.setIcon("Touche");
                }
            }
        }

        synchronized (ENNEMI_TIC) {
            for (ModelEnnemi ennemi : ennemis) {
                if (ennemi.getBounds().intersects(vaisseau.getBounds())) {
                    vaisseau.setIcon("Touche");
                }
            }
        }
    }

    public void setLaserVaisseau(Point points, JLabel boutonLaser) {
        ModelLaserVaisseau laser = new ModelLaserVaisseau();
        laser.getBounds().setLocation(points);
        boutonLaser.setBounds(laser.getBounds());
        this.addModel(laser);
        synchronized (VAISSEAU_LASER_TIC) {
            this.vaisseauLasers.add(laser);
        }
        boutonLaser.setIcon(laser.getIcon());
    }
}

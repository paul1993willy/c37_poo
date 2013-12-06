/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.views;
import ca.qc.bdeb.c37.travailPratique2.controllers.Controller;
import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author paulwillyjean
 */
public class Cosmos extends javax.swing.JFrame implements View {

    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 500;
    public static final int MAX_Y = 700;

    private ControllerCosmos controller;
    private JPanel panneau;
    private JLabel background;
    private JLabel vaisseau;
    private List<JLabel> vaisseauLasers;

    /**
     * Crée une nouvelle instance de la vue et y
     * attache
     * @param controlleur
     */
    public Cosmos(ControllerCosmos controlleur) {
        this.controller = controlleur;
        initComponents();
        localInitialization();
    }

    private void initComponents() {
        vaisseauLasers = Collections.synchronizedList(new ArrayList<JLabel>());
        panneau = new JPanel(null);
        background = new JLabel();
        vaisseau = new JLabel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(panneau);
        panneau.add(background);
        panneau.add(vaisseau);
        panneau.setComponentZOrder(background, 1);
        panneau.setComponentZOrder(vaisseau, 0);
        panneau.setSize(MAX_X, MAX_Y);
        background.setBounds(new Rectangle(MAX_X, MAX_Y));
        background.setIcon(new ImageIcon(this.getClass().getResource("background.png")));
        vaisseau.setBounds(225, 550, 50, 50);
        this.setVisible(true);
    }

    private void localInitialization() {
        // Crée une image transparante pour le curseur
        java.awt.image.BufferedImage cursorImg = new java.awt.image.BufferedImage(16, 16,
            java.awt.image.BufferedImage.TYPE_INT_ARGB);

        // Crée un curseur transparent pour qu'on ne le voit plus.
        java.awt.Cursor blankCursor = java.awt.Toolkit.getDefaultToolkit()
                .createCustomCursor(cursorImg, new java.awt.Point(0, 0), "Blank Cursor");

        // Rend le curseur transparent pour qu'on ne le voit plus.
        this.getContentPane().setCursor(blankCursor);

        panneau.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                vaisseau.setLocation(me.getPoint());
            }
        });

        panneau.setFocusable(true);
        panneau.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == ' ') {
                    JLabel vaisseauLaser = new JLabel();
                    Point laserPoint = new Point(vaisseau.getLocation());

                    // Déplace le point au milieu du vaisseau
                    laserPoint.setLocation(laserPoint.getX() + 20, laserPoint.getY());

                    //Ajoute le laser au panneau
                    panneau.add(vaisseauLaser);
                    panneau.setComponentZOrder(background, panneau.getComponentCount() - 1);
                    panneau.setComponentZOrder(vaisseauLaser, panneau.getComponentCount() - 2);
                    synchronized (ControllerCosmos.VAISSEAU_LASER_TIC) {
                        vaisseauLasers.add(vaisseauLaser);
                    }
                    controller.setLaserVaisseau(laserPoint, vaisseauLaser);
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        panneau.addMouseListener(new NouveauVaisseauMouseListener());
        vaisseau.addComponentListener(new VaisseauPositionComponentListener());
    }

    @Override
    public void modelPropertyChange(final java.beans.PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case ControllerCosmos.VAISSEAU_ICON:
                vaisseau.setIcon( (ImageIcon) evt.getNewValue());
                break;
            case ControllerCosmos.VAISSEAU_BOUNDS:
                if ( ! vaisseau.getBounds().equals((Rectangle) evt.getOldValue())) {
                    vaisseau.setBounds((Rectangle) evt.getNewValue());
                }
                break;
            case ControllerCosmos.VAISSEAU_LASER_BOUNDS:
                synchronized (ControllerCosmos.VAISSEAU_LASER_TIC) {
                    for (JLabel laser : vaisseauLasers) {
                        if (laser.getBounds().equals((Rectangle) evt.getOldValue())) {
                            laser.setBounds((Rectangle) evt.getNewValue());
                        }
                    }
                }
                break;
        }
    }

    private class NouveauVaisseauMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
                JLabel vaisseauLaser = new JLabel();
                Point laserPoint = new Point(me.getPoint());

                // Déplace le point au milieu du vaisseau
                laserPoint.setLocation(laserPoint.getX() + 20, laserPoint.getY());

                //Ajoute le laser au panneau
                panneau.add(vaisseauLaser);
                panneau.setComponentZOrder(background, panneau.getComponentCount() - 1);
                panneau.setComponentZOrder(vaisseauLaser, panneau.getComponentCount() - 2);
                synchronized (ControllerCosmos.VAISSEAU_LASER_TIC) {
                    vaisseauLasers.add(vaisseauLaser);
                }
                controller.setLaserVaisseau(laserPoint, vaisseauLaser);
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }
    private class VaisseauPositionComponentListener implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent ce) {
        }

        @Override
        public void componentMoved(ComponentEvent ce) {
            ((ControllerCosmos) controller).setVaisseauPosition(vaisseau.getLocation());
        }

        @Override
        public void componentShown(ComponentEvent ce) {
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
        }
    }
}
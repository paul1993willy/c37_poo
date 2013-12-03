/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.views;
import ca.qc.bdeb.c37.travailPratique2.controllers.Controller;
import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import java.awt.image.BufferedImage;

/**
 *
 * @author paulwillyjean
 */
public class Cosmos extends javax.swing.JFrame implements View {

    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 500;
    public static final int MAX_Y = 700;

    private Controller controller;
    private javax.swing.JPanel panneau;
    private javax.swing.JLabel vaisseau;

    public Cosmos(Controller controlleur) {
        this.controller = controlleur;
        initComponents();
        localInitialization();
    }

    private void initComponents() {
        panneau = new javax.swing.JPanel(null);
        vaisseau = new javax.swing.JLabel();
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(panneau);
        this.getClass().getResource("background.png");
        panneau.add(vaisseau);
        panneau.setSize(MAX_X, MAX_Y);
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

        panneau.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent me) {
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent me) {
                vaisseau.setLocation(me.getPoint());
            }

        });

        vaisseau.addComponentListener(new java.awt.event.ComponentListener() {

            @Override
            public void componentResized(java.awt.event.ComponentEvent ce) {
            }

            @Override
            public void componentMoved(java.awt.event.ComponentEvent ce) {
                ((ControllerCosmos) controller).setVaisseauPosition(vaisseau.getLocation());
            }

            @Override
            public void componentShown(java.awt.event.ComponentEvent ce) {
            }

            @Override
            public void componentHidden(java.awt.event.ComponentEvent ce) {
            }
        });
    }

    @Override
    public void modelPropertyChange(final java.beans.PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ControllerCosmos.VAISSEAU_ICON)) {
            vaisseau.setIcon( (javax.swing.ImageIcon) evt.getNewValue());
        }
    }
}

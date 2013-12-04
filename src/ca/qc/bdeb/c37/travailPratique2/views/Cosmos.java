/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.views;
import ca.qc.bdeb.c37.travailPratique2.controllers.Controller;
import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;
import ca.qc.bdeb.c37.travailPratique2.models.ModelLaserVaisseau;
import ca.qc.bdeb.c37.travailPratique2.models.ModelVaisseau;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
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

    private Controller controller;
    private JPanel panneau;
    private JLabel background;
    private JLabel vaisseau;

    public Cosmos(Controller controlleur) {
        this.controller = controlleur;
        initComponents();
        localInitialization();
    }

    private void initComponents() {
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
        switch (evt.getPropertyName()) {
            case ControllerCosmos.VAISSEAU_ICON:
                vaisseau.setIcon( (ImageIcon) evt.getNewValue());
                break;
            case ControllerCosmos.VAISSEAU_BOUNDS:
                if ( ! vaisseau.getBounds().equals((Rectangle) evt.getOldValue())) {
                    vaisseau.setBounds((Rectangle) evt.getNewValue());
                }
                break;
        }
    }
}

package ca.qc.bdeb.c37.travailPratique2.models;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 *
 * @author 1022680
 */
public class ModelEnnemi extends ModelEntite {
    public static ImageIcon iconeEnnemi;

    public ModelEnnemi() {
        this.init();
    }

    private void init() {
        this.setIcon(this.getClass().getResource("Ressource/laserEnnemi.png"));
    }

    /**
     * Charge une nouvelle icone à partir d'une ressource URL
     * @param ressource
     */
    public synchronized void setIcon(URL ressource) {
        ImageIcon oldIcone = new ImageIcon(iconeEnnemi.getImage());
        iconeEnnemi = new ImageIcon(ressource);
        this.firePropertyChange("IconeEnnemi", oldIcone, iconeEnnemi);
    }

    @Override
    public ImageIcon getIcon() {
        return iconeEnnemi;
    }
}

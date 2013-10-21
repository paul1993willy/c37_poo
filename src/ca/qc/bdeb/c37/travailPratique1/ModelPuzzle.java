/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.travailPratique1;
import javax.swing.JButton;
import org.w3c.dom.html.HTMLElement;

/**
 *
 * @author paulwillyjean
 */
public class ModelPuzzle {
    private JButton[][] boutons;
    private JButton[][] reserve;
    private int nombreLignesBoutons;
    private int nombreColonnesBoutons;
    int HAUTEUR_BOUTON = 50;
    int LARGEUR_BOUTON = 50;

    private ModelPuzzle() {
        this.HAUTEUR_BOUTON = 50;
        this.LARGEUR_BOUTON = 50;
    }

    /**
     * Constructeur qui définit le nombre de lignes et de colonnes
     * @param width
     * @param height
     */
    public ModelPuzzle(int width, int height) {
        this.nombreColonnesBoutons = width;
        this.nombreLignesBoutons = height;
        this.boutons = new JButton[this.nombreLignesBoutons][this.nombreColonnesBoutons];
        this.reserve = new JButton[this.nombreLignesBoutons][this.nombreColonnesBoutons];
    }

    public int getNombreLignesBoutons() {
        return this.nombreLignesBoutons;
    }

    public int getNombreColonnessBoutons() {
        return this.nombreColonnesBoutons;
    }

    public void addBouton(JButton bouton) {
        for (int i = 0; i < this.nombreLignesBoutons; i++) {
            for (int j = 0; j < this.nombreColonnesBoutons; j++) {
                if (this.boutons[i][j] != null) {
                    this.addBouton(bouton, j, i);
                    return;
                }
            }
        }
    }

    public void addBouton(JButton bouton, int colonneBoutons, int ligneBoutons) {

    }
}

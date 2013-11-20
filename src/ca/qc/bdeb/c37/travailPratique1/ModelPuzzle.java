/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.travailPratique1;
import javax.swing.JButton;

/**
 *
 * @author paulwillyjean
 */
public class ModelPuzzle {
    private JButton[][] boutons;
    private JButton[][] reserve;
    private int nombreLignesBoutons;
    private int nombreColonnesBoutons;
    private int hauteurBouton = 50;
    private int largeurBouton = 50;

    private ModelPuzzle() {
        this.hauteurBouton = 50;
        this.largeurBouton = 50;
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

    public int getHauteurBouton() {
        return this.hauteurBouton;
    }

    public void setHauteurBouton(int hauteur) {
        this.hauteurBouton = hauteur;

        // Change la hauteur de tous les boutons du puzzle
        for (JButton[] rangee : this.boutons) {
            for (JButton bouton : rangee) {
                bouton.setSize(this.getHauteurBouton(), this.getLargeurBouton());
            }
        }
    }

    public int getLargeurBouton() {
        return this.largeurBouton;
    }

    public void getLargeurBouton (int largeur) {
        this.largeurBouton = largeur;
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

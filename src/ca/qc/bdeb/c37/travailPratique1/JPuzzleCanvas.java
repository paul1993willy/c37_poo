/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.travailPratique1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author paulwillyjean
 */
public class JPuzzleCanvas extends JPanel {

	private javax.swing.JButton[][] boutons;
	private javax.swing.JButton[][] reserve;
	private int lignes;
	private int colonnes;

	public JPuzzleCanvas(int height, int width) {
		this.boutons = new javax.swing.JButton [height][width];
		this.lignes = height;
		this.colonnes = width;
		this.melangerPieces();
		this.placerBoutons();
	}

	/**
	 * Melange les pieces du puzzle selon sa dimension
	 * @param height
	 * @param width 
	 */
	private void melangerPieces() {
		int index = 0; // Initialise un index a 0
		int min = 0;
		int max = (this.lignes * this.colonnes - 1);

		while (index <= max) {

			// Valeur generee aleatoirement pour etre placee dans le tableau
			int valeur = (int) Math.floor(Math.random() * (max + 1 - min) + min);

			// Devient vrai si valeur existe deja.
			boolean existe = false;

			/*
			 * S'assure que la valeur ne soit pas presente dans le
			 * tableau et qu'il ne soit pas vide
			 */
			for (int i = 0; i <= index / this.lignes; i ++) {
				for (int j = 0; j < this.colonnes; j++) {
					if (i >= (index / this.lignes) && j >= (index % this.colonnes)) {
						break;
					}

					if ((valeur == 0 && this.boutons[i][j] == null) ||
							(this.boutons[i][j] != null && Integer.parseInt(this.boutons[i][j].getText()) == valeur)) {
						existe = true;
					}
				}
			}

			/*
			 *  Ajoute la valeur au tableau si elle n'existe pas deja
			 */
			if (!existe) {
				if (valeur != 0) {
					this.boutons[index / this.lignes][index % this.colonnes] = new javax.swing.JButton(Integer.toString(valeur));
				}

				index++;
			}
		}
	}

	/**
	 * Place les pièces du puzzle dans le panneau
	 * @param height
	 * @param width 
	 */
	private void placerBoutons() {
		for (int i = 0; i < this.lignes; i++) {
			for (int j = 0; j < this.colonnes; j++) {
				int hauteurBouton = 279 / this.lignes ;//(this.getHeight() / this.lignes);
				int largeurBouton = 376 / this.colonnes; //(this.getWidth() / this.colonnes);
				int top = (this.getY() + hauteurBouton * i);
				int left = (this.getX() + largeurBouton * j);

				if (this.boutons[i][j] != null) {
					this.add(this.boutons[i][j]);
					this.boutons[i][j].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent ae) {
							jPanelCanvasButtonActionPerformed(ae);
						}
					}) ;
					this.boutons[i][j].setBounds(left, top, largeurBouton, hauteurBouton);
					this.boutons[i][j].setVisible(true);
				}
			}
		}

		this.reserve = (javax.swing.JButton[][]) this.boutons.clone();
		super.setVisible(true);
	}

	private void jPanelCanvasButtonActionPerformed(ActionEvent ae) {
		this.bougerBouton((javax.swing.JButton) ae.getSource());
	}

	public void bougerBouton(javax.swing.JButton bouton) {
		java.awt.Dimension position = this.getRank(bouton);
		if (position != null) {
			int ligne = (int) position.getHeight();
			int colonne = (int) position.getWidth();
			if (this.deplacerHaut(bouton, ligne, colonne) || this.deplacerBas(bouton, ligne, colonne) ||
					this.deplacerGauche(bouton, ligne, colonne) || this.deplacerDroite(bouton, ligne, colonne)) {
				this.invalidate();
				this.validerOrdre();
			}
		}
	}

	private boolean deplacerHaut(javax.swing.JButton bouton, int ligne, int colonne) {
		if (ligne > 0 && this.boutons[ligne - 1][colonne] == null) {
			bouton.setAlignmentY(bouton.getAlignmentY() - bouton.getHeight());
			bouton.setLocation(bouton.getX(), bouton.getY() - bouton.getHeight());
			this.boutons[ligne - 1][colonne] = bouton;
			this.boutons[ligne][colonne] = null;
			return true;
		}

		return false;
	}

	private boolean deplacerBas(javax.swing.JButton bouton, int ligne, int colonne) {
		if (ligne < this.lignes - 1 && this.boutons[ligne + 1][colonne] == null) {
			bouton.setLocation(bouton.getX(), bouton.getY() + bouton.getHeight());
			this.boutons[ligne + 1][colonne] = bouton;
			this.boutons[ligne][colonne] = null;
			return true;
		}

		return false;
	}

	private boolean deplacerGauche(javax.swing.JButton bouton, int ligne, int colonne) {
		if (colonne > 0 && this.boutons[ligne][colonne - 1] == null) {
			bouton.setLocation(bouton.getX() - bouton.getWidth(), bouton.getY());
			this.boutons[ligne][colonne - 1] = bouton;
			this.boutons[ligne][colonne] = null;
			return true;
		}

		return false;
	}

	private boolean deplacerDroite(javax.swing.JButton bouton, int ligne, int colonne) {
		if (colonne < this.colonnes - 1 && this.boutons[ligne][colonne + 1] == null) {
			bouton.setLocation(bouton.getX() + bouton.getWidth(), bouton.getY());
			this.boutons[ligne][colonne + 1] = bouton;
			this.boutons[ligne][colonne] = null;
			return true;
		}

		return false;
	}

	public java.awt.Dimension getRank(javax.swing.JButton bouton) {
		for (int i = 0; i < this.lignes; i++) {
			for (int j = 0; j < this.colonnes; j++) {
				if (this.boutons[i][j] == bouton) {
					return new java.awt.Dimension(j, i);
				}
			}
		}

		return null;
	}
	
	private boolean validerOrdre() {
		int valeur = 0;

		for (int i = 0; i < this.lignes; i++) {
			for (int j = 0; j < this.colonnes; j++) {
				if (this.boutons[i][j] != null) {
					if (valeur + 1 != Integer.parseInt(this.boutons[i][j].getText())) {
						return false;
					}
				} else if (valeur + 1 != 16) {
					return false;
				}

				valeur++;
			}
		}

		return true;
	}
}

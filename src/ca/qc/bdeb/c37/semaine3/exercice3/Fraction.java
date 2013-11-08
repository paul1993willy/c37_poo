/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.c37.semaine3.exercice3;

/**
 *
 * @author paulwillyjean
 */
public class Fraction
{
	protected int numerateur;
	protected int denominateur;

	public Fraction() {
		this(0,1);
	}

	public Fraction(String fraction) {

		// Aucunement optimisé, mais faire autrement fait chier.
		this(Integer.parseInt(fraction.split("/", 2)[0]),
				Integer.parseInt((fraction.split("/", 2).length == 2)
						? fraction.split("/", 2)[1]
						: "1"));
	}

	public Fraction(int numerateur, int denominateur) {
		if (denominateur == 0) {
			throw new IllegalArgumentException("Le denominateur ne doit jamais etre zero");
		}

		this.numerateur  = numerateur;
		this.denominateur = denominateur;
	}

	public int getNumerateur() {
		return this.numerateur;
	}

	public Fraction setNumerateur(int numerateur) {
		this.numerateur = numerateur;
		return this;
	}

	public int getDenominateur() {
		return this.denominateur;
	}

	public Fraction setDenominateur(int denominateur) throws IllegalArgumentException {
		if (denominateur == 0) {
			throw new IllegalArgumentException("Le denominateur ne doit jamais etre zero");
		}

		this.denominateur = denominateur;

		return this;
	}

	public Fraction plus(Fraction fractionB) {
		Fraction fractionResultat = new Fraction();

		// Les dénominateurs doivent être pareils
		if (this.getDenominateur() != fractionB.getDenominateur()) {
			if ((this.getDenominateur() % fractionB.getDenominateur()) == 0) {
				fractionResultat.setDenominateur(this.getDenominateur());
			} else if ((fractionB.getDenominateur() % this.getDenominateur()) == 0) {
				fractionResultat.setDenominateur(fractionB.getDenominateur());
			} else {
				fractionResultat.setDenominateur(this.getDenominateur() * fractionB.getDenominateur());
			}
		} else {
            fractionResultat.setDenominateur(this.getDenominateur());
        }

		fractionResultat.setNumerateur((this.getNumerateur() * fractionResultat.getDenominateur() / this.getDenominateur())
			+ (fractionB.getNumerateur() * fractionResultat.getDenominateur() / fractionB.getDenominateur()));

		return fractionResultat.reduire();
	}

	/**
	 * Soustrait deux fractions ensemble et en retourne le résultat
	 * @param {Fraction} fractionB
	 * @return Fraction
	 */
	public Fraction moins(Fraction fractionB) {
		Fraction fractionBCopie = new Fraction(-fractionB.getNumerateur(), fractionB.getDenominateur());
		return this.plus(fractionBCopie);
	}

	/**
	 * Multiplie deux fractions ensemble et en retourne le résultat
	 * @param {Fraction} fractionB
	 * @return Fraction
	 */
	public Fraction mult(Fraction fractionB) {
		Fraction fractionResultat = new Fraction();

		fractionResultat.setNumerateur(this.getNumerateur() * fractionB.getNumerateur())
			.setDenominateur(this.getDenominateur() * fractionB.getDenominateur());
		return fractionResultat.reduire();
	}

	public Fraction div(Fraction fractionB) {
		Fraction fractionBInversee = new Fraction(fractionB.getDenominateur(), fractionB.getNumerateur());
		return this.mult(fractionBInversee);
	}

	/**
	 * Simplifie la fraction à sa forme irréductible
	 * @return Fraction
	 */
	public Fraction reduire() {
		int plusPetiteValeur = Math.min(Math.abs(this.getNumerateur()), Math.abs(this.getDenominateur()));

		/*
		 * Décrémente le plus grand diviseur commun s'il laisse
		 * un reste en divisant le numérateur ou le dénominateur
		 */
		for(int i = plusPetiteValeur; i > 1; i--) {
			// S'assure que le plus grand diviseur commun ne laisse aucun reste
			if((this.getDenominateur() % i == 0) && (this.getNumerateur() % i == 0)) {
				this.setDenominateur(this.getDenominateur() / i);
				this.setNumerateur(this.getNumerateur() / i);
				return this;
			}
		}

		// Retourne la fraction telle quelle si elle est irréductible
		return this;
	}

    public boolean equals(Fraction fractionB) {
        return (this.getNumerateur() == fractionB.getNumerateur() &&
                this.getDenominateur() == fractionB.getDenominateur());
    }

	@Override
	public String toString() {
		return this.getNumerateur() + "/" + this.getDenominateur();
	}

	public double toDouble() {
		return (double) this.getNumerateur() / (double) this.getDenominateur();
	}
}

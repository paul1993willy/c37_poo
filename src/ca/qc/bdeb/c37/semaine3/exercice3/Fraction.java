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
	protected int numerateur, denominateur;

	public Fraction()
	{
		this(1,1);
	}

	public Fraction(int numerateur, int denominateur)
	{
		this.setNumerateur(numerateur).setDenominateur(denominateur);
	}

	public int getNumerateur()
	{
		return this.numerateur;
	}

	public Fraction setNumerateur(int numerateur)
	{
		this.numerateur = numerateur;
		return this;
	}

	public int getDenominateur()
	{
		return this.denominateur;
	}

	public Fraction setDenominateur(int denominateur)
	{
		if (denominateur == 0)
		{
			throw new IllegalArgumentException("Le denominateur ne doit jamais etre zero");
		}

		this.denominateur = denominateur;

		return this;
	}

	public Fraction plus(Fraction fractionB)
	{
		Fraction fractionResultat = new Fraction();

		// Les dénominateurs doivent être pareils
		if (this.getDenominateur() != fractionB.getDenominateur())
		{
			if ((this.getDenominateur() % fractionB.getDenominateur()) == 0)
			{
				fractionResultat.setDenominateur(this.getDenominateur());
			}
			else if ((fractionB.getDenominateur() % this.getDenominateur()) == 0)
			{
				fractionResultat.setDenominateur(fractionB.getDenominateur());
			}
			else
			{
				fractionResultat.setDenominateur(this.getDenominateur() * fractionB.getDenominateur());
			}
		}

		fractionResultat.setNumerateur((this.getNumerateur() * fractionResultat.getDenominateur() / this.getDenominateur())
			+ (fractionB.getNumerateur() * fractionResultat.getDenominateur() / fractionB.getDenominateur()));

		return fractionResultat;
	}

	/**
	 * @param {Fraction} fractionB
	 * @return Fraction
	 */
	public Fraction moins(Fraction fractionB)
	{
		fractionB.setNumerateur(-fractionB.getNumerateur());
		return this.plus(fractionB);
	}

	/**
	 * @param {Fraction} fractionB
	 * @return Fraction
	 */
	public Fraction mult(Fraction fractionB)
	{
		Fraction fractionResultat = new Fraction();

		fractionResultat.setNumerateur(this.getNumerateur() * fractionB.getNumerateur())
			.setDenominateur(this.getDenominateur() * fractionB.getDenominateur());
		return fractionResultat;
	}
}

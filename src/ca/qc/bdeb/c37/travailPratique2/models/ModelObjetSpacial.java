package ca.qc.bdeb.c37.travailPratique2.models;

/**
 *
 * @author 1022680
 */
public abstract class ModelObjetSpacial extends Model {
    private int X;
    private int Y;
    private int width;
    private int height;

    /**
     * Retourne la position en X de l'objet
     * @return
     */
    public int getX() {
        return this.X;
    }

    /**
     * Retourne la position en Y de l'objet
     * @return
     */
    public int getY() {
        return this.Y;
    }

    /**
     * Positionne l'objet en X
     * @param newX
     */
    public void setX(int newX) {
        this.X = newX;
    }

    /**
     * Positionne l'objet en Y
     * @param newY
     */
    public void setY(int newY) {
        this.Y = newY;
    }
}

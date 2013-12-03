package ca.qc.bdeb.c37.travailPratique2.models;

/**
 *
 * @author 1022680
 */
public abstract class ModelEntite extends Model {
    // Les dimensions et les coordonnées de l'entité
    private java.awt.Rectangle bounds;

    /**
     * Retourne les dimensions et la position de l'entité
     * @return
     */
    public java.awt.Rectangle getBounds() {
        return this.bounds;
    }

    /**
     * Retourne les dimensions et la position de l'entité dans le
     * rectangle passé en paramètre.
     * @param pBounds
     * @return
     */
    public java.awt.Rectangle getBounds(java.awt.Rectangle pBounds) {
        pBounds = this.getBounds();
        return pBounds;
    }

    public void setBounds(java.awt.Rectangle bounds) {
        this.bounds = bounds;
    }
    /**
     * Retourne la position en X de l'objet
     * @return
     */
    public int getX() {
        return this.bounds.x;
    }

    /**
     * Retourne la position en Y de l'objet
     * @return
     */
    public int getY() {
        return this.bounds.y;
    }

    /**
     * Positionne l'objet en X
     * @param newX
     */
    public void setX(int newX) {
        this.bounds.setLocation(newX, this.bounds.y);
    }

    /**
     * Positionne l'objet en Y
     * @param newY
     */
    public void setY(int newY) {
        this.bounds.setLocation(this.bounds.y, newY);
    }
}

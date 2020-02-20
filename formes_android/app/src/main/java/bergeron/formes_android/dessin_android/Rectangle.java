package bergeron.formes_android.dessin_android;

import android.graphics.Canvas;

import commun.debogage.J;

class Rectangle extends Forme {

    protected float largeur;
    protected float hauteur;


    public Rectangle(String couleur, float centreX, float centreY, float largeur, float hauteur) {
        super(couleur, centreX, centreY);
        J.appel(this);

        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(Canvas canvas) {
        J.appel(this);

        canvas.drawRect(centreX - largeur/2,
                centreY - hauteur / 2,
                centreX + largeur / 2,
                centreY + hauteur / 2,
                peinture);
    }
}

package bergeron.formes_android.dessin_android;

import android.graphics.Canvas;

import commun.debogage.J;

class Cercle extends Forme {

    protected float rayon;

    public Cercle(String couleur, float centreX, float centreY, float rayon) {
        super(couleur, centreX, centreY);
        J.appel(this);

        this.rayon = rayon;
    }

    @Override
    public void dessiner(Canvas canvas) {
        J.appel(this);

        canvas.drawArc(centreX - rayon/2,
                centreY - rayon/2,
                centreX + rayon/2,
                centreY + rayon/2,
                0,
                360,
                true,
                peinture);
    }
}

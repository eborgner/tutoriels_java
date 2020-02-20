package bergeron.formes_android.dessin_android;

import android.graphics.Canvas;
import android.graphics.Paint;

import commun.debogage.J;

class Carre extends Forme {

    private float taille;

    public Carre(String couleur, float centreX, float centreY, float taille){
        super(couleur, centreX, centreY);
        J.appel(this);

        this.taille = taille;
    }


    @Override
    public void dessiner(Canvas canvas) {
        J.appel(this);

        canvas.drawRect(centreX-taille/2,
                centreY-taille/2,
                centreX+taille/2,
                centreY+taille/2, peinture);
    }
}

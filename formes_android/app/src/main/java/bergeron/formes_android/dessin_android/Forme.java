package bergeron.formes_android.dessin_android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import commun.debogage.J;

abstract class Forme {

    protected Paint peinture;
    protected float centreX;
    protected float centreY;

    public Forme(String couleur, float centreX, float centreY){
        J.appel(this);

        this.peinture = convertirCouleur(couleur);
        this.centreX = centreX;
        this.centreY = centreY;
    }

    private Paint convertirCouleur(String couleur) {
        J.appel(this);

        Paint peinture = new Paint();
        peinture.setColor(Color.BLACK);

        switch(couleur){
            case "blue":
                peinture.setColor(Color.BLUE);
                break;

            case "orange":
                peinture.setColor(Color.YELLOW);
                break;

            case "red":
                peinture.setColor(Color.RED);
                break;
        }

        return peinture;
    }

    public abstract void dessiner(Canvas canvas);
}

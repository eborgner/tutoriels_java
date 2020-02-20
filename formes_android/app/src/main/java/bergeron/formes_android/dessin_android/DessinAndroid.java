package bergeron.formes_android.dessin_android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import formes.Dessin;

public class DessinAndroid extends View implements Dessin {

    private String couleurCourante = "black";

    private List<Forme> formes = new ArrayList<>();

    public DessinAndroid(Context context) {
        super(context);
        J.appel(this);
    }

    public DessinAndroid(Context context, AttributeSet attrs) {
        super(context, attrs);
        J.appel(this);
    }

    public DessinAndroid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        J.appel(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        J.appel(this);

        for(Forme forme : formes){

            forme.dessiner(canvas);
        }
    }

    @Override
    public void changerCouleur(String couleur) {
        J.appel(this);

        this.couleurCourante = couleur;
    }

    @Override
    public void dessinerCarre(double centreX, double centreY, double taille) {
        J.appel(this);

        formes.add(new Carre(couleurCourante, (float) centreX, (float) centreY, (float) taille));
        invalidate();
    }

    @Override
    public void dessinerRectangle(double centreX, double centreY, double largeur, double hauteur) {
        J.appel(this);

        formes.add(new Rectangle(couleurCourante, (float) centreX, (float) centreY, (float) largeur, (float) hauteur));
        invalidate();
    }

    @Override
    public void dessinerCercle(double centreX, double centreY, double rayon) {
        J.appel(this);

        formes.add(new Cercle(couleurCourante, (float) centreX, (float) centreY, (float) rayon));
        invalidate();
    }
}

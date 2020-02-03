package mathieubergeron.pong_android.activites.vues.composants;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun.modeles.monde2d.Monde2DLectureSeule;
import commun.modeles.monde2d.Objet2DLectureSeule;
import commun.modeles.monde2d.VueMonde2D;
import commun_android.vues.composants.CanvasAjustable;
import commun_client.commandes.FabriqueCommande;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongPourEnvoi;
import pong_client.vues.VuePartieLocale;

public class TablePong extends CanvasAjustable {

	private Paint couleurBase;
	private List<Objet2DCanvas> objets2D = new ArrayList<>();

	private AggrandirTablePongPourEnvoi aggrandirTablePong;

	public TablePong(Context context) {
		super(context);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		J.appel(this);
	}

	@Override
	protected void reagirNouvelleTaille(int largeur, int hauteur, int ancienneLargeur, int ancienneHauteur) {
		J.appel(this);

		/*
		aggrandirTablePong.setDimension(Dimension.LARGEUR);
		aggrandirTablePong.setFacteurAggrandissement(calculerFacteurAggrandissement(ancienneLargeur, largeur));
		aggrandirTablePong.envoyerCommande();

		aggrandirTablePong.setDimension(Dimension.HAUTEUR);
		aggrandirTablePong.setFacteurAggrandissement(calculerFacteurAggrandissement(ancienneHauteur, hauteur));
		aggrandirTablePong.envoyerCommande();
		 */
	}

	private double calculerFacteurAggrandissement(double ancienneTaille, double nouvelleTaille) {
		J.appel(this);

		double facteurAggrandissement = 1;

		if(ancienneTaille != 0) {

			facteurAggrandissement =  nouvelleTaille / ancienneTaille;
		}

		return facteurAggrandissement;
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		J.appel(this);

		initialiser();
		obtenirCommandesPourEnvoi();
	}

	private void obtenirCommandesPourEnvoi() {
		J.appel(this);

		//aggrandirTablePong = FabriqueCommande.obtenirCommandePourEnvoi(AggrandirTablePong.class);
	}

	private void initialiser(){
		J.appel(this);

		couleurBase = new Paint(Paint.ANTI_ALIAS_FLAG);
		couleurBase.setStyle(Paint.Style.FILL);
		couleurBase.setColor(Color.BLUE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		J.appel(this);

		for(Objet2DCanvas objet2D : objets2D){

			switch(objet2D.getForme()){

				case RECTANGLE:
					float left = objet2D.getCentreXPixels() - objet2D.getLargeurPixels()/2;
					float top = objet2D.getCentreYPixels() - objet2D.getHauteurPixels()/2;
					float right = objet2D.getCentreXPixels() + objet2D.getLargeurPixels()/2;
					float bottom = objet2D.getCentreYPixels() + objet2D.getHauteurPixels()/2;

					canvas.drawRect(left, top, right, bottom, couleurBase);
					break;

				case CERCLE:
					canvas.drawCircle(objet2D.getCentreXPixels(), objet2D.getCentreYPixels(), objet2D.getLargeurPixels()/2, couleurBase);
					break;
			}
		}
	}

	public void afficherMonde2D(Monde2DLectureSeule monde2D) {
		J.appel(this);

		objets2D.clear();

		float conversionMetresPixelsX = largeur / (float) monde2D.getLageurMetres();
		float conversionMetresPixelsY = hauteur / (float) monde2D.getHauteurMetres();

		for(Objet2DLectureSeule objet2D : monde2D.getObjets2D()) {

			Objet2DCanvas objet2DCanvas = new Objet2DCanvas(objet2D,
															conversionMetresPixelsX,
															conversionMetresPixelsY,
															hauteur);

			objets2D.add(objet2DCanvas);
		}

		invalidate();
	}

	public void afficherFPS(double fps) {
		J.appel(this);

	}

	public void viderCanvas() {
		J.appel(this);
		objets2D.clear();
		invalidate();
	}
}

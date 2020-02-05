package mathieubergeron.pong_android.activites.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

import commun.debogage.J;
import commun.enumerations.Direction;
import commun.modeles.monde2d.Monde2DLectureSeule;
import commun_client.commandes.FabriqueCommande;
import mathieubergeron.pong_android.R;
import mathieubergeron.pong_android.activites.vues.composants.TablePong;
import pong.enumerations.Cadran;
import pong_client.commandes.deplacer_palette.DeplacerPalette;
import pong_client.commandes.deplacer_palette.DeplacerPalettePourEnvoi;
import pong_client.commandes.stopper_palette.StopperPalette;
import pong_client.commandes.stopper_palette.StopperPalettePourEnvoi;
import pong_client.vues.VuePartieLocale;

public class VuePartieLocaleAndroid extends ConstraintLayout implements VuePartieLocale {


	private TablePong tablePong;
	private Button boutonGaucheHaut;
	private Button boutonGaucheBas;
	private Button boutonDroitHaut;
	private Button boutonDroitBas;

	DeplacerPalettePourEnvoi deplacerPalettePourEnvoi;
	StopperPalettePourEnvoi stopperPalettePourEnvoi;

	public VuePartieLocaleAndroid(Context context) {
		super(context);
		J.appel(this);
	}

	public VuePartieLocaleAndroid(Context context, AttributeSet attrs) {
		super(context, attrs);
		J.appel(this);
	}

	public VuePartieLocaleAndroid(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		J.appel(this);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		J.appel(this);

		tablePong = findViewById(R.id.table_pong);
		boutonGaucheHaut = findViewById(R.id.bouton_gauche_haut);
		boutonGaucheBas = findViewById(R.id.bouton_gauche_bas);
		boutonDroitHaut = findViewById(R.id.bouton_droite_haut);
		boutonDroitBas = findViewById(R.id.bouton_droite_bas);
	}

	@Override
	public void viderMonde() {
		J.appel(this);

		tablePong.viderCanvas();
	}

	@Override
	public void afficherMonde2D(Monde2DLectureSeule monde2D) {
		J.appel(this);

		tablePong.afficherMonde2D(monde2D);
	}

	@Override
	public void afficherFPS(double fps) {
		J.appel(this);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		deplacerPalettePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(DeplacerPalette.class);
		stopperPalettePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(StopperPalette.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		boutonGaucheHaut.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				J.appel(this);
				switch(motionEvent.getAction()){
					case MotionEvent.ACTION_DOWN:
						deplacerPalettePourEnvoi.setCadran(Cadran.GAUCHE);
						deplacerPalettePourEnvoi.setDirection(Direction.HAUT);
						deplacerPalettePourEnvoi.envoyerCommande();
						break;

					case MotionEvent.ACTION_UP:
						stopperPalettePourEnvoi.setCadran(Cadran.GAUCHE);
						stopperPalettePourEnvoi.envoyerCommande();
						break;
				}
				return false;
			}
		});

		boutonGaucheBas.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				J.appel(this);
				switch(motionEvent.getAction()){
					case MotionEvent.ACTION_DOWN:
						deplacerPalettePourEnvoi.setCadran(Cadran.GAUCHE);
						deplacerPalettePourEnvoi.setDirection(Direction.BAS);
						deplacerPalettePourEnvoi.envoyerCommande();
						break;

					case MotionEvent.ACTION_UP:
						stopperPalettePourEnvoi.setCadran(Cadran.GAUCHE);
						stopperPalettePourEnvoi.envoyerCommande();
						break;
				}
				return false;
			}
		});


	}
}

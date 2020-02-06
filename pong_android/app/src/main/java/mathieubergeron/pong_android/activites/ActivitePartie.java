package mathieubergeron.pong_android.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import commun_android.Initialisateur;
import commun_client.mvc.controleurs.FabriqueControleur;
import mathieubergeron.pong_android.R;
import mathieubergeron.pong_android.activites.controleurs.ControleurPartieLocaleAndroid;
import mathieubergeron.pong_android.activites.vues.VuePartieLocaleAndroid;
import mathieubergeron.pong_android.activites.vues.composants.TablePong;
import pong.modeles.partie.Partie;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.controleurs.ControleurPartieLocale;
import pong_client.vues.VuePartieLocale;

public class ActivitePartie extends AppCompatActivity {

	static{

		Initialisateur.initialiser();
	}

	private ControleurPartieLocaleAndroid controleurPartieLocale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_partie);

		VuePartieLocale page = findViewById(R.id.page_partie);

		Partie partie = new Partie();

		AfficheurPartie afficheur = new AfficheurPartie();

		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocaleAndroid.class, partie, page, afficheur);
	}

	@Override
	protected void onResume() {
		super.onResume();

	}
}

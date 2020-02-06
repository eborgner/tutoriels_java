package mathieubergeron.pong_android.activites.controleurs;

import android.animation.TimeAnimator;

import commun.debogage.J;
import mathieubergeron.pong_android.activites.vues.composants.TablePong;
import pong_client.controleurs.ControleurPartieLocale;

public class ControleurPartieLocaleAndroid extends ControleurPartieLocale {

	@Override
	public void demarrer() {
		J.appel(this);

		TimeAnimator timeAnimator = new TimeAnimator();

		timeAnimator.setTimeListener(new TimeAnimator.TimeListener() {
			@Override
			public void onTimeUpdate(TimeAnimator timeAnimator, long l, long l1) {
				J.setActif(false);
				J.appel(this);

				double tempsEcouleSecondes = (double)l1 / 1000.0;

				TablePong.tempsEcouleSecondes += tempsEcouleSecondes;

				modele.reagirTempsQuiPasse(tempsEcouleSecondes);

				afficheur.rafraichirAffichage(modele, vue);

				J.setActif(true);
			}
		});

		timeAnimator.start();



	}
}

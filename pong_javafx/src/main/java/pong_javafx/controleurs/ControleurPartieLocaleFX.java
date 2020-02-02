package pong_javafx.controleurs;

import commun.debogage.J;
import javafx.animation.AnimationTimer;
import pong_client.controleurs.ControleurPartieLocale;

public class ControleurPartieLocaleFX extends ControleurPartieLocale {
	
	@Override
	public void demarrer() {
		J.appel(this);
		
		new AnimationTimer() {
			
			private long avant = System.nanoTime();

			@Override
			public void handle(long maintenant) {
				J.setActif(false);

				J.appel(this);
				
				double tempsEcouleSecondes = (maintenant - avant) / 1E9;
				
				reagirTempsQuiPasse(tempsEcouleSecondes);
				
				avant = maintenant;

				J.setActif(true);
			}

			
		}.start();
	}
}

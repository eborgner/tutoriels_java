package pong_javafx.controleurs;

import commun.debogage.J;
import javafx.animation.AnimationTimer;
import pong_client.controleurs.ControleurPartieLocale;
import pong_javafx.Constantes;

public class ControleurPartieLocaleFX extends ControleurPartieLocale {
	
	private AnimationTimer animationTimer;
	
	@Override
	public void demarrer() {
		J.appel(this);
		
		creerAnimation();
		
		animationTimer.start();
	}
	
	private void creerAnimation() {
		J.appel(this);

		animationTimer = new AnimationTimer() {
			
			private long avant = System.nanoTime();

			@Override
			public void handle(long maintenant) {
				J.setActif(false);

				J.appel(this);
				
				double tempsEcouleSecondes = (maintenant - avant) / 1E9;
				
				if(tempsEcouleSecondes >= Constantes.FREQUENCE_RAFRAICHISSEMENT) {

					reagirTempsQuiPasse(tempsEcouleSecondes);
					avant = maintenant;
				}

				J.setActif(true);
			}
		};
	}
}

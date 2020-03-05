package tp01_temps_reel_javafx.controleurs;

import commun.debogage.J;
import javafx.animation.AnimationTimer;
import tp01_temps_reel_client.controleurs.ControleurPartieLocale;
import tp01_temps_reel_javafx.Constantes;
import tp01_temps_reel_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_temps_reel_javafx.vues.VuePartieLocaleFX;

public class ControleurPartieLocaleFX extends ControleurPartieLocale<VuePartieLocaleFX, AfficheurPartieLocaleFX> { 
	
	@Override
	protected void demarrer() {
		J.appel(this);
		
		installerChronometre();
	}
	
	private void installerChronometre(){
		J.appel(this);
		
		new AnimationTimer() {
			
			private double dernierAffichageNanosecondes;
			private double secondesEcouleesMax = 1 / Constantes.FPS_MAX;
			
			@Override
			public void start() {
				J.appel(this);
				
				dernierAffichageNanosecondes = System.nanoTime();
			}

			@Override
			public void handle(long maintenantNanosecondes) {
				J.setActif(false);
				J.appel(this);
				
				double secondesEcoulees = (maintenantNanosecondes - dernierAffichageNanosecondes) / 1E9;
				
				if(secondesEcoulees >= secondesEcouleesMax) {

					dernierAffichageNanosecondes = maintenantNanosecondes;
					reagirAuTempsQuiPasse(secondesEcoulees);
				}

				J.setActif(true);
			}
		};
	}
}

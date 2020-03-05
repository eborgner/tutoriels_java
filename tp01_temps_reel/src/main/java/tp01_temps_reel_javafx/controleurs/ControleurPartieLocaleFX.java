package tp01_temps_reel_javafx.controleurs;

import commun.debogage.J;
import javafx.animation.AnimationTimer;
import tp01_temps_reel_client.controleurs.ControleurPartieLocale;
import tp01_temps_reel_javafx.Constantes;
import tp01_temps_reel_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_temps_reel_javafx.vues.VuePartieLocaleFX;

public class ControleurPartieLocaleFX extends ControleurPartieLocale<VuePartieLocaleFX, AfficheurPartieLocaleFX> { 
	
	AnimationTimer chronometre;
	
	@Override
	protected void demarrer() {
		J.appel(this);
		
		installerChronometre();
		
		chronometre.start();
	}
	
	private void installerChronometre(){
		J.appel(this);
		
		chronometre =new AnimationTimer() {
			
			private double dernierAffichageNanosecondes;
			private double secondesEcouleesMax = 1.0 / Constantes.FPS_MAX;
			
			@Override
			public void start() {
				super.start();
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

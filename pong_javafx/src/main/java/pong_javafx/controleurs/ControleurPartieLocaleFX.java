package pong_javafx.controleurs;

import org.java_websocket.WebSocket;

import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun.messages.MessageRecu;
import commun.messages.RecepteurMessage;
import commun_client.messages.EnvoyeurMessageClient;
import javafx.animation.AnimationTimer;
import pong.messages.MessageDebutPartie;
import pong.modeles.partie.table_pong.Balle;
import pong_client.controleurs.ControleurPartieLocale;
import pong_javafx.Constantes;

public class ControleurPartieLocaleFX extends ControleurPartieLocale {
	
	private AnimationTimer animationTimer;
	
	private long nanoSecondesDebutPartie;
	private long nanoSecondesDepuisDebutPartie;
	
	@Override
	public void demarrer() {
		J.appel(this);
		
		creerAnimation();
		
		animationTimer.start();
		
		RecepteurMessage.preparerReception(MessageDebutPartie.class, new MessageRecu<MessageDebutPartie>() {

			@Override
			public void reagirMessageRecuSur(WebSocket webSocket, MessageDebutPartie message) {
				J.appel(this);
				
				Balle balle = message.getBalle();
				
				// synchroniser le début de partie
				nanoSecondesDebutPartie = System.nanoTime();
				nanoSecondesDepuisDebutPartie = 0;
				
				modele.setBalle(balle);
			}
		});
	}
	
	private void creerAnimation() {
		J.appel(this);

		animationTimer = new AnimationTimer() {
			
			private long nanoSecondesDernierAffichage;
			
			@Override
			public void start() {
				J.appel(this);
				
				nanoSecondesDebutPartie = System.nanoTime();
				nanoSecondesDernierAffichage = nanoSecondesDebutPartie;
				
				MessageDebutPartie messageDebutPartie = new MessageDebutPartie();
				
				messageDebutPartie.setBalle(modele.getBalle());
				
				EnvoyeurMessageClient.envoyer(messageDebutPartie);
				
				super.start();
			}

			@Override
			public void handle(long maintenant) {
				J.setActif(false);

				J.appel(this);
				
				long nanoSecondesDepuisDernierAffichage = maintenant - nanoSecondesDernierAffichage;
				
				double secondesDepuisDernierTick = nanoSecondesDepuisDernierAffichage / 1E9;
				
				if(secondesDepuisDernierTick >= Constantes.FREQUENCE_RAFRAICHISSEMENT) {

					reagirTempsQuiPasse(secondesDepuisDernierTick);
					nanoSecondesDernierAffichage = maintenant;
				}

				J.setActif(true);
			}
		};
	}
}

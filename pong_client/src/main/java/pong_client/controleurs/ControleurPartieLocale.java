package pong_client.controleurs;

import java.util.Map;

import org.java_websocket.WebSocket;

import commun.debogage.J;
import commun.messages.MessageRecu;
import commun.messages.RecepteurMessage;
import commun_client.messages.EnvoyeurMessageClient;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import pong.enumerations.Cadran;
import pong.messages.MessageSynchroniser;
import pong.modeles.partie.Partie;
import pong.modeles.partie.PartieLectureSeule;
import pong.modeles.partie.table_pong.Balle;
import pong.modeles.partie.table_pong.Palette;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongRecue;
import pong_client.commandes.deplacer_palette.DeplacerPalette;
import pong_client.commandes.deplacer_palette.DeplacerPaletteRecue;
import pong_client.commandes.stopper_palette.StopperPalette;
import pong_client.commandes.stopper_palette.StopperPaletteRecue;
import pong_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale extends ControleurModeleVue<PartieLectureSeule,
                                                                Partie,
                                                                VuePartieLocale,
                                                                AfficheurPartie> {
    
    private static final double DELAIS_FPS_SECONDES = 1.0;
    private double secondesDepuisDernierCalculFPS = 0;
    private long affichagesDepuisDernierCalculFPS = 0;
    private double fpsCourant = 0;

    @Override
    public void installerReceptionCommandes() {
        J.appel(this);
        
        installerRecepteurCommande(AggrandirTablePong.class, new RecepteurCommandeMVC<AggrandirTablePongRecue>() {
            @Override
            public void executerCommandeMVC(AggrandirTablePongRecue commande) {
                J.appel(this);
                
                //modele.aggrandirTablePong(commande.getDimension(), commande.getFacteurAggrandissement());
            }
        });
        
        installerRecepteurCommande(DeplacerPalette.class, new RecepteurCommandeMVC<DeplacerPaletteRecue>() {
            @Override
            public void executerCommandeMVC(DeplacerPaletteRecue commande) {
                J.appel(this);
                
                modele.deplacerPalette(commande.getCadran(), commande.getDirection());
                envoyerMessageSynchroniser();
            }
        });
        
        installerRecepteurCommande(StopperPalette.class, new RecepteurCommandeMVC<StopperPaletteRecue>() {
            @Override
            public void executerCommandeMVC(StopperPaletteRecue commande) {
                J.appel(this);
                
                modele.stopperPalette(commande.getCadran());
                envoyerMessageSynchroniser();
            }
        });
        
        RecepteurMessage.preparerReception(MessageSynchroniser.class, new MessageRecu<MessageSynchroniser>(){
			@Override
			public void reagirMessageRecuSur(WebSocket webSocket, MessageSynchroniser message) {
				J.appel(this);
				
				J.valeurs(System.nanoTime());

				Balle balle = message.getBalle();
				Map<Cadran, Palette> palettes = message.getPalettes();

				// XXX: stopper les palettes
				//      la palette va trop bouger de l'autre côté
				for(Palette palette : palettes.values()) {

					palette.stopper();
				}
				
				modele.setBalle(balle);
				modele.setPalettes(palettes);
			}
        });
    }

    private void envoyerMessageSynchroniser() {
    	J.appel(this);
    	
    	Balle balle = modele.getBalle();
    	Map<Cadran, Palette> palettes = modele.getPalettes();
    	
    	MessageSynchroniser messageSynchroniser = new MessageSynchroniser();
    	
    	messageSynchroniser.setBalle(balle);
    	messageSynchroniser.setPalettes(palettes);
    	
    	EnvoyeurMessageClient.envoyer(messageSynchroniser);
    }

    protected void reagirTempsQuiPasse(double tempsEcouleSecondes) {
        J.appel(this);
        

        modele.reagirTempsQuiPasse(tempsEcouleSecondes);
        afficheur.rafraichirAffichage((PartieLectureSeule) modele, vue);

        vue.afficherFPS(fpsCourant);

        secondesDepuisDernierCalculFPS += tempsEcouleSecondes;
        affichagesDepuisDernierCalculFPS++;

        J.valeurs(secondesDepuisDernierCalculFPS);

        if(secondesDepuisDernierCalculFPS >= DELAIS_FPS_SECONDES) {
            
            fpsCourant = affichagesDepuisDernierCalculFPS / secondesDepuisDernierCalculFPS;
            
            secondesDepuisDernierCalculFPS = 0;
            affichagesDepuisDernierCalculFPS = 0;
        }
    }
}

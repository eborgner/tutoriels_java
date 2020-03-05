package tp01_temps_reel_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp01_temps_reel.modeles.partie_locale.PartieLocale;
import tp01_temps_reel_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_temps_reel_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_temps_reel_client.controleurs.ControleurAccueil;
import tp01_temps_reel_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_temps_reel_javafx.vues.VuePartieLocaleFX;
import tp01_temps_reel_javafx.vues.VueAccueilFX;

import static tp01_temps_reel_javafx.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	private PartieLocale partie = new PartieLocale();
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(NouvellePartie.class, new RecepteurCommandeMVC<NouvellePartieRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
			}
		});
	}

	private void nouvellePartieLocale() {
		J.appel(this);

		partie = new PartieLocale();
		instancierMVCPartieLocale();
	}
	
	private void instancierMVCPartieLocale() {
		J.appel(this);
		
		VuePartieLocaleFX vuePartie = vue.creerVuePartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partie, vuePartie, afficheur);
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		instancierMVCPartieLocale();
	}
}

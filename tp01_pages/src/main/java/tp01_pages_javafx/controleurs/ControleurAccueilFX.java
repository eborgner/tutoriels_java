package tp01_pages_javafx.controleurs;

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
import tp01_pages.modeles.parametres.Parametres;
import tp01_pages.modeles.parametres.ParametresLectureSeule;
import tp01_pages.modeles.partie_locale.PartieLocale;
import tp01_pages_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_pages_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_pages_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_pages_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp01_pages_client.commandes.quitter.Quitter;
import tp01_pages_client.commandes.quitter.QuitterRecue;
import tp01_pages_client.commandes.retour_accueil.RetourAccueil;
import tp01_pages_client.commandes.retour_accueil.RetourAccueilRecue;
import tp01_pages_client.controleurs.ControleurAccueil;
import tp01_pages_javafx.afficheurs.AfficheurParametresFX;
import tp01_pages_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_pages_javafx.vues.VuePartieLocaleFX;
import tp01_pages_javafx.vues.VueAccueilFX;
import tp01_pages_javafx.vues.VueParametresFX;

import static tp01_pages_javafx.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	
	private Scene sceneParametres;
	private Stage dialogueParametres;
	
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	
	
	
	private void ouvrirParametres() {
		J.appel(this);

		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
	}

	private void fermerParametres() {
		J.appel(this);
		
		if(dialogueParametres != null) {
			
			dialogueParametres.close();
		}
	}

	@Override
	protected void demarrer() {
		J.appel(this);
	}
}

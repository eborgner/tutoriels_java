package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartie;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartieRecue;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterRecue;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_javafx.afficheurs.AfficheurPartieLocaleFX;
import quatredesuite_javafx.vues.VuePartieLocaleFX;
import quatredesuite_javafx.vues.VuePrincipaleFX;
import static quatredesuite_javafx.Constantes.*;

@SuppressWarnings("rawtypes")
public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {

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

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);
				
				Systeme.quitter();
			}
		});
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);
		
		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		PartieLocale partie = new PartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partie, vuePartieLocale, afficheur);
		
	}
	
	private void ouvrirParametres() {
		J.appel(this);

		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		Scene scene = chargeur.nouvelleScene(400, 300);
		
		DialogueModal.ouvrirDialogueModal(scene);
	}

	@Override
	protected void demarrer() {
		J.appel(this);
		
	}

}

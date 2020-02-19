package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.ReactionApresCommande;
import commun_client.commandes.RecepteurCommande;
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
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrillePourEnvoi;
import quatredesuite_client.controleurs.ControleurPartieLocale;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_javafx.afficheurs.AfficheurPartieLocaleFX;
import quatredesuite_javafx.vues.VuePartieLocaleFX;
import quatredesuite_javafx.vues.VuePrincipaleFX;
import static quatredesuite_javafx.Constantes.*;

public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {
	
	ViderGrillePourEnvoi viderGrillePourEnvoi;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);
				
				Systeme.quitter();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});
		
		FabriqueCommande.installerRecepteur(NouvellePartie.class, new RecepteurCommande<NouvellePartieRecue>() {
			@Override
			public void executerCommande(NouvellePartieRecue nouvellePartieRecue) {
				J.appel(this);

				// FIXME: on peut améliorer FabriqueCommande pour mettre à jour les commandes
				viderGrillePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(ViderGrille.class);
				viderGrillePourEnvoi.envoyerCommande();
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

		@SuppressWarnings("rawtypes")
		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		Scene scene = chargeur.nouvelleScene(400, 300);
		
		DialogueModal.ouvrirDialogueModal(scene);
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		nouvellePartieLocale();

		FabriqueCommande.installerReactionApresCommande(ViderGrille.class, new ReactionApresCommande() {
			@Override
			public void reagirApresCommande() {
				J.appel(this);

				nouvellePartieLocale();
			}
		});
	}
}

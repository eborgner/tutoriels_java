package quatredesuite_javafx.controleurs;

import commun.debogage.Erreur;
import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite.modeles.sauvegardes.Sauvegardes;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartieLocale;
import quatredesuite_client.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import quatredesuite_client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import quatredesuite_client.commandes.nouvelle_partie_reseau.NouvellePartieReseauRecue;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametres;
import quatredesuite_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import quatredesuite_client.commandes.ouvrir_sauvegarde.OuvrirSauvegarde;
import quatredesuite_client.commandes.ouvrir_sauvegarde.OuvrirSauvegardeRecue;
import quatredesuite_client.commandes.quitter.Quitter;
import quatredesuite_client.commandes.quitter.QuitterRecue;
import quatredesuite_client.commandes.sauvegarder_partie.SauvegarderPartie;
import quatredesuite_client.commandes.sauvegarder_partie.SauvegarderPartieRecue;
import quatredesuite_client.controleurs.ControleurAccueil;
import quatredesuite_javafx.afficheurs.AfficheurPartieLocaleFX;
import quatredesuite_javafx.afficheurs.AfficheurSauvegardesFX;
import quatredesuite_javafx.vues.VuePartieLocaleFX;
import quatredesuite_javafx.vues.VueSauvegardesFX;
import quatredesuite_javafx.vues.VueAccueilFX;
import static quatredesuite_javafx.Constantes.*;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("rawtypes")
public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	
	private PartieLocale partieLocale;

	@Override
	protected void demarrer() {
		J.appel(this);
		
		afficherSauvegardes();
	}


	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(NouvellePartieLocale.class, new RecepteurCommandeMVC<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
			}
		});
		
		installerRecepteurCommande(SauvegarderPartie.class, new RecepteurCommandeMVC<SauvegarderPartieRecue>() {
			@Override
			public void executerCommandeMVC(SauvegarderPartieRecue commande) {
				J.appel(this);
				
				sauvegarderPartieLocale(commande.getCheminDansHome());
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
		
		installerRecepteurCommande(OuvrirSauvegarde.class, new RecepteurCommandeMVC<OuvrirSauvegardeRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirSauvegardeRecue commande) {
				J.appel(this);
				
				ouvrirSauvegarde(commande.getCheminDansHome());
				
			}
		});
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);

		partieLocale = new PartieLocale();
		partieLocale.initialiser();
		
		instancierMVCPartieLocale();
		
	}


	private void instancierMVCPartieLocale() {
		J.appel(this);

		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partieLocale, vuePartieLocale, afficheur);
	}
	
	private void ouvrirSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		File sauvegarde = Systeme.aPartirCheminDansHome(cheminDansHome);
		
		try {

			partieLocale = Json.aPartirFichier(sauvegarde, PartieLocale.class);

		} catch (IOException e) {
			
			Erreur.fatale(String.format("La sauvegarde '%s' doit être valide", cheminDansHome), e);

		}
		
		instancierMVCPartieLocale();
	}

	private void afficherSauvegardes() {
		J.appel(this);
		
		VueSauvegardesFX vueSauvegardes = vue.creerVueSauvegardes();
		
		Sauvegardes lesSauvegardes = new Sauvegardes();
		
		AfficheurSauvegardesFX afficheur = new AfficheurSauvegardesFX();
		
		FabriqueControleur.creerControleur(ControleurSauvegardesFX.class, lesSauvegardes, vueSauvegardes, afficheur);
	}

	private void sauvegarderPartieLocale(String cheminDansHome) {
		J.appel(this);

		if(partieLocale != null) {
			
			File fichierDansHome = Systeme.aPartirCheminDansHome(cheminDansHome);
			
			try {

				Json.sauvegarder(fichierDansHome, partieLocale);

			} catch (IOException e) {
				
				Erreur.nonFatale(String.format("Impossible d'écrire le fichier %s", fichierDansHome.getPath()), e);

			}
		}
	}
	
	private void ouvrirParametres() {
		J.appel(this);

		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		Scene scene = chargeur.nouvelleScene(400, 300);
		
		DialogueModal.ouvrirDialogueModal(scene);
	}
	
	


}

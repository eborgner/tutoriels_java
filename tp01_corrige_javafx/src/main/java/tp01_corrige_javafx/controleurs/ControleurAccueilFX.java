package tp01_corrige_javafx.controleurs;

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
import tp01_corrige.modeles.parametres.Parametres;
import tp01_corrige.modeles.parametres.ParametresLectureSeule;
import tp01_corrige.modeles.partie_locale.PartieLocale;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametres;
import tp01_corrige_client.commandes.fermer_parametres.FermerParametresRecue;
import tp01_corrige_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_corrige_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_corrige_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_corrige_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp01_corrige_client.commandes.quitter.Quitter;
import tp01_corrige_client.commandes.quitter.QuitterRecue;
import tp01_corrige_client.controleurs.ControleurAccueil;
import tp01_corrige_javafx.afficheurs.AfficheurParametresFX;
import tp01_corrige_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_corrige_javafx.vues.VuePartieLocaleFX;
import tp01_corrige_javafx.vues.VueAccueilFX;
import tp01_corrige_javafx.vues.VueParametresFX;

import static tp01_corrige_javafx.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	private static final Parametres parametres = new Parametres();
	
	public static ParametresLectureSeule getParametres() {
		J.appel(ControleurAccueilFX.class);
		
		return (ParametresLectureSeule) parametres;
	}
	
	private Scene sceneParametres;
	private Stage dialogueParametres;
	private PartieLocale partie = new PartieLocale();
	
	private void instancierMVCParametres(){
		J.appel(this);

		ChargeurDeVue<VueParametresFX> chargeur;
		chargeur = new ChargeurDeVue<VueParametresFX>(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		sceneParametres = chargeur.nouvelleScene(400, 300);
		
		VueParametresFX vueParametresFX = chargeur.getVue();

		AfficheurParametresFX afficheurParametresFX = new AfficheurParametresFX();

		FabriqueControleur.creerControleur(ControleurParametresFX.class, parametres, vueParametresFX, afficheurParametresFX);
	}
	
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

		installerRecepteurCommande(FermerParametres.class, new RecepteurCommandeMVC<FermerParametresRecue>() {
			@Override
			public void executerCommandeMVC(FermerParametresRecue commande) {
				J.appel(this);
				
				fermerParametres();
			}
		});
		
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

		instancierMVCPartieLocale();
		instancierMVCParametres();
	}
}

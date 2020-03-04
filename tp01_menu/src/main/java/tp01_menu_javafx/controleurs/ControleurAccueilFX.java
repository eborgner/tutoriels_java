package tp01_menu_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import commun_javafx.ChargeurDeVue;
import commun_javafx.DialogueModal;
import javafx.scene.Scene;
import tp01_menu.modeles.parametres.Parametres;
import tp01_menu.modeles.parametres.ParametresLectureSeule;
import tp01_menu.modeles.partie_locale.PartieLocale;
import tp01_menu_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_menu_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_menu_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_menu_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp01_menu_client.commandes.quitter.Quitter;
import tp01_menu_client.commandes.quitter.QuitterRecue;
import tp01_menu_client.controleurs.ControleurAccueil;
import tp01_menu_javafx.afficheurs.AfficheurParametresFX;
import tp01_menu_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_menu_javafx.vues.VuePartieLocaleFX;
import tp01_menu_javafx.vues.VueAccueilFX;
import tp01_menu_javafx.vues.VueParametresFX;

import static tp01_menu_javafx.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	private static final Parametres parametres = new Parametres();
	
	public static ParametresLectureSeule getParametres() {
		J.appel(ControleurAccueilFX.class);
		
		return (ParametresLectureSeule) parametres;
	}
	
	private VueParametresFX vueParametresFX;
	private AfficheurParametresFX afficheurParametresFX;
	private Scene sceneParametres;
	
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
				
				nouvellePartieLocale();
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
	
	
	private void creerMVCParametres(){
		J.appel(this);

		ChargeurDeVue<VueParametresFX> chargeur;
		chargeur = new ChargeurDeVue<VueParametresFX>(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		sceneParametres = chargeur.nouvelleScene(400, 300);
		
		vueParametresFX = chargeur.getVue();

		afficheurParametresFX = new AfficheurParametresFX();

		FabriqueControleur.creerControleur(ControleurParametresFX.class, parametres, vueParametresFX, afficheurParametresFX);
	}

	private void ouvrirParametres() {
		J.appel(this);

		DialogueModal.ouvrirDialogueModal(sceneParametres);
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		nouvellePartieLocale();
		creerMVCParametres();
	}


	public void reafficherVues() {
		J.appel(this);

	}
}

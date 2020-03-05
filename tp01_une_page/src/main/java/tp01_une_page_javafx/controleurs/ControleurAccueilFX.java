package tp01_une_page_javafx.controleurs;

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
import tp01_une_page.modeles.parametres.Parametres;
import tp01_une_page.modeles.parametres.ParametresLectureSeule;
import tp01_une_page.modeles.partie_locale.PartieLocale;
import tp01_une_page_client.commandes.fermer_parametres.FermerParametres;
import tp01_une_page_client.commandes.fermer_parametres.FermerParametresRecue;
import tp01_une_page_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_une_page_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_une_page_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_une_page_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp01_une_page_client.commandes.quitter.Quitter;
import tp01_une_page_client.commandes.quitter.QuitterRecue;
import tp01_une_page_client.controleurs.ControleurAccueil;
import tp01_une_page_javafx.afficheurs.AfficheurParametresFX;
import tp01_une_page_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_une_page_javafx.vues.VuePartieLocaleFX;
import tp01_une_page_javafx.vues.VueAccueilFX;
import tp01_une_page_javafx.vues.VueParametresFX;

import static tp01_une_page_javafx.Constantes.*;

public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {
	
	private static final Parametres parametres = new Parametres();
	
	public static ParametresLectureSeule getParametres() {
		J.appel(ControleurAccueilFX.class);
		
		return (ParametresLectureSeule) parametres;
	}
	
	private PartieLocale partie = new PartieLocale();
	
	private void instancierMVCParametres(){
		J.appel(this);
		
		VueParametresFX vueParametresFX = vue.creerVueParametres();

		AfficheurParametresFX afficheurParametresFX = new AfficheurParametresFX();

		FabriqueControleur.creerControleur(ControleurParametresFX.class, parametres, vueParametresFX, afficheurParametresFX);
	}
	
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
		instancierMVCParametres();
	}
}

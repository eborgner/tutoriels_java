package tp01_pages_javafx.controleurs;

import java.util.Locale;

import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import tp01_pages.modeles.parametres.Parametres;
import tp01_pages.modeles.parametres.ParametresLectureSeule;
import tp01_pages.modeles.partie_locale.PartieLocale;
import tp01_pages_client.commandes.changer_locale.ChangerLocale;
import tp01_pages_client.commandes.changer_locale.ChangerLocaleRecue;
import tp01_pages_client.commandes.nouvelle_partie.NouvellePartie;
import tp01_pages_client.commandes.nouvelle_partie.NouvellePartieRecue;
import tp01_pages_client.commandes.ouvrir_parametres.OuvrirParametres;
import tp01_pages_client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp01_pages_client.commandes.retour_accueil.RetourAccueil;
import tp01_pages_client.commandes.retour_accueil.RetourAccueilRecue;
import tp01_pages_client.controleurs.ControleurPages;
import tp01_pages_javafx.afficheurs.AfficheurParametresFX;
import tp01_pages_javafx.afficheurs.AfficheurPartieLocaleFX;
import tp01_pages_javafx.vues.VueAccueilFX;
import tp01_pages_javafx.vues.VuePagesFX;
import tp01_pages_javafx.vues.VueParametresFX;
import tp01_pages_javafx.vues.VuePartieLocaleFX;

public class ControleurPagesFX extends ControleurPages<VuePagesFX> {

	private static final Parametres parametres = new Parametres();
	
	public static ParametresLectureSeule getParametres() {
		J.appel(ControleurAccueilFX.class);
		
		return (ParametresLectureSeule) parametres;
	}
	
	

	private PartieLocale partie = new PartieLocale();

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				vue.afficherPageParametres();
			}
		});

		installerRecepteurCommande(RetourAccueil.class, new RecepteurCommandeMVC<RetourAccueilRecue>() {
			@Override
			public void executerCommandeMVC(RetourAccueilRecue commande) {
				J.appel(this);
				
				vue.afficherPageAccueil();
			}
		});
		
		installerRecepteurCommande(NouvellePartie.class, new RecepteurCommandeMVC<NouvellePartieRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
				vue.afficherPagePartieLocale();
			}
		});
		
		installerRecepteurCommande(ChangerLocale.class, new RecepteurCommandeMVC<ChangerLocaleRecue>() {
			@Override
			public void executerCommandeMVC(ChangerLocaleRecue commande) {
				J.appel(this);
				
				Locale.setDefault(commande.getLocale());
				
				instancierMVCParametres();
				instancierMVCAccueil();
			}
		});
	}
	
	@Override
	protected void demarrer() {
		J.appel(this);
		
		instancierMVCParametres();
		instancierMVCAccueil();
	}


	private void instancierMVCParametres(){
		J.appel(this);

		VueParametresFX vueParametresFX = vue.creerVueParametres();

		AfficheurParametresFX afficheurParametresFX = new AfficheurParametresFX();

		FabriqueControleur.creerControleur(ControleurParametresFX.class, parametres, vueParametresFX, afficheurParametresFX);
	}

	private void instancierMVCAccueil(){
		J.appel(this);

		VueAccueilFX vueAcceuil = vue.creerVueAccueil();

		FabriqueControleur.creerControleur(ControleurAccueilFX.class, vueAcceuil);
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

}

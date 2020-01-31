package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.ReactionApresCommande;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import quatredesuite.modeles.partie.Partie;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.commandes.nouvelle_partie_locale.NouvellePartieLocaleRecue;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrillePourEnvoi;
import quatredesuite_client.controleurs.ControleurPartieLocale;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_javafx.vues.VueParametresFX;

public class ControleurPrincipalFX extends ControleurPrincipal {

	protected ControleurPartieLocale controleurPartieLocale;
	
	@Override
	protected void nouvellePartieLocale(NouvellePartieLocaleRecue commande) {
		J.appel(this);
		
		if(siPartieLocaleExisteDeja()) {

			animerVidagePuisCreerNouvellePartieLocale(commande);

		}else {
			
			creerNouvellePartieLocale();
			commande.notifierCommandeTraitee();

		}
	}
	
	private boolean siPartieLocaleExisteDeja() {
		J.appel(this);
		
		return controleurPartieLocale != null;
	}
	
	private void animerVidagePuisCreerNouvellePartieLocale(NouvellePartieLocaleRecue commande) {
		J.appel(this);

		FabriqueCommande.installerReactionApresCommande(ViderGrille.class, new ReactionApresCommande() {
			@Override
			public void reagirApresCommande() {
				J.appel(this);

				creerNouvellePartieLocale();
				commande.notifierCommandeTraitee();
			}
		});
		
		ViderGrillePourEnvoi viderGrille = FabriqueCommande.obtenirCommandePourEnvoi(ViderGrille.class);
		viderGrille.envoyerCommande();
		
	}
	
	private void creerNouvellePartieLocale() {
		J.appel(this);

		detruireAnciennePartieLocale();

		VuePartieLocale vuePartieLocale = vue.creerVuePartieLocale();
		
		Partie partieLocale = new Partie();
		
		AfficheurPartie afficheurPartie = new AfficheurPartie();

		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
				partieLocale, 
				vuePartieLocale,
				afficheurPartie);
	}

	private void detruireAnciennePartieLocale() {
		J.appel(this);

		if(controleurPartieLocale != null) {
			controleurPartieLocale.detruire();
			vue.detruireVuePartieLocale();
		}
	}

	@Override
	public void detruire() {
		J.appel(this);

		controleurPartieLocale.detruire();
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		// rien
	}

	@Override
	protected void ouvrirParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>(CHEMIN_PARAMETRES_FXML,
						CHEMIN_PRINCIPAL_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
        Stage fenetreModale = new Stage();
        fenetreModale.setScene(scene);
        fenetreModale.initOwner(fenetrePrincipale);
        fenetreModale.initModality(Modality.APPLICATION_MODAL);
        fenetreModale.showAndWait();



		
	}

	@Override
	protected void quitter() {
		J.appel(this);

		Systeme.quitter();
	}
}

package quatredesuite_client.controleurs;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import commun_client.mvc.controleurs.ControleurModeleVue;
import quatredesuite.modeles.partie.Partie;
import quatredesuite.modeles.partie.PartieLectureSeule;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciRecue;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPartieLocale extends ControleurModeleVue<Partie, VuePartieLocale, AfficheurPartie> {
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		// FIXME: devrait être appelé automatiquement
		afficheur.initialiserAffichage((PartieLectureSeule) modele, vue);
		
		FabriqueCommande.installerRecepteur(JouerIci.class, new RecepteurCommande<JouerIciRecue>() {

			@Override
			public void executerCommande(JouerIciRecue commande) {
				J.appel(this);
				
				int idColonne = commande.getIdColonne();
				modele.jouerIci(idColonne);
				
				commande.notifierCommandeTraitee();
				
				// FIXME: il faut plutôt mettre une ReactionApresCommande
				afficheur.rafraichirAffichage((PartieLectureSeule) modele, vue);
			}
		});
		
	}

	@Override
	public void detruire() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
	} 
	
}

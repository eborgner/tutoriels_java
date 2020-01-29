package quatredesuite_javafx.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import quatredesuite.modeles.partie.Partie;
import quatredesuite_client.afficheurs.AfficheurPartie;
import quatredesuite_client.controleurs.ControleurPartieLocale;
import quatredesuite_client.controleurs.ControleurPrincipal;
import quatredesuite_client.vues.VuePartieLocale;

public class ControleurPrincipalFX extends ControleurPrincipal {

	@Override
	protected void nouvellePartieLocale() {
		J.appel(this);

		if(controleurPartieLocale != null) {
			controleurPartieLocale.detruire();
			vue.detruireVuePartieLocale();
		}
		
		VuePartieLocale vuePartieLocale = vue.creerVuePartieLocale();
		
		// FIXME: devrait faire appel à un EntrepotDeModeles (qui est dans quatredesuite_javafx)
		Partie partieLocale = new Partie();
		
		AfficheurPartie afficheurPartie = new AfficheurPartie();

		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
				partieLocale, 
				vuePartieLocale,
				afficheurPartie);
	}

}

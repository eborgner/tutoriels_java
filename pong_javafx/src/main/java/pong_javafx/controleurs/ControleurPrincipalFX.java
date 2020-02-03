package pong_javafx.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import pong.modeles.partie.Partie;
import pong_client.afficheurs.AfficheurPartie;
import pong_client.controleurs.ControleurPartieLocale;
import pong_client.controleurs.ControleurPrincipal;
import pong_javafx.vues.VuePartieLocaleFX;
import pong_javafx.vues.VuePrincipaleFX;

public class ControleurPrincipalFX extends ControleurPrincipal<VuePrincipaleFX> {
	
	private ControleurPartieLocaleFX controleurPartieLocale;

	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		Partie partie = new Partie();

		AfficheurPartie afficheur = new AfficheurPartie();
		
		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		controleurPartieLocale = FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partie, vuePartieLocale, afficheur);
		
	}

	@Override
	public void detruire() {
		J.appel(this);
		
		if(controleurPartieLocale != null) {
			controleurPartieLocale.detruire();
		}
	}
}

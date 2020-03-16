package tp01_corrige_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import tp01_corrige.modeles.parametres.Parametres;
import tp01_corrige.modeles.parametres.ParametresLectureSeule;
import tp01_corrige_client.afficheurs.AfficheurParametres;
import tp01_corrige_client.commandes.choisir_taille.ChoisirTaille;
import tp01_corrige_client.commandes.choisir_taille.ChoisirTailleRecue;
import tp01_corrige_client.vues.VueParametres;

public abstract class ControleurParametres<V extends VueParametres,
					       				     A extends AfficheurParametres<V>> 

					extends ControleurModeleVue<ParametresLectureSeule, 
											    Parametres, 
											    V, 
											    A> {
	

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirTaille.class, new RecepteurCommandeMVC<ChoisirTailleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleRecue commande) {
				J.appel(this);
				
				modele.choisirTaille(commande.getTaille());
				
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 
}

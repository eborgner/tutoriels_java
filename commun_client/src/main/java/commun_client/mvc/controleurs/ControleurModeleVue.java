package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun.modeles.Modele;
import commun.modeles.ModeleLectureSeule;
import commun_client.commandes.Commande;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.ReactionApresCommande;
import commun_client.mvc.Afficheur;
import commun_client.mvc.Vue;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class ControleurModeleVue<MLS extends ModeleLectureSeule, 
                                          M extends Modele<MLS>, 
                                          V extends Vue, 
                                          A extends Afficheur> 

				extends ControleurVue<V> {
	
	protected M modele;
	protected A afficheur;
	
	public ControleurModeleVue() {
		super();
		J.appel(this);
	}
	
	public void setModele(M modele) {
		J.appel(this);

		this.modele = modele;
	}

	public void setAfficheur(A afficheur) {
		J.appel(this);

		this.afficheur = afficheur;
	}
	
	public void initialiserAffichage() {
		J.appel(this);
		
		afficheur.initialiserAffichage((MLS) modele, vue);
	}
	
	@Override
	protected void installerReactionApresCommande(Class<? extends Commande> classeCommande) {
		J.appel(this);
		
		FabriqueCommande.installerReactionApresCommande(classeCommande, new ReactionApresCommande() {
			@Override
			public void reagirApresCommande() {
				J.appel(this);

			}
		});
	}
}

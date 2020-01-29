package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun.mvc.Modele;
import commun_client.mvc.Afficheur;
import commun_client.mvc.Vue;

@SuppressWarnings("rawtypes")
public abstract class ControleurModeleVue<M extends Modele, V extends Vue, A extends Afficheur> extends ControleurVue<V> {
	
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
	
}

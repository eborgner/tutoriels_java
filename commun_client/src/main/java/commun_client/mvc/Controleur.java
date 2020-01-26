package commun_client.mvc;

import commun.debogage.J;
import commun.mvc.Modele;

public abstract class Controleur<M extends Modele, V extends Vue> {
	
	protected M modele;
	protected V vue;
	
	public Controleur() {
		J.appel(this);
	}
	
	public void setModele(M modele) {
		J.appel(this);
		this.modele = modele;
	}
	
	public void setVue(V vue) {
		J.appel(this);
		
		this.vue = vue;
	}
	
	public abstract void installerCapteursEvenement();

	public abstract void detruire();

}

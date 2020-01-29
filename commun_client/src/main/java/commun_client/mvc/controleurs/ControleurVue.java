package commun_client.mvc.controleurs;

import commun.debogage.J;
import commun_client.mvc.Vue;

public abstract class ControleurVue<V extends Vue> {
	
	protected V vue;
	
	public ControleurVue() {
		J.appel(this);
	}
	
	public void setVue(V vue) {
		J.appel(this);
		
		this.vue = vue;
	}
	
	public abstract void installerReceptionCommandes();
	public abstract void demarrer();
	public abstract void detruire();

}

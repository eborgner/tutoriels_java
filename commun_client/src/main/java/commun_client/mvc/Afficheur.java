package commun_client.mvc;

import commun.debogage.J;
import commun.mvc.ModelePourAffichage;
import commun_client.commandes.ActionCommandeTraitee;

public abstract class Afficheur<LM extends ModelePourAffichage, V extends Vue> extends ActionCommandeTraitee {
	
	private LM modele;
	private V vue;
	
	public Afficheur(LM modele, V vue) {
		J.appel(this);
		
		this.modele = modele;
		this.vue = vue;
		
		initialiserAffichage();
	}
	
	@Override
	public void reagirMessageTraite() {
		J.appel(this);

		rafraichirAffichage();
	}
	
	protected abstract void initialiserAffichage();
	protected abstract void rafraichirAffichage();

}

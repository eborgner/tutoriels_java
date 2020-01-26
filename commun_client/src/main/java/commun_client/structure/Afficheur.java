package commun_client.structure;

import commun.debogage.J;
import commun.structure.LectureModele;
import commun_client.evenements.FinalisateurEvenement;

public abstract class Afficheur<LM extends LectureModele, V extends Vue> extends FinalisateurEvenement {
	
	private LM modele;
	private V vue;
	
	public Afficheur(LM modele, V vue) {
		J.appel(this);
		
		this.modele = modele;
		this.vue = vue;
		
		initialiserAffichage();
	}
	
	@Override
	public void reagirFinCaptation() {
		J.appel(this);

		rafraichirAffichage();
	}
	
	protected abstract void initialiserAffichage();
	protected abstract void rafraichirAffichage();

}

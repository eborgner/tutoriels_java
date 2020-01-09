package quatredesuite.modeles;

import commun.debogage.J;
import commun.mvc.Modele;
import quatredesuite.donnees.Grille;
import quatredesuite.donnees.Partie;
import quatredesuite.enumerations.Couleur;

public abstract class ModelePartie<P extends Partie> extends Modele {
	
	// XXX: voici comment exclure un champ
	//      de la sérialisation Json
	private transient String _Exclu_json = "pouet";

	protected P partie;

	public ModelePartie(P partie) {
		J.appel(this);

		this.partie = partie;
	}
	
	public ModelePartie() {
		J.appel(this);
		partie = creerPartie();
	}
	
	protected abstract P creerPartie();
	
	public void jouerIci(int idColonne){
		J.appel(this);

		effectuerCoup(idColonne);
	}

	public void effectuerCoup(int idColonne) {
		J.appel(this);

		partie.getGrille().ajouterJeton(idColonne, partie.getCouleurCourante());
		prochaineCouleur();
	}
	
	private void prochaineCouleur() {
		J.appel(this);
		
		switch(partie.getCouleurCourante()) {
		
		case ROUGE:
			partie.setCouleurCourante(Couleur.JAUNE);
			break;
		case JAUNE:
			partie.setCouleurCourante(Couleur.ROUGE);
			break;
		}
	}


	public boolean siPossibleJouerIci(int idColonne){
		J.appel(this);

		// TODO
		return true;
	}
	
	
	
}

package tp01_corrige.modeles.parametres;

import java.util.Locale;

import commun.debogage.J;
import commun.modeles.Modele;
import tp01_corrige.enumerations.TailleGrille;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private TailleGrille taille = TailleGrille.PETITE;

	@Override
	public TailleGrille getTailleGrille() {
		J.appel(this);

		return taille;
	}

	public void choisirTaille(TailleGrille taille) {
		J.appel(this);
		
		this.taille = taille;
	}
}

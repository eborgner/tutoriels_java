package quatredesuite.modeles.partie;

import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {

	private int largeur =  3 + (new Random().nextInt(5));
	private int hauteur = 4 + (new Random().nextInt(8));
	
	public PartieLocale() {
		J.appel(this);
		
	}

	public int getLargeur() {
		J.appel(this);
		return largeur;
	}

	public int getHauteur() {
		J.appel(this);
		return hauteur;
	}
}

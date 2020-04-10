package quatredesuite.modeles.partie_locale;

import java.util.Random;

import commun.debogage.J;
import quatredesuite.modeles.partie.Partie;

public class PartieLocale extends Partie<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule { 
	
	public PartieLocale() {
		super();
		J.appel(this);
		
		 largeur =  3 + (new Random().nextInt(5));
		 hauteur = 4 + (new Random().nextInt(8));
	}
}

package tp01_pages.modeles.parametres;

import java.util.Locale;

import commun.debogage.J;
import commun.modeles.Modele;
import tp01_pages.enumerations.Choix;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Choix choixUsager = Choix.UN;

	@Override
	public Choix getChoixUsager() {
		J.appel(this);

		return choixUsager;
	}

	public void choisirChoix(Choix choix) {
		J.appel(this);
		
		this.choixUsager = choix;
	}
}

package tp01_pages.modeles.partie_locale;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.modeles.Modele;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {
	
	private List<Integer> lesCoups = new ArrayList<>();
	
	public void jouerCoup(int infoCoup) {
		J.appel(this);
		
		lesCoups.add(infoCoup);
	}

	@Override
	public int getNombreCoups() {
		J.appel(this);
		
		return lesCoups.size();
	}
}

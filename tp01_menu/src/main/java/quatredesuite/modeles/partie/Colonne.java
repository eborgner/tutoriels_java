package quatredesuite.modeles.partie;

import java.util.ArrayList;

import java.util.List;

import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Colonne implements ColonneLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void ajouterJeton(Jeton jeton) {
		J.appel(this);
		
		jeton.setIndiceRangee(jetons.size());
		
		jetons.add(jeton);
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		for(Jeton jeton : jetons) {

			jetonsLectureSeule.add((JetonLectureSeule) jeton);
		}
		
		return jetonsLectureSeule;
	}
}

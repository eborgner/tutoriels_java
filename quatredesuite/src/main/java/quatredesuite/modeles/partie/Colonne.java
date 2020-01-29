package quatredesuite.modeles.partie;

import java.util.ArrayList;

import java.util.List;

import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Colonne implements ColonneLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void ajouterJeton(Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();
		
		jeton.initialiser(couleur);
		
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

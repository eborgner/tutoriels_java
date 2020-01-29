package quatredesuite.modeles.partie;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

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
	public Stream<JetonLectureSeule> getJeton() {
		J.appel(this);
		
		Stream<Jeton> streamJetons = jetons.stream();
		
		Stream<JetonLectureSeule> jetonsLectureSeule = streamJetons.map(j -> (JetonLectureSeule) j);
		
		return jetonsLectureSeule;
		

	}
}

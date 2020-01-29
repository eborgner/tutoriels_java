package quatredesuite.modeles.partie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			colonnes.add(new Colonne());
		}
	}

	public void ajouterJeton(int idColonne, Couleur couleur) {
		J.appel(this);
		
		colonnes.get(idColonne).ajouterJeton(couleur);
		
	}

	@Override
	public Stream<ColonneLectureSeule> getColonnes() {
		J.appel(this);

		Stream<ColonneLectureSeule> streamColonnesLectureSeule;
		
		Stream<Colonne> streamColonnes = colonnes.stream();
		
		streamColonnesLectureSeule = streamColonnes.map(c -> (ColonneLectureSeule) c);
		
		return streamColonnesLectureSeule;
		
	}



	

}

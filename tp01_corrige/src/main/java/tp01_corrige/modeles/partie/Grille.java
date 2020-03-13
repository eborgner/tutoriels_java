package tp01_corrige.modeles.partie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.debogage.J;
import tp01_corrige.enumerations.Couleur;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			colonnes.add(new Colonne());
		}
	}

	public void ajouterJeton(Jeton jeton) {
		J.appel(this);
		
		colonnes.get(jeton.getIndiceColonne()).ajouterJeton(jeton);
	}

	@Override
	public List<ColonneLectureSeule> getColonnes() {
		J.appel(this);
		
		List<ColonneLectureSeule> colonnesLectureSeule = new ArrayList<>();
		
		for(Colonne colonne : colonnes) {
			
			colonnesLectureSeule.add((ColonneLectureSeule) colonne);
			
		}
		
		return colonnesLectureSeule;
		
	}



	

}

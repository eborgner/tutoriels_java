package tp01_temps_reel.modeles.partie_locale;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.modeles.Modele;
import tp01_temps_reel.modeles.monde2d.Monde2D;
import tp01_temps_reel.modeles.monde2d.Monde2DLectureSeule;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {
	
	private List<Integer> lesCoups = new ArrayList<>();
	
	private Monde2D monde2D = new Monde2D();
	
	public void jouerCoup(int angleDepartDegres) {
		J.appel(this);
		
		lesCoups.add(angleDepartDegres);
		
		monde2D.nouvelleBalle2D(angleDepartDegres);
	}

	@Override
	public int getNombreCoups() {
		J.appel(this);
		
		return lesCoups.size();
	}
	
	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		monde2D.reagirAuTempsQuiPasse(secondesEcoulees);
	}
	
	@Override
	public Monde2DLectureSeule getMonde2D() {
		J.appel(this);
		
		return (Monde2DLectureSeule) monde2D;
	}
}

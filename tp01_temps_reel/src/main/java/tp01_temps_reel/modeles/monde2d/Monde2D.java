package tp01_temps_reel.modeles.monde2d;

import java.util.HashSet;
import java.util.Set;

import commun.debogage.J;

public class Monde2D implements Monde2DLectureSeule {
	
	protected double largeurMetres = 30;
	protected double hauteurMetres = 10;

	protected Set<Objet2D> lesObjets = new HashSet<>();

	public void nouvelleBalle2D(int angleDepartDegres) {
		J.appel(this);
		
	}

	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		for(Objet2D objet2d : lesObjets) {
			
			objet2d.reagirAuTempsQuiPasse(secondesEcoulees);
		}
	}

	@Override
	public void afficher(Dessin2D dessin2d) {
		J.appel(this);
		
		double facteurMetresPixelsX = dessin2d.getLargeurPixels() / largeurMetres;
		double facteurMetresPixelsY = dessin2d.getHauteurPixels() / hauteurMetres;

		for(Objet2D objet2d : lesObjets) {
			
			objet2d.afficher(facteurMetresPixelsX, 
					         facteurMetresPixelsY, 
					         dessin2d.getHauteurPixels(),
					         dessin2d);
		}
	}
}

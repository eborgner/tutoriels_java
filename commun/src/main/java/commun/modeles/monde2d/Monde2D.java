package commun.modeles.monde2d;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.enumerations.Dimension;

public abstract class Monde2D implements Monde2DLectureSeule {

	private double hauteurMetres = 800;
	private double largeurMetres = 600;
	
	protected List<Objet2D> objets2D = new ArrayList<>();

	@Override
	public List<Objet2DLectureSeule> getObjets2D() {
		J.appel(this);
		
		List<Objet2DLectureSeule> objets2DLectureSeule = new ArrayList<>();
		
		for(Objet2D objet2D : objets2D) {
			objets2DLectureSeule.add((Objet2DLectureSeule) objet2D);
		}

		return objets2DLectureSeule;
	}
	
	public void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);
		
		for(Objet2D objet2D : objets2D) {
			
			objet2D.reagirTempsQuiPasse(tempsEcouleSecondes);
		}
	}

	@Override
	public double getLageurMetres() {
		J.appel(this);
		return largeurMetres;
	}

	@Override
	public double getHauteurMetres() {
		J.appel(this);
		return hauteurMetres;
	}

	public void aggrandir(Dimension dimension, double facteurAggrandissement) {
		J.appel(this);
		
		switch(dimension) {
			case HAUTEUR:
				hauteurMetres *= facteurAggrandissement;
				break;
				
			case LARGEUR:
				largeurMetres *= facteurAggrandissement;
				break;
		}
		
		// TODO: déplacer les palettes et la balle
	}

}

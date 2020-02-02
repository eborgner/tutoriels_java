package commun.modeles.monde2d;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;

public abstract class Monde2D implements Monde2DLectureSeule {
	
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

}

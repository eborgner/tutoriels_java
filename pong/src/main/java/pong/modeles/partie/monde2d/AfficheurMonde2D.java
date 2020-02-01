package pong.modeles.partie.monde2d;

import java.util.List;

import commun.debogage.J;

public class AfficheurMonde2D {
	
	public static void afficherMonde(Monde2DLectureSeule monde2D, VueMonde2D vue) {
		J.appel(AfficheurMonde2D.class);
		
		vue.viderMonde();
		
		afficherObjets(monde2D.getObjets2D(), vue);
		
	}

	public static void afficherObjets(List<Objet2DLectureSeule> objets2D, VueMonde2D vue) {
		J.appel(AfficheurMonde2D.class);
		
		for(Objet2DLectureSeule objet2D : objets2D) {
			vue.afficherObjet2D(objet2D);
		}
	}

}

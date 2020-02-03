package commun.modeles.monde2d;

import commun.enumerations.Forme;

public interface Objet2DLectureSeule {

	double getCentreXMetres();
	double getCentreYMetres();
	double getLargeurMetres();
	double getHauteurMetres();
	Forme getForme();

}

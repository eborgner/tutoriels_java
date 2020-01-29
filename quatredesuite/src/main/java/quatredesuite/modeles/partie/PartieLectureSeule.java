package quatredesuite.modeles.partie;

import commun.mvc.ModeleLectureSeule;

public interface PartieLectureSeule extends ModeleLectureSeule { 

	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();
}




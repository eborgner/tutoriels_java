package tp01_temps_reel.modeles.partie_locale;

import commun.modeles.ModeleLectureSeule;
import tp01_temps_reel.modeles.monde2d.Monde2DLectureSeule;

public interface PartieLocaleLectureSeule extends ModeleLectureSeule { 
	
	int getNombreCoups();
	Monde2DLectureSeule getMonde2D();

}




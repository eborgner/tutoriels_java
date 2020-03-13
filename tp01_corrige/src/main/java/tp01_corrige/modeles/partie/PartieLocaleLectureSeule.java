package tp01_corrige.modeles.partie;

import commun.modeles.ModeleLectureSeule;

public interface PartieLocaleLectureSeule extends ModeleLectureSeule { 

	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();
	 JetonLectureSeule getDernierJetonAjoute();
}




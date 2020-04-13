package quatredesuite.modeles.partie;

import commun.modeles.ModeleLectureSeule;

public interface PartieLectureSeule 
       extends   ModeleLectureSeule {
	
	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();

}

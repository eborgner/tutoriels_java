package quatredesuite.modeles.sauvegardes;

import java.util.List;

import commun.modeles.ModeleLectureSeule;

public interface SauvegardesLectureSeule extends ModeleLectureSeule {
	
	List<UneSauvegardeLectureSeule> getLesSauvegardes();

}

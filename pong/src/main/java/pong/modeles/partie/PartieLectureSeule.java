package pong.modeles.partie;

import java.util.Map;

import commun.mvc.ModeleLectureSeule;
import pong.enumerations.Cadran;
import pong.modeles.partie.monde2d.Monde2DLectureSeule;

public interface PartieLectureSeule extends ModeleLectureSeule {
	
	Monde2DLectureSeule getMonde2D();


}

package pong.modeles.partie;

import java.util.Map;

import commun.modeles.ModeleLectureSeule;
import commun.modeles.monde2d.Monde2DLectureSeule;
import pong.enumerations.Cadran;

public interface PartieLectureSeule extends ModeleLectureSeule {
	
	Monde2DLectureSeule getMonde2D();


}

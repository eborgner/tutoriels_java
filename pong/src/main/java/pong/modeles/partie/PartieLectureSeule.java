package pong.modeles.partie;

import java.util.Map;

import commun.mvc.ModeleLectureSeule;
import pong.enumerations.Cote;

public interface PartieLectureSeule extends ModeleLectureSeule {

	Map<Cote, PaletteLectureSeule> getPalettes();

}

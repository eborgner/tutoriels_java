package pong.modeles.partie;

import java.util.Map;

import commun.mvc.ModeleLectureSeule;
import pong.enumerations.Cadran;
import pong.modeles.partie.table_pong.PaletteLectureSeule;
import pong.modeles.partie.table_pong.TablePongLectureSeule;

public interface PartieLectureSeule extends ModeleLectureSeule {
	
	TablePongLectureSeule getTablePong();


}

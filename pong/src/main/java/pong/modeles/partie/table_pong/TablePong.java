package pong.modeles.partie.table_pong;

import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import pong.enumerations.Cadran;

public class TablePong implements TablePongLectureSeule {
	
	private Map<Cadran, Palette> palettes = new HashMap<>();
	
	public TablePong(){
		J.appel(this);

		palettes.put(Cadran.GAUCHE, new Palette(Cadran.GAUCHE, 0));
		palettes.put(Cadran.DROIT, new Palette(Cadran.DROIT, 100));
		
	}

	@Override
	public Map<Cadran, PaletteLectureSeule> getPalettes() {
		J.appel(this);
		
		Map<Cadran, PaletteLectureSeule> palettesLectureSeule = new HashMap<>();
		
		for(Map.Entry<Cadran, Palette> entree : palettes.entrySet()) {
			
			palettesLectureSeule.put(entree.getKey(), (PaletteLectureSeule) entree.getValue());
		}
		
		return palettesLectureSeule;
	}

}

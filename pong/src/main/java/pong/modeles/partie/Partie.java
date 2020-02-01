package pong.modeles.partie;

import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import commun.mvc.Modele;
import pong.enumerations.Cote;

public class Partie extends Modele<PartieLectureSeule> implements PartieLectureSeule { 
	
	private Map<Cote, Palette> palettes = new HashMap<>();
	
	public Partie() {
		J.appel(this);

		palettes.put(Cote.GAUCHE, new Palette(0));
		palettes.put(Cote.DROIT, new Palette(100));
	}

	@Override
	public Map<Cote, PaletteLectureSeule> getPalettes() {
		J.appel(this);
		
		Map<Cote, PaletteLectureSeule> palettesLectureSeule = new HashMap<>();
		
		for(Map.Entry<Cote, Palette> entree : palettes.entrySet()) {
			
			palettesLectureSeule.put(entree.getKey(), (PaletteLectureSeule) entree.getValue());
		}
		
		return palettesLectureSeule;
	}
	
	
	
}

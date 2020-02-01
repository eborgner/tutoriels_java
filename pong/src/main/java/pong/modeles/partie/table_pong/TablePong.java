package pong.modeles.partie.table_pong;

import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import pong.enumerations.Cadran;
import pong.modeles.partie.monde2d.Monde2D;

public class TablePong extends Monde2D {
	
	private Map<Cadran, Palette> palettes = new HashMap<>();
	
	public TablePong(){
		J.appel(this);
		
		creerPalettes();
		ajouterPalettesCommeObjets2D();
		
	}

	private void ajouterPalettesCommeObjets2D() {
		J.appel(this);
		
		for(Palette palette : palettes.values()) {
			objets2D.add(palette);
		}
	}

	private void creerPalettes() {
		J.appel(this);

		palettes.put(Cadran.GAUCHE, new Palette(Cadran.GAUCHE, 0));
		palettes.put(Cadran.DROIT, new Palette(Cadran.DROIT, 100));
	}

}

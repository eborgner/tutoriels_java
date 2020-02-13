package pong.modeles.partie.table_pong;

import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun.enumerations.Direction;
import commun.modeles.monde2d.Monde2D;
import pong.enumerations.Cadran;

public class TablePong extends Monde2D {

	private Map<Cadran, Palette> palettes = new HashMap<>();
	private Balle balle;
	
	public TablePong(){
		J.appel(this);
		
		creerPalettes();
		creerBalle();
		ajouterPalettesCommeObjets2D();
		
	}

	private void creerBalle() {
		J.appel(this);
		
		balle = new Balle();
		objets2D.add(balle);
	}

	private void ajouterPalettesCommeObjets2D() {
		J.appel(this);
		
		for(Palette palette : palettes.values()) {
			objets2D.add(palette);
		}
	}

	private void creerPalettes() {
		J.appel(this);

		palettes.put(Cadran.GAUCHE, new Palette(Cadran.GAUCHE, 20));
		palettes.put(Cadran.DROIT, new Palette(Cadran.DROIT, largeurMetres - 20));
	}
	
	@Override 
	public void aggrandir(Dimension dimension, double facteurAggrandissement) {
		J.appel(this);

		super.aggrandir(dimension, facteurAggrandissement);
		
		balle.replacerApresAggrandissement(dimension, facteurAggrandissement);
		
		switch(dimension) {
			case LARGEUR:
				palettes.get(Cadran.DROIT).placerPresDuMur(largeurMetres);
			break;

			case HAUTEUR:
				if(dimension == Dimension.HAUTEUR) {
					for(Palette palette : palettes.values()) {
						palette.replacerEnHauteur(facteurAggrandissement);
					}
				}
			break;
		}
		
	}

	public void deplacerPalette(Cadran cadran, Direction direction) {
		J.appel(this);
		
		Palette palette = palettes.get(cadran);
		palette.deplacer(direction);
	}

	public void stopperPalette(Cadran cadran) {
		J.appel(this);

		Palette palette = palettes.get(cadran);
		palette.stopper();
	}
	
	@Override
	public void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);
		super.reagirTempsQuiPasse(tempsEcouleSecondes);
		
		balle.reagirSiCollision(palettes);
	}



}
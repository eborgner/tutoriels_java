package pong.modeles.partie;


import java.util.Map;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun.enumerations.Direction;
import commun.modeles.Modele;
import commun.modeles.monde2d.Monde2DLectureSeule;
import pong.enumerations.Cadran;
import pong.modeles.partie.table_pong.Balle;
import pong.modeles.partie.table_pong.Palette;
import pong.modeles.partie.table_pong.TablePong;

public class Partie extends Modele<PartieLectureSeule> implements PartieLectureSeule {
	
	private TablePong tablePong;
	
	public Partie() {
		J.appel(this);
		
		tablePong = new TablePong();
	}
	
	public void reagirTempsQuiPasse(double tempsEcouleSecondes) {
		J.appel(this);

		tablePong.reagirTempsQuiPasse(tempsEcouleSecondes);
	}

	@Override
	public Monde2DLectureSeule getMonde2D() {
		J.appel(this);

		return (Monde2DLectureSeule) tablePong;
	}

	public void aggrandirTablePong(Dimension dimension, double facteurAggrandissement) {
		J.appel(this);
		
		tablePong.aggrandir(dimension, facteurAggrandissement);
	}

	public void deplacerPalette(Cadran cadran, Direction direction) {
		J.appel(this);
		
		tablePong.deplacerPalette(cadran, direction);
	} 
	
	public void stopperPalette(Cadran cadran) {
		J.appel(this);
		
		tablePong.stopperPalette(cadran);
	}

	public Balle getBalle() {
		J.appel(this);
		
		return tablePong.getBalle();
	}

	public void setBalle(Balle balle) {
		J.appel(this);
		
		tablePong.setBalle(balle);
	}

	public Map<Cadran, Palette> getPalettes() {
		J.appel(this);
		
		return tablePong.getPalettes();
	}
	
	
}

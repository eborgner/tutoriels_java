package pong.modeles.partie;


import commun.debogage.J;
import commun.modeles.Modele;
import commun.modeles.monde2d.Dimension;
import commun.modeles.monde2d.Monde2DLectureSeule;
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
	
	
}

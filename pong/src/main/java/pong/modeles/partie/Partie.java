package pong.modeles.partie;


import commun.debogage.J;
import commun.mvc.Modele;
import pong.modeles.partie.table_pong.TablePong;
import pong.modeles.partie.table_pong.TablePongLectureSeule;

public class Partie extends Modele<PartieLectureSeule> implements PartieLectureSeule {
	
	private TablePong tablePong;
	
	public Partie() {
		J.appel(this);
		
		tablePong = new TablePong();
		
	}

	@Override
	public TablePongLectureSeule getTablePong() {
		J.appel(this);
		
		return (TablePongLectureSeule) tablePong;
	} 
	
	

	
	
	
}

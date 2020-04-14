package quatredesuite.modeles.sauvegardes;

import commun.debogage.J;

public class UneSauvegarde implements UneSauvegardeLectureSeule {

	private String cheminDansHome;

	public UneSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		this.cheminDansHome = cheminDansHome;
	}

	@Override
	public String getCheminDansHome() {
		J.appel(this);
		
		return cheminDansHome;
	}

}

package tp01_menu.modeles.parametres;

import commun.modeles.Modele;
import tp01_menu.enumerations.Choix;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Choix choixUsager = Choix.UN;

	@Override
	public Choix getChoixUsager() {
		return choixUsager;
	}

	public void setChoixUsager(Choix choixUsager) {
		this.choixUsager = choixUsager;
	}

}

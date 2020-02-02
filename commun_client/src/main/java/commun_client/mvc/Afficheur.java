package commun_client.mvc;

import commun.modeles.ModeleLectureSeule;

public abstract class Afficheur<MLS extends ModeleLectureSeule, V extends Vue> {
	
	public abstract void initialiserAffichage(MLS modeleLectureSeule, V vue);
	public abstract void rafraichirAffichage(MLS modeleLectureSeule, V vue);

}

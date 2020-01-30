package commun.mvc;

import commun.debogage.J;

public abstract class Modele<MLS extends ModeleLectureSeule> { 

	public MLS getModeleLectureSeule() {
		J.appel(this);

		return getInterfaceLectureSeule().cast(this);
	}
	
	protected abstract Class<MLS> getInterfaceLectureSeule();
}
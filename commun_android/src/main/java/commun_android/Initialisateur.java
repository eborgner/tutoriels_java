package commun_android;

import commun.debogage.J;
import commun.systeme.Quitteur;
import commun.systeme.Systeme;

public class Initialisateur {
	
	public static void initialiser() {

		J.initialiser(J.Contexte.ANDROID);

		J.appel(Initialisateur.class);
		
		Systeme.installerQuitteur(new Quitteur() {
			@Override
			public void quitter() {
				J.appel(this);
				throw new RuntimeException();
			}
		});

	}

}

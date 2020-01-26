package quatredesuite_client.evenements.nouvelle_partie_locale;

import commun.debogage.J;
import commun_client.evenements.CapteurEvenement;
import commun_client.evenements.Evenement;
import commun_client.evenements.FinalisateurEvenement;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NouvellePartieLocale extends Evenement implements NouvellePartieLocaleLance, NouvellePartieLocaleCapte {
	
	public NouvellePartieLocale(CapteurEvenement capteur, FinalisateurEvenement finalisateur) {
		super(capteur, finalisateur);
		J.appel(this);
	}

}

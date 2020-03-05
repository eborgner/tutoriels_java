package tp01_pages_client.commandes.changer_locale;

import java.util.Locale;

import commun.debogage.J;
import commun_client.commandes.Commande;

public class ChangerLocale extends Commande<ChangerLocalePourEnvoi, ChangerLocaleRecue>
						   implements ChangerLocalePourEnvoi, ChangerLocaleRecue {
	
	private Locale locale;

	public Locale getLocale() {
		J.appel(this);

		return locale;
	}

	public void setLocale(Locale locale) {
		J.appel(this);

		this.locale = locale;
	}
}

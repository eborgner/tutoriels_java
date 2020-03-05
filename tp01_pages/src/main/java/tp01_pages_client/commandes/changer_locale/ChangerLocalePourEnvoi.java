package tp01_pages_client.commandes.changer_locale;

import java.util.Locale;

import commun_client.commandes.CommandePourEnvoi;

public interface ChangerLocalePourEnvoi extends CommandePourEnvoi {
	
	void setLocale(Locale locale);

}

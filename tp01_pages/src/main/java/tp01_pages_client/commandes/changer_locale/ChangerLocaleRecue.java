package tp01_pages_client.commandes.changer_locale;

import java.util.Locale;

import commun_client.commandes.CommandeRecue;

public interface ChangerLocaleRecue extends CommandeRecue {
	
	Locale getLocale();

}

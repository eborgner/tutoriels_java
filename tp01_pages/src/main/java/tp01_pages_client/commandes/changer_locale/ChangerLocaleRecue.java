package tp01_une_page_client.commandes.changer_locale;

import java.util.Locale;

import commun_client.commandes.CommandeRecue;

public interface ChangerLocaleRecue extends CommandeRecue {
	
	Locale getLocale();

}

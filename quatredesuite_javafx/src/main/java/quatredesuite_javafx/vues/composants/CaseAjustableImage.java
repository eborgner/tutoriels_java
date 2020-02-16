package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import commun_javafx.vues.composants.ImageAjustable;
import javafx.beans.NamedArg;

public class CaseAjustableImage extends ImageAjustable {
	
	private static final double FACTEUR_TAILLE = 0.6;
	
	public CaseAjustableImage(@NamedArg("url") String url) {
		super(url, FACTEUR_TAILLE);
		J.appel(this);
	}
}

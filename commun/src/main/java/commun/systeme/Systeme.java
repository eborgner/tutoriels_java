package commun.systeme;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import commun.debogage.Erreur;
import commun.debogage.J;

public class Systeme {
	
	private static Quitteur quitteur;
	
	public static void installerQuitteur(Quitteur quitteur) {
		J.appel(Systeme.class);
		Systeme.quitteur = quitteur;
	}

	public static void quitter() {
		if(quitteur != null) {
			quitteur.quitter();
		}else {
			Erreur.fatale("Systeme.quitteur n'a pas été installé");
			System.exit(0);
		}
	}
	
	public static Path getHome() {
		J.appel(Systeme.class);
		
		String cheminHome = System.getProperty("user.home");

		return Paths.get(cheminHome);
	}

	public static String cheminDansHome(File fichierChoisi) {
		J.appel(Systeme.class);
		
		Path home = getHome();
		
		Path dansHome = home.relativize(fichierChoisi.toPath());

		return dansHome.toString();
	}

	public static File aPartirCheminDansHome(String cheminDansHome) {
		J.appel(Systeme.class);
		
		Path home = getHome();
		
		return new File(home.toString(), cheminDansHome);
	}

}

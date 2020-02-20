package formes;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commun.Fabrique;
import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;

public class EntrepotFormes {
	
	private static List<Forme> formes = new ArrayList<>();
	
	public static void chargerFormes(InputStream streamFormes) {
		J.appel(EntrepotFormes.class);
		
        Scanner scannerFormes = new Scanner(streamFormes);
        
        chargerFormes(scannerFormes);
	}
	
	private static void chargerFormes(Scanner scannerFormes) {
		J.appel(EntrepotFormes.class);
        
        while(scannerFormes.hasNext()) {
        	
        	String formeChaine = scannerFormes.nextLine();
        	
        	Scanner scannerForme = new Scanner(formeChaine);
        	
        	chargerUneForme(scannerForme);
        }
        
        scannerFormes.close();
	}
	
	private static void chargerUneForme(Scanner scannerForme) {
		J.appel(EntrepotFormes.class);
		
		String nomClasseForme = scannerForme.next();
		
		Class classeForme = getClasseForme(nomClasseForme);
		
		Forme forme = (Forme) Fabrique.nouvelleInstance(classeForme);
		
		forme.chargerForme(scannerForme);
		
		formes.add(forme);
	}

	private static Class getClasseForme(String nomClasseForme) {
		J.appel(EntrepotFormes.class);

		String nomCompletClasseForme = "formes." + nomClasseForme;
		
		Class classeForme = null;

		try {

			classeForme = Class.forName(nomCompletClasseForme);

		} catch (ClassNotFoundException e) {
			
			Erreur.fatale("Classe non-trouvée" + nomCompletClasseForme, e);
		}
		return classeForme;
	}
	
	public static void afficherformes(Dessin dessin) {
		J.appel(EntrepotFormes.class);
		
		for(Forme forme : formes) {
			
			forme.afficher(dessin);
		}
	}

}

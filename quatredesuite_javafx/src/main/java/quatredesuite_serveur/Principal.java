package quatredesuite_serveur;

import commun.debogage.J;
import static quatredesuite.Constantes.*;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(Principal.class);
		
		ServeurQuatreDeSuite serveur = new ServeurQuatreDeSuite(PORT);
		serveur.start();
	}

}

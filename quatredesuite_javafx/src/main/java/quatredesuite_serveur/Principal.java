package quatredesuite_serveur;

import commun.debogage.J;
import quatredesuite.Constantes;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(Principal.class);
		
		ServeurQuatreDeSuite serveur = new ServeurQuatreDeSuite(Constantes.PORT);
		serveur.start();
	}

}

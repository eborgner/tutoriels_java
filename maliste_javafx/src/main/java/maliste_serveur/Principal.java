package maliste_serveur;

import commun.debogage.J;
import maliste.Constantes;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		demarrerServeur();
	}

		
	private static void demarrerServeur() {
		J.appel(Principal.class);

		ServeurWebSocketMaListe serveur = new ServeurWebSocketMaListe(Constantes.PORT_WEBSOCKET);
		serveur.start();
	}
}

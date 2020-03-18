package maliste_serveur;

import commun.debogage.J;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		ServeurWebSocketMaListe serveur = new ServeurWebSocketMaListe(8765);
		serveur.start();
	}
}

package pong_serveur;

import commun.Constantes;
import commun.debogage.J;

public class Principal {
	
	public static void main(String[] args) {
		J.appel(Principal.class);
		
		Serveur serveur = new Serveur(Constantes.PORT);
		serveur.start();
	}

}

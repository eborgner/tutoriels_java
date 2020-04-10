package quatredesuite_serveur;

import commun.debogage.J;
import commun_serveur.ServeurWebSocket;

public class ServeurQuatreDeSuite extends ServeurWebSocket {

	public ServeurQuatreDeSuite(int port) {
		super(port);
		J.appel(this);
	}

}

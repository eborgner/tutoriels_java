package commun.messages.vers_serveur;

import commun.debogage.J;
import commun.donnees.Usager;
import commun.messages.Message;

public class Connexion extends Message {

    protected Usager usager;
    
    public Connexion(Usager usager) {
    	J.appel(this);
    	this.usager = usager;
    }
    
    public Usager getUsager() {
    	J.appel(this);
    	return usager;
	}
}

package commun.messages.vers_serveur;


import commun.debogage.J;
import commun.donnees.Usager;
import commun.messages.Message;

public class Inscription extends Message {

    private Usager usager;

    public Inscription(Usager usager) {
    	J.appel(this);
    	
    	this.usager = usager;
	}
    
    public Usager getUsager() {
    	J.appel(this);
    	
    	return usager;
    }

}

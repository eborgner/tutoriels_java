package quatredesuite.messages.vers_serveur;


import commun.debogage.J;
import commun.messages.Message;

public class CoupVersServeur extends Message {

    private String idPartie;
    private int idColonne;
    
    public CoupVersServeur(String idPartie, int idColonne) {
        J.appel(this);

        this.idPartie = idPartie;
        this.idColonne = idColonne;
    }

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}

	public int getIdColonne() {
		return idColonne;
	}

	public void setIdColonne(int idColonne) {
		this.idColonne = idColonne;
	}
}

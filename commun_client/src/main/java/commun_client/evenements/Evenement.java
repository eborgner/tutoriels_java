package commun_client.evenements;

import commun.debogage.J;

@SuppressWarnings({"unchecked"})
public abstract class Evenement<EC extends EvenementCapte> 
									implements EvenementLance, 
											   EvenementCapte {
	
	protected CapteurEvenement<EC> capteur;
	protected FinalisateurEvenement finalisateur;
	
	void setCapteur(CapteurEvenement<EC> capteur) {
		J.appel(this);

		this.capteur = capteur;
	}
	
	void setFinalisateur(FinalisateurEvenement finalisateur) {
		J.appel(this);
		
		this.finalisateur = finalisateur;
	}
	
	@Override
	public void lancer() {
    	J.appel(this);

    	if(siLancable()) {
    		capteur.capterEvenement((EC) this);
    	}
    }

	@Override
    public boolean siLancable(){
        J.appel(this);

        return capteur.siCaptable((EC) this);
    }

	@Override
	public void finCaptation() {
		J.appel(this);

		finalisateur.reagirFinCaptation();

	}
}

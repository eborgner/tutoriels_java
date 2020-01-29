package commun_client.commandes;

import commun.debogage.J;

@SuppressWarnings({"unchecked"})
public abstract class Commande<EC extends CommandeRecue> 
									implements CommandePourEnvoi, 
											   CommandeRecue {
	
	protected RecepteurCommande<EC> capteur;
	protected ActionCommandeTraitee finalisateur;
	
	void setCapteur(RecepteurCommande<EC> capteur) {
		J.appel(this);

		this.capteur = capteur;
	}
	
	void setFinalisateur(ActionCommandeTraitee finalisateur) {
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

		finalisateur.reagirMessageTraite();

	}
}

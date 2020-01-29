package commun_client.commandes;

import commun.debogage.J;

@SuppressWarnings({"unchecked"})
public abstract class Commande<EC extends CommandeRecue> 
									implements CommandePourEnvoi, 
											   CommandeRecue {
	
	protected RecepteurCommande<EC> capteur;
	protected ReactionApresCommande finalisateur;
	
	void setCapteur(RecepteurCommande<EC> capteur) {
		J.appel(this);

		this.capteur = capteur;
	}
	
	void setFinalisateur(ReactionApresCommande finalisateur) {
		J.appel(this);
		
		this.finalisateur = finalisateur;
	}
	
	@Override
	public void envoyerCommande() {
    	J.appel(this);

    	if(siCommandePossible()) {
    		capteur.executerCommande((EC) this);
    	}
    }

	@Override
    public boolean siCommandePossible(){
        J.appel(this);

        return capteur.siCommandePossible((EC) this);
    }

	@Override
	public void notifierCommandeTraitee() {
		J.appel(this);

		finalisateur.reagirMessageTraite();

	}
}

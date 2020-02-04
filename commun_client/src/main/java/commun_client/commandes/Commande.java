package commun_client.commandes;

import commun.debogage.J;

@SuppressWarnings({"unchecked"})
public abstract class Commande<CPE extends CommandePourEnvoi, 
							   CR extends CommandeRecue> 

				implements CommandePourEnvoi, 
			        	   CommandeRecue {
	
	protected RecepteurCommande<CR> recepteur;
	protected ReactionApresCommande reaction;
	
	void setRecepteur(RecepteurCommande<CR> recepteur) {
		J.appel(this);

		this.recepteur = recepteur;
	}
	
	void setReaction(ReactionApresCommande reaction) {
		J.appel(this);
		
		this.reaction = reaction;
	}
	
	@Override
	public void envoyerCommande() {
    	J.appel(this);

    	if(siCommandePossible()) {
    		recepteur.executerCommande((CR) this);
    	}
    }

	@Override
    public boolean siCommandePossible(){
        J.appel(this);

        return recepteur.siCommandePossible((CR) this);
    }

	@Override
	public void notifierCommandeTraitee() {
		J.appel(this);

		reaction.reagirApresCommande();
	}
}

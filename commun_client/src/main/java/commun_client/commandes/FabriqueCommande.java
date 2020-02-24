package commun_client.commandes;

import java.util.HashMap;
import java.util.Map;

import commun.Fabrique;
import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;

@SuppressWarnings({"rawtypes"})
public final class FabriqueCommande {
	
	private FabriqueCommande() {
		J.appel(this);
	}
	
	
	protected static Map<Class<? extends Commande>, RecepteurCommande> recepteurs = new HashMap<>();
	protected static Map<Class<? extends Commande>, ReactionApresCommande> reactionsApresCommande = new HashMap<>();

	public static <CPE extends CommandePourEnvoi,
			       CR extends CommandeRecue,
			       C extends Commande<CPE,CR>> 

		   void installerRecepteur(Class<C> classeCommande, 
								   RecepteurCommande<CR> recepteur) {

		J.appel(FabriqueCommande.class);

		recepteurs.put(classeCommande, recepteur);
	}

	public static <C extends Commande> 
				  void installerReactionApresCommande(Class<C> classeCommande, 
										     ReactionApresCommande reactionApresCommande) {

		J.appel(FabriqueCommande.class);
		
		reactionsApresCommande.put(classeCommande, reactionApresCommande);

	}


	@SuppressWarnings("unchecked")
	public static <CPE extends CommandePourEnvoi,
				   CR extends CommandeRecue,
				   C extends Commande<CPE,CR>>
	
	       CPE obtenirCommandePourEnvoi(Class<C> classeCommande){

		J.appel(FabriqueCommande.class);

		RecepteurCommande recepteur = recepteurs.get(classeCommande);
		DoitEtre.nonNul(recepteur, String.format("Aucun recepteur installé pour la Commande %s", classeCommande.getSimpleName()));

		ReactionApresCommande reaction = reactionsApresCommande.get(classeCommande);
		
		if(reaction == null) {
			Erreur.avertissement(String.format("ReactionVideParDefaut pour la Commande %s", classeCommande.getSimpleName()));
			reaction = new ReactionVideParDefaut();
		}
		
		Commande commande = Fabrique.nouvelleInstance(classeCommande);

		commande.setRecepteur(recepteur);
		commande.setReaction(reaction);
		
		CPE commandePourEnvoi = null;

		try {
			
			commandePourEnvoi = (CPE) commande;

		}catch(ClassCastException e) {
			
			Erreur.fatale(String.format("Impossible de créer la CommandePourEnvoi. Est-ce que la Commande %s est bien paramétrée?", 
								        classeCommande.getSimpleName()), e);
		}

		return commandePourEnvoi;
	}
	
}

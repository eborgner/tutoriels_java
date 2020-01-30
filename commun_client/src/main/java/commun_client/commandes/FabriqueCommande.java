package commun_client.commandes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;

@SuppressWarnings({"rawtypes"})
public class FabriqueCommande {
	
	
	protected static Map<Class<? extends CommandePourEnvoi>, Class<? extends Commande>> commandesPourEnvoi = new HashMap<>();
	
	protected static Map<Class<? extends Commande>, RecepteurCommande> recepteurs = new HashMap<>();
	protected static Map<Class<? extends Commande>, ReactionApresCommande> reactionsApresCommande = new HashMap<>();

	public static <C extends Commande, CPE extends CommandePourEnvoi> 
				  void initialiserCommandePourEnvoi(Class<CPE> classeCommandePourEnvoi, 
												 Class<C> classeCommande) {

		J.appel(FabriqueCommande.class);

		commandesPourEnvoi.put(classeCommandePourEnvoi, classeCommande);
	}
	
	public static <C extends Commande> 
				  void installerRecepteur(Class<C> classeCommande, 
										RecepteurCommande recepteur) {

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
	public static <EL extends CommandePourEnvoi> EL obtenirCommandePourEnvoi(Class<EL> classeEvenementLance) {
		J.appel(FabriqueCommande.class);
		
		Class<? extends Commande> classeEvenement = commandesPourEnvoi.get(classeEvenementLance);
		
		DoitEtre.nonNul(classeEvenement, String.format("Classe Evenement non-installée pour EvenementLance: %s", classeEvenementLance.getSimpleName()));
		
		RecepteurCommande capteur = recepteurs.get(classeEvenement);
		ReactionApresCommande reaction = reactionsApresCommande.get(classeEvenement);
		
		if(reaction == null) {
			Erreur.avertissement(String.format("ReactionVideParDefaut pour: %s", classeEvenement.getSimpleName()));
			reaction = new ReactionVideParDefaut();
		}
		
		DoitEtre.nonNul(capteur, String.format("Le capteur de l'événement %s n'a pas été installé", classeEvenement.getSimpleName()));
		
		Commande evenement = null;
		
		try {
			
			Constructor<? extends Commande> constructeur = classeEvenement.getConstructor();

			evenement = constructeur.newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassCastException e) {
			
			J.valeurs("[FATAL] impossible de créer l'événement: " + classeEvenement.getSimpleName());
			e.printStackTrace();
		}
		
		evenement.setCapteur(capteur);
		evenement.setFinalisateur(reaction);
		
		EL evenementLance = null;

		try {
			
			evenementLance = (EL) evenement;

		}catch(ClassCastException e) {
			
			Erreur.fatale(String.format("La Commande %s n'a pas son interface CommandePourEnvoi", evenement), e);
			
		}
		
		return evenementLance;
		
	}
	
}

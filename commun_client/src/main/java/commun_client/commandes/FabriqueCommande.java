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
	protected static Map<Class<? extends Commande>, ActionCommandeTraitee> actionsCommandeTraitee = new HashMap<>();

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

	public static <E extends Commande> 
				  void installerFinalisateur(Class<E> classeEvenement, 
										     ActionCommandeTraitee actionCommandeTraitee) {

		J.appel(FabriqueCommande.class);
		
		actionsCommandeTraitee.put(classeEvenement, actionCommandeTraitee);

	}


	@SuppressWarnings("unchecked")
	public static <EL extends CommandePourEnvoi> EL creerEvenement(Class<EL> classeEvenementLance) {
		J.appel(FabriqueCommande.class);
		
		Class<? extends Commande> classeEvenement = commandesPourEnvoi.get(classeEvenementLance);
		
		DoitEtre.nonNul(classeEvenement, String.format("Classe Evenement non-installée pour EvenementLance: %s", classeEvenementLance.getSimpleName()));
		
		RecepteurCommande capteur = recepteurs.get(classeEvenement);
		ActionCommandeTraitee finalisateur = actionsCommandeTraitee.get(classeEvenement);
		
		if(finalisateur == null) {
			Erreur.avertissement(String.format("FinalisateurEvenement par défaut pour: %s", classeEvenement.getSimpleName()));
			finalisateur = new ActionCommandeTraitee() {};
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
		evenement.setFinalisateur(finalisateur);
		
		EL evenementLance = null;

		try {
			
			evenementLance = (EL) evenement;

		}catch(ClassCastException e) {
			
			Erreur.fatale(String.format("L'événement %s n'a pas son interface EvenementLance", evenement), e);
			
		}
		
		return evenementLance;
		
	}
	
}

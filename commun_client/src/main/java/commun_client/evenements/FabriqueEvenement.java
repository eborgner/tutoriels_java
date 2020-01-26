package commun_client.evenements;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import commun.debogage.DoitEtre;
import commun.debogage.Erreur;
import commun.debogage.J;

@SuppressWarnings({"rawtypes"})
public class FabriqueEvenement {
	
	
	protected static Map<Class<? extends EvenementLance>, Class<? extends Evenement>> evenementsLances = new HashMap<>();
	
	protected static Map<Class<? extends Evenement>, CapteurEvenement> capteurs = new HashMap<>();
	protected static Map<Class<? extends Evenement>, FinalisateurEvenement> finalisateurs = new HashMap<>();

	public static <E extends Evenement, EL extends EvenementLance> 
				  void initialiserEvenementLance(Class<EL> classeEvenementLance, 
												 Class<E> classeEvenement) {

		J.appel(FabriqueEvenement.class);

		evenementsLances.put(classeEvenementLance, classeEvenement);
	}
	
	public static <E extends Evenement> 
				  void installerCapteur(Class<E> classeEvenement, 
										CapteurEvenement capteur) {

		J.appel(FabriqueEvenement.class);

		capteurs.put(classeEvenement, capteur);
	}

	public static <E extends Evenement> 
				  void installerFinalisateur(Class<E> classeEvenement, 
										     FinalisateurEvenement finalisateur) {

		J.appel(FabriqueEvenement.class);
		
		finalisateurs.put(classeEvenement, finalisateur);

	}


	@SuppressWarnings("unchecked")
	public static <EL extends EvenementLance> EL creerEvenement(Class<EL> classeEvenementLance) {
		J.appel(FabriqueEvenement.class);
		
		Class<? extends Evenement> classeEvenement = evenementsLances.get(classeEvenementLance);
		
		DoitEtre.nonNul(classeEvenement, String.format("Classe Evenement non-installée pour EvenementLance: %s", classeEvenementLance.getSimpleName()));
		
		CapteurEvenement capteur = capteurs.get(classeEvenement);
		FinalisateurEvenement finalisateur = finalisateurs.get(classeEvenement);
		
		if(finalisateur == null) {
			Erreur.avertissement(String.format("FinalisateurEvenement par défaut pour: %s", classeEvenement.getSimpleName()));
			finalisateur = new FinalisateurEvenement() {};
		}
		
		DoitEtre.nonNul(capteur, String.format("Le capteur de la commande %s n'a pas été installé", classeEvenement.getSimpleName()));
		
		Evenement evenement = null;
		
		try {
			
			Constructor<? extends Evenement> constructeur = classeEvenement.getConstructor(CapteurEvenement.class, FinalisateurEvenement.class);

			evenement = constructeur.newInstance(capteur, finalisateur);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
			J.valeurs("[FATAL] impossible de créer la Commande: " + classeEvenement.getSimpleName());
			e.printStackTrace();
		}
		
		
		EL evenementLance = null;

		try {
			
			evenementLance = (EL) evenement;

		}catch(ClassCastException e) {
			
			Erreur.fatale(String.format("L'événement %s n'a pas son interface EvenementLance", evenement), e);
			
		}
		
		return evenementLance;
		
	}
	
}

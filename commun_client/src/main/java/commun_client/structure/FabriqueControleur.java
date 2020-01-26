package commun_client.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import commun.debogage.J;
import commun.structure.Modele;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FabriqueControleur {

	public static <C extends Controleur> C creerControleur(Class<C> classeControleur, Modele modele, Vue vue) {

		C controleur = null;
		
		try {
			
			Constructor<C> constructeur = classeControleur.getConstructor();
			
			controleur = constructeur.newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassCastException e) {
			
			J.valeurs("[FATAL] impossible de créer la Commande: " + classeControleur.getSimpleName());
			e.printStackTrace();
		}
		
		controleur.setModele(modele);
		controleur.setVue(vue);

		controleur.installerCapteursEvenement();

		vue.creerEvenements();
		vue.installerListeners();

		return controleur;
	}
	

}

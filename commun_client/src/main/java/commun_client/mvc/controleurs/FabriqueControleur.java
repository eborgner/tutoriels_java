package commun_client.mvc.controleurs;


import commun.Fabrique;
import commun.debogage.J;
import commun.mvc.Modele;
import commun_client.mvc.Afficheur;
import commun_client.mvc.Vue;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FabriqueControleur {

	public static <C extends ControleurVue> C creerControleur(Class<C> classeControleur, Vue vue) {
		J.appel(FabriqueControleur.class);

		C controleur = Fabrique.nouvelleInstance(classeControleur);
		
		controleur.setVue(vue);

		initialiser(vue, controleur);
		
		return controleur;
	}

	public static <C extends ControleurModeleVue> C creerControleur(Class<C> classeControleur, Modele modele, Vue vue, Afficheur afficheur) {
		J.appel(FabriqueControleur.class);

		C controleur = Fabrique.nouvelleInstance(classeControleur);
		
		controleur.setModele(modele);
		controleur.setVue(vue);
		controleur.setAfficheur(afficheur);

		initialiser(vue, controleur);

		return controleur;
	}

	private static <C extends ControleurVue> void initialiser(Vue vue, C controleur) {
		J.appel(FabriqueControleur.class);

		installerReceptionCommandes(controleur);
		installerEnvoiDesCommandes(vue);
		
		controleur.demarrer();
	}

	private static <C extends ControleurVue> void installerReceptionCommandes(C controleur) {
		J.appel(FabriqueControleur.class);

		controleur.installerReceptionCommandes();
	}


	private static <C extends ControleurModeleVue> void installerEnvoiDesCommandes(Vue vue) {
		J.appel(FabriqueControleur.class);

		vue.creerEvenements();
		vue.installerListeners();
	}
}

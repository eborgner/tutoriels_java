package quatredesuite_javafx.controleurs;

import java.io.File;
import java.io.IOException;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import quatredesuite.modeles.partie.PartieLocale;
import quatredesuite_client.controleurs.ControleurSauvegardes;
import quatredesuite_javafx.afficheurs.AfficheurSauvegardesFX;
import quatredesuite_javafx.vues.VueSauvegardesFX;

public class ControleurSauvegardesFX extends ControleurSauvegardes<VueSauvegardesFX, AfficheurSauvegardesFX>{
	
	@Override
	protected void demarrer(){
		super.demarrer();
		J.appel(this);
		
		chercherSauvegardes();
	}

	private void chercherSauvegardes() {
		J.appel(this);
		
		File home = Systeme.getHome().toFile();
		
		chercherSauvegardes(home);
	}
	
	
	private void chercherSauvegardes(File repertoire) {
		J.appel(this);
		
		for(File fichier : repertoire.listFiles()) {

			if(fichier.isFile() && fichier.getName().endsWith("json")) {
				
				ajouterSauvegardeSiPossible(fichier);
				
			} else if(fichier.isDirectory() && !fichier.getName().startsWith(".")) {

				chercherSauvegardes(fichier);
			}
		}
	}

	private void ajouterSauvegardeSiPossible(File fichier) {
		J.appel(this);

		PartieLocale sauvegardePartie = null;

		try {

			sauvegardePartie = Json.aPartirFichier(fichier, PartieLocale.class);

		}catch(IOException e) { }

		if(sauvegardePartie != null && sauvegardePartie.siInitialisee()) {

			ajouterSauvegarde(fichier);
		}
	}

	private void ajouterSauvegarde(File fichier) {
		J.appel(this);

		modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
		afficheur.rafraichirAffichage(modele, vue);
	}
	

}

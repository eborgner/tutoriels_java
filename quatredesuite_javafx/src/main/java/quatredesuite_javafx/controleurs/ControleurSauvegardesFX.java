package quatredesuite_javafx.controleurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import quatredesuite.modeles.partie_locale.PartieLocale;
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
				
			} else if(fichier.isDirectory()) {
				
				chercherSauvegardes(fichier);
			}
		}
	}

	private void ajouterSauvegardeSiPossible(File fichier) {
		J.appel(this);

		PartieLocale partieLocale = null;

		try {

			partieLocale = Json.aPartirFichier(fichier, PartieLocale.class);

		}catch(IOException e) {
			
			J.valeurs(fichier.getPath());
		}
		
		ajouterSauvegardeSiPossible(fichier, partieLocale);
	}

	private void ajouterSauvegardeSiPossible(File fichier, PartieLocale partieLocale) {
		J.appel(this);

		if(partieLocale != null) {
			
			modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
			afficheur.rafraichirAffichage(modele, vue);
		}
	}
	

}

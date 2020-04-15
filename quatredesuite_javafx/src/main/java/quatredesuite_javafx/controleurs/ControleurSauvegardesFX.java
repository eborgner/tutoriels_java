package quatredesuite_javafx.controleurs;

import java.io.File;
import java.io.IOException;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun.utiles.Json;
import javafx.application.Platform;
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
		
		/*
		new Thread() {
			
			@Override
			public void run() {
				chercherSauvegardes();
			}
		}.start();
		*/
	}

	private void chercherSauvegardes() {
		J.appel(this);
		
		vue.afficherRechercheEnCours();
		
		File home = Systeme.getHome().toFile();
		
		chercherSauvegardes(home);
		
		/*
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				vue.cacherRechercheEnCours();
			}
		});
		
		*/
	}
	
	
	private void chercherSauvegardes(File repertoire) {
		J.appel(this);
		
		for(File fichier : repertoire.listFiles()) {

			if(fichier.isFile() && fichier.getName().endsWith("json")) {
				
				ajouterSauvegardeSiPossible(fichier);
				
			} else if(fichier.isDirectory() && !fichier.getName().startsWith(".")) {
				
				/*
				chercherSauvegardes(fichier);
				*/

				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						J.appel(this);

						chercherSauvegardes(fichier);
					}
				});
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

		/*
		modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
		afficheur.rafraichirAffichage(modele, vue);
		*/

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
				afficheur.rafraichirAffichage(modele, vue);
			}});
	}
	

}

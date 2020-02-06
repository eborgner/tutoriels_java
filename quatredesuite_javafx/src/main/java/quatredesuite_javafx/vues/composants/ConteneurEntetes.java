package quatredesuite_javafx.vues.composants;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.beans.NamedArg;
import javafx.scene.layout.HBox;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciPourEnvoi;

public class ConteneurEntetes extends HBox {
	
	private String texteBouton;
	
	private JouerIciPourEnvoi jouerIciPourEnvoi;
	
	public ConteneurEntetes(@NamedArg("texteBouton") String texteBouton) {
		J.appel(this);
		
		this.texteBouton = texteBouton;
	}

	public void creerEntetes(int largeur) {
		J.appel(this);
		
		for(int i = 0; i < largeur; i++) {
			
			this.getChildren().add(new Entete(texteBouton));
		}
	}

	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}
	
	public void installerCapteursJouerIci() {
		J.appel(this);

		for(int indiceColonne = 0; indiceColonne < this.getChildren().size(); indiceColonne++) {
			
			Entete entete = (Entete) this.getChildren().get(indiceColonne);
			
			entete.installerCapteurJouerIci(indiceColonne, jouerIciPourEnvoi);
		}
	}

	public void verifierCommandesPossibles() {
		J.appel(this);

		for(int indiceColonne = 0; indiceColonne < this.getChildren().size(); indiceColonne++) {
			
			Entete entete = (Entete) this.getChildren().get(indiceColonne);
			
			jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
			entete.setActif(jouerIciPourEnvoi.siCommandePossible());
		}
	}
}

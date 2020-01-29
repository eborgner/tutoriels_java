package quatredesuite_javafx.vues.controles;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.commandes.jouer_ici.JouerIci;
import quatredesuite_client.commandes.jouer_ici.JouerIciPourEnvoi;

public class Entete extends Button {
	
	private int idColonne;
	private JouerIciPourEnvoi jouerIci;

	public Entete(int idColonne) {
		J.appel(this);
		this.idColonne = idColonne;

		this.setText("⇊");
		this.setMaxWidth(Double.MAX_VALUE);

	}

	public void installerListener() {
		J.appel(this);
		
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				jouerIci.envoyerCommande();

			}
		});
		
	}

	public void creerEvenements() {
		J.appel(this);
		
		jouerIci = FabriqueCommande.creerEvenement(JouerIciPourEnvoi.class);
		jouerIci.setIdColonne(idColonne);
	}

	public void rafraichirCommande() {
		J.appel(this);
		
		this.setDisabled(!jouerIci.siCommandePossible());
	}

	public void colorerEntete(Couleur couleur) {
		J.appel(this);
		switch(couleur) {
		
		case ROUGE:
			
			this.getStyleClass().remove(Couleur.JAUNE.name());
			this.getStyleClass().add(Couleur.ROUGE.name());

			break;

		case JAUNE:
			this.getStyleClass().remove(Couleur.ROUGE.name());
			this.getStyleClass().add(Couleur.JAUNE.name());
			break;
		
		
		
		}
	}

}

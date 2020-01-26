package quatredesuite_javafx.vues.controles;

import commun.debogage.J;
import commun_client.evenements.FabriqueEvenement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.evenements.jouer_ici.JouerIci;
import quatredesuite_client.evenements.jouer_ici.JouerIciLance;

public class Entete extends Button {
	
	private int idColonne;
	private JouerIciLance jouerIci;

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

				jouerIci.lancer();

			}
		});
		
	}

	public void creerEvenements() {
		J.appel(this);
		
		jouerIci = FabriqueEvenement.creerEvenement(JouerIciLance.class);
		jouerIci.setIdColonne(idColonne);
	}

	public void rafraichirCommande() {
		J.appel(this);
		
		this.setDisabled(!jouerIci.siLancable());
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

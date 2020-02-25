package maliste_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commandes.nouvel_item.NouvelItem;
import commandes.nouvel_item.NouvelItemPourEnvoi;
import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import maliste.modeles.liste.ItemLectureSeule;
import maliste_client.vues.VuePrincipale;
import maliste_javafx.vues.composants.ConteneurItems;

public class VuePrincipaleFX implements VuePrincipale, Initializable {
	
	@FXML
	private ConteneurItems conteneurItems;
	
	@FXML
	private Button boutonNouvelItem;

	@FXML
	private TextField texteNouvelItem;
	
	private NouvelItemPourEnvoi nouvelItemPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurItems);
		
		DoitEtre.nonNul(boutonNouvelItem);

		DoitEtre.nonNul(texteNouvelItem);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvelItemPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvelItem.class);

	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		boutonNouvelItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				envoyerCommandeNouvelItem();
			}

		});
		
		texteNouvelItem.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);
				
				if(event.getCode() == KeyCode.ENTER) {
					envoyerCommandeNouvelItem();
				}
			}
		});
		
	}

	private void envoyerCommandeNouvelItem() {
		J.appel(this);

		nouvelItemPourEnvoi.setTexte(texteNouvelItem.getText());

		texteNouvelItem.clear();

		nouvelItemPourEnvoi.envoyerCommande();
	}

	@Override
	public void viderListe() {
		J.appel(this);
		
		conteneurItems.vider();
	}

	@Override
	public void ajouterItem(ItemLectureSeule item) {
		J.appel(this);
		
		conteneurItems.ajouterItem(item);
	}
}

package pong_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun.enumerations.Direction;
import commun.modeles.monde2d.Monde2DLectureSeule;
import commun_client.commandes.FabriqueCommande;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import pong.enumerations.Cadran;
import pong_client.commandes.deplacer_palette.DeplacerPalette;
import pong_client.commandes.deplacer_palette.DeplacerPalettePourEnvoi;
import pong_client.commandes.stopper_palette.StopperPalette;
import pong_client.commandes.stopper_palette.StopperPalettePourEnvoi;
import pong_client.vues.VuePartieLocale;
import pong_javafx.vues.composants.TablePong;

@SuppressWarnings("incomplete-switch")
public class VuePartieLocaleFX implements VuePartieLocale, Initializable {
	
	@FXML
	private TablePong tablePong;
	
	private DeplacerPalettePourEnvoi deplacerPalette;
	private StopperPalettePourEnvoi stopperPalette;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(tablePong);
		
		tablePong.initialiser();
		
		tablePong.setFocusTraversable(true);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		tablePong.obtenirCommandesPourEnvoi();
		
		deplacerPalette = FabriqueCommande.obtenirCommandePourEnvoi(DeplacerPalette.class);
		stopperPalette = FabriqueCommande.obtenirCommandePourEnvoi(StopperPalette.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		tablePong.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);
				
				switch(event.getCode()) {
					case UP:
						deplacerPalette.setCadran(Cadran.DROIT);
						deplacerPalette.setDirection(Direction.HAUT);
						deplacerPalette.envoyerCommande();
					break;

					case DOWN:
						deplacerPalette.setCadran(Cadran.DROIT);
						deplacerPalette.setDirection(Direction.BAS);
						deplacerPalette.envoyerCommande();
					break;

					case W:
						deplacerPalette.setCadran(Cadran.GAUCHE);
						deplacerPalette.setDirection(Direction.HAUT);
						deplacerPalette.envoyerCommande();
					break;

					case S:
						deplacerPalette.setCadran(Cadran.GAUCHE);
						deplacerPalette.setDirection(Direction.BAS);
						deplacerPalette.envoyerCommande();
					break;
				}
			}
		});
		
		tablePong.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);

				switch(event.getCode()) {
					case UP:
					case DOWN:
						stopperPalette.setCadran(Cadran.DROIT);
						stopperPalette.envoyerCommande();
					break;

					case W:
					case S:
						stopperPalette.setCadran(Cadran.GAUCHE);
						stopperPalette.envoyerCommande();
					break;
				}
			}
		});
	}


	@Override
	public void viderMonde() {
		J.appel(this);

		tablePong.viderDessin();
	}


	@Override
	public void afficherMonde2D(Monde2DLectureSeule monde2d) {
		J.appel(this);
		
		tablePong.afficherMonde2D(monde2d);
	}

	@Override
	public void afficherFPS(double fps) {
		J.appel(this);

		tablePong.afficherFPS(fps);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

}

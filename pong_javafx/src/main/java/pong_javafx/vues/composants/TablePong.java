package pong_javafx.vues.composants;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.scene.paint.Color;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePong;
import pong_client.commandes.aggrandir_table_pong.AggrandirTablePongPourEnvoi;

public class TablePong extends CanvasAjustable {
	
	private AggrandirTablePongPourEnvoi aggrandirTablePong;

	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		aggrandirTablePong = FabriqueCommande.obtenirCommandePourEnvoi(AggrandirTablePong.class);
	}
	
	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);

		DESSINER_TMP();

		envoyerCommandeAggrandir(ancienneLargeur, nouvelleLargeur, AggrandirTablePong.Direction.LARGEUR);
	}

	private void DESSINER_TMP() {
		pinceau.clearRect(0, 0, getWidth(), getHeight());
		pinceau.fillRect(0, 0, getWidth(), 10);
		pinceau.fillRect(0, 0, 10, getHeight());
		pinceau.fillRect(getWidth()-10, 0, 10, getHeight());
		pinceau.fillRect(0, getHeight()-10, getWidth(), 10);
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		DESSINER_TMP();

		envoyerCommandeAggrandir(ancienneHauteur, nouvelleHauteur, AggrandirTablePong.Direction.HAUTEUR);
	}

	private void envoyerCommandeAggrandir(double ancienneTaille, double nouvelleTaille, AggrandirTablePong.Direction direction) {

		double facteurAggrandissement = calculerFacteurAggrandissement(ancienneTaille, nouvelleTaille);

		aggrandirTablePong.setFacteurAggrandissement(facteurAggrandissement);
		aggrandirTablePong.setDirection(direction);
		aggrandirTablePong.envoyerCommande();
	}

	private double calculerFacteurAggrandissement(double ancienneTaille, double nouvelleTaille) {
		J.appel(this);
		
		return (nouvelleTaille - ancienneTaille) / ancienneTaille;
	}
	

	public void dessinerPalette(double hauteur) {
		J.appel(this);
		
		//pinceau.setFill(Color.BLUE);
		//pinceau.fillRect(0, 0, 10, hauteur);
	}

}
	

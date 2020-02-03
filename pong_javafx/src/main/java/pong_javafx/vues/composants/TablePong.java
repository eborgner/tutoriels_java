package pong_javafx.vues.composants;

import commun.debogage.J;
import commun.enumerations.Dimension;
import commun.modeles.monde2d.Monde2DLectureSeule;
import commun.modeles.monde2d.Objet2DLectureSeule;
import commun_client.commandes.FabriqueCommande;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
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

		envoyerCommandeAggrandir(ancienneLargeur, nouvelleLargeur, Dimension.LARGEUR);
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		envoyerCommandeAggrandir(ancienneHauteur, nouvelleHauteur, Dimension.HAUTEUR);
	}

	private void envoyerCommandeAggrandir(double ancienneTaille, double nouvelleTaille, Dimension direction) {

		double facteurAggrandissement = calculerFacteurAggrandissement(ancienneTaille, nouvelleTaille);

		aggrandirTablePong.setFacteurAggrandissement(facteurAggrandissement);
		aggrandirTablePong.setDimension(direction);
		aggrandirTablePong.envoyerCommande();
	}

	private double calculerFacteurAggrandissement(double ancienneTaille, double nouvelleTaille) {
		J.appel(this);
		
		double facteurAggrandissement = 1;
		

		if(ancienneTaille != 0) {

			facteurAggrandissement =  nouvelleTaille / ancienneTaille;

		}
		
		return facteurAggrandissement;
	}

	public void initialiser() {
		J.appel(this);

		pinceau.setFill(Color.BLUE);
	}
	
	public void viderDessin() {
		J.appel(this);
		
		pinceau.clearRect(0, 0, getWidth(), getHeight());
	}


	public void afficherObjet2D(Objet2DCanvas objet2D) {
		J.appel(this);
		
		switch(objet2D.getForme()) {
		
			case RECTANGLE:
				pinceau.fillRect(objet2D.getCoinHautGaucheXPixels(),
								 objet2D.getCoinHautGaucheYPixels(),
								 objet2D.getLargeurPixels(),
								 objet2D.getHauteurPixels());
				break;
				
			case CERCLE:
				pinceau.fillArc(objet2D.getCoinHautGaucheXPixels(),
								 objet2D.getCoinHautGaucheYPixels(),
								 objet2D.getLargeurPixels(),
								 objet2D.getHauteurPixels(),
								 0,
								 360,
								 ArcType.ROUND);
				break;
		}
	}
	

	public void afficherMonde2D(Monde2DLectureSeule monde2d) {
		J.appel(this);
		
		viderDessin();
		
		double largeurCanvas = getWidth();
		double hauteurCanvas = getHeight();
		
		double conversionMetresPixelsX = largeurCanvas / monde2d.getLageurMetres();
		double conversionMetresPixelsY = hauteurCanvas / monde2d.getHauteurMetres();
		
		for(Objet2DLectureSeule objet2D : monde2d.getObjets2D()) {
			
			Objet2DCanvas objet2DCanvas = new Objet2DCanvas(objet2D, 
															conversionMetresPixelsX,
															conversionMetresPixelsY,
															hauteurCanvas);
			afficherObjet2D(objet2DCanvas);
		}
	}
	
	public void afficherFPS(double fps) {
		J.appel(this);
		
		pinceau.fillText(String.format("%f FPS", fps), getWidth() - 50, 20);
	}

}
	

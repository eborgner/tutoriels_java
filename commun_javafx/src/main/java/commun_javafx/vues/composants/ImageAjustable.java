package commun_javafx.vues.composants;

import java.io.InputStream;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.scene.image.Image;

public abstract class ImageAjustable extends CanvasAjustable {
	
	protected double facteurTaille = 1.0;
	
	protected Image image;
	
	public ImageAjustable(String url) {
		super();
		J.appel(this);
		
		initialiser(url);
	}

	public ImageAjustable(String url, double facteurTaille) {
		super();
		J.appel(this);
		
		this.facteurTaille = facteurTaille;

		initialiser(url);
	}
	
	private void initialiser(String url) {
		J.appel(this);
		
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		DoitEtre.nonNul(streamImage, "Impossible de charger l'image: " + url);
		
		image = new Image(streamImage);
	}

	@Override
	protected void reagirLargeurInitiale(double largeurInitiale) {
		J.appel(this);

		rafraichirDessin();
	}

	@Override
	protected void reagirHauteurInitiale(double hauteurInitiale) {
		J.appel(this);

		rafraichirDessin();
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);

		rafraichirDessin();
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);

		rafraichirDessin();
	}
	
	protected void rafraichirDessin() {
		J.appel(this);
		
		viderDessin();
		dessinerImage();
	}

	protected void viderDessin() {
		J.appel(this);
		
		pinceau.clearRect(0, 0, getWidth(), getHeight());
	}
	
	protected void dessinerImage() {
		J.appel(this);
		
		double facteurLargeur = facteurTaille * getWidth() / image.getWidth();
		double facteurHauteur = facteurTaille * getHeight() / image.getHeight();
		
		double facteurTaille = facteurLargeur;
		if(facteurHauteur < facteurTaille) {

			facteurTaille = facteurHauteur;
		}
		
		double largeur = image.getWidth() * facteurTaille;
		double hauteur = image.getHeight() * facteurTaille;
		
		double coinHautGaucheX = 0 + (getWidth() - largeur) / 2;
		double coinHautGaucheY = 0 + (getHeight() - hauteur) / 2;
		
		pinceau.drawImage(image, 
						  coinHautGaucheX, 
						  coinHautGaucheY, 
						  largeur,
						  hauteur);
	}
}

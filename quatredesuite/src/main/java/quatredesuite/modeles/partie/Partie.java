package quatredesuite.modeles.partie;

import commun.debogage.J;
import quatredesuite.enumerations.Couleur;

public class Partie implements PartieLectureSeule {

	private int largeur =  4;
	private int hauteur = 6;
	
	private Couleur couleurCourante = Couleur.ROUGE;

	private Grille grille;
	
	public Partie() {
		J.appel(this);
		
		grille = new Grille();
		grille.initialiser(largeur);
		
	}

	public int getLargeur() {
		J.appel(this);
		return largeur;
	}

	public void setLargeur(int largeur) {
		J.appel(this);
		this.largeur = largeur;
	}

	public int getHauteur() {
		J.appel(this);
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		J.appel(this);
		this.hauteur = hauteur;
	}

	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		this.couleurCourante = couleurCourante;
	}

	public GrilleLectureSeule getGrille() {
		J.appel(this);
		return (GrilleLectureSeule) grille;
	}

	public void setGrille(Grille grille) {
		J.appel(this);
		this.grille = grille;
	}

}

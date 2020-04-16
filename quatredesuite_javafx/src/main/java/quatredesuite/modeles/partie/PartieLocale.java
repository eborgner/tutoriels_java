package quatredesuite.modeles.partie;

import java.util.Random;

import commun.debogage.J;
import commun.modeles.Modele;
import quatredesuite.enumerations.Couleur;

public class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {

	private int largeur;
	private int hauteur;
	
	private Couleur couleurCourante;

	private Grille grille;
	
	public PartieLocale() {
		J.appel(this);
		
	}

	public void initialiser() {
		J.appel(this);

		largeur =  3 + (new Random().nextInt(5));
		hauteur = 4 + (new Random().nextInt(8));
	
		couleurCourante = Couleur.ROUGE;

		grille = new Grille();
		grille.initialiser(largeur);
	}

	public boolean siInitialisee() {
		J.appel(this);

		return largeur > 0 && 
			   hauteur > 0 && 
			   couleurCourante != null &&
			   grille != null;
	}
	
    public void jouerIci(int indiceColonne){
        J.appel(this);

        effectuerCoup(indiceColonne);
    }

    public void effectuerCoup(int indiceColonne) {
        J.appel(this);
        
        grille.ajouterJeton(indiceColonne, couleurCourante);

        prochaineCouleur();
    }

    private void prochaineCouleur() {
        J.appel(this);

        switch(couleurCourante) {

        case ROUGE:
        	couleurCourante = Couleur.JAUNE;
            break;
        case JAUNE:
        	couleurCourante = Couleur.ROUGE;
            break;
        }
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

	public boolean siPossibleJouerIci(int indiceColonne) {
		J.appel(this);
		
		boolean siPossibleJouerIci = false;
		
		if(indiceColonne < grille.getColonnes().size()) {

			siPossibleJouerIci = grille.getColonnes().get(indiceColonne).getJetons().size() < hauteur;
		}
		
		return siPossibleJouerIci;
	}



}

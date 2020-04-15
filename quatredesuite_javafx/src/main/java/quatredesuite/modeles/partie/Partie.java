package quatredesuite.modeles.partie;


import commun.debogage.J;
import commun.modeles.Modele;
import quatredesuite.Constantes;
import quatredesuite.enumerations.Couleur;

public class      Partie<PLS extends PartieLectureSeule> 
       extends    Modele<PLS>
       implements PartieLectureSeule {

	protected int largeur =  Constantes.LARGEUR_GRILLE_PAR_DEFAUT;
	protected int hauteur = Constantes.HAUTEUR_GRILLE_PAR_DEFAUT;
	
	protected Couleur couleurCourante = Couleur.ROUGE;

	protected Grille grille;
	
	public Partie() {
		J.appel(this);
		
		grille = new Grille();
		grille.initialiser(largeur);
	}

	public boolean siBienFormee() {
		J.appel(this);
		
		return largeur > 0 && hauteur > 0 && couleurCourante != null && grille != null;
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
}

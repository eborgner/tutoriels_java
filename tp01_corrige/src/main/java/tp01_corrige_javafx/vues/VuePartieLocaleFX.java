package tp01_corrige_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import tp01_corrige.enumerations.Couleur;
import tp01_corrige_client.vues.VuePartieLocale;
import tp01_corrige_javafx.vues.composants.ConteneurEntetes;
import tp01_corrige_javafx.vues.composants.ConteneurGrille;
import javafx.fxml.Initializable;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {

    @FXML
    private Text nomJoueurUn, nomJoueurDeux;
    
    @FXML
    private ConteneurEntetes conteneurEntetes;

    @FXML
    private ConteneurGrille conteneurGrille;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
	} 

    @Override
    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);
        
        conteneurEntetes.creerEntetes(largeur);
        
        conteneurGrille.creerGrille(largeur, hauteur);

    }

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		conteneurEntetes.obtenirJouerIciPourEnvoi();
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		conteneurEntetes.installerCapteursJouerIci();
	}

	@Override
	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		conteneurGrille.afficherJeton(indiceColonne, indiceRangee, couleur);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
		conteneurEntetes.verifierCommandesPossibles();
	}

	@Override
	public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);
	}
}

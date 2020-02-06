package quatredesuite_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import commun_client.commandes.RecepteurCommande;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import quatredesuite.enumerations.Couleur;
import quatredesuite_client.commandes.vider_grille.ViderGrille;
import quatredesuite_client.commandes.vider_grille.ViderGrilleRecue;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_javafx.vues.composants.ConteneurEntetes;
import quatredesuite_javafx.vues.composants.ConteneurGrille;
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
		
		FabriqueCommande.installerRecepteur(ViderGrille.class, new RecepteurCommande<ViderGrilleRecue>() {
			@Override
			public void executerCommande(ViderGrilleRecue commande) {
				J.appel(this);
				
				commande.notifierCommandeTraitee();
			}
		});
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
}

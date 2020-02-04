package quatredesuite_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import quatredesuite_client.vues.VuePartieLocale;
import quatredesuite_javafx.vues.composants.ConteneurEntetes;
import quatredesuite_javafx.vues.composants.ConteneurGrille;
import javafx.fxml.Initializable;

public class VuePartieLocaleFX implements VuePartieLocale, Initializable {

    @FXML
    Text nomJoueurUn, nomJoueurDeux;
    
    @FXML
    ConteneurEntetes conteneurEntetes;

    @FXML
    ConteneurGrille conteneurGrille;

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
}

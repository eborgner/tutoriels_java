package quatredesuite_javafx.vues.composants;

import java.util.ArrayList;
import java.util.List;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ConteneurEntetes extends HBox {
    
    private String texteBouton;
    
    public ConteneurEntetes(@NamedArg("texteBouton") String texteBouton) {
        J.appel(this);
        
        this.texteBouton = texteBouton;
    }

    public void creerEntetes(int largeur) {
        J.appel(this);
        
        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
            
            this.getChildren().add(new Entete(indiceColonne, texteBouton));
        }
    }

    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(Entete entete : entetes()) {
            
            entete.obtenirJouerIciPourEnvoi();
        }
    }

    public void verifierCommandesPossibles() {
        J.appel(this);

        for(Entete entete : entetes()) {
            
            entete.verifierCommandePossible();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(Entete entete : entetes()) {
            
            entete.installerCapteurJouerIci();
        }
    }
    
    private List<Entete> entetes(){
        J.appel(this);
        
        List<Entete> entetes = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
            entetes.add((Entete) enfant);
        }

        return entetes;
    }
}

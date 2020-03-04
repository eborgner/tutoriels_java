package commun_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogueModal {
	
	private static Stage fenetrePrincipale;
	private static Stage fenetreModale;
	
	public static void enregistreFenetrePrincipale(Stage fenetrePrincipale) {
		J.appel(DialogueModal.class);
		
		DialogueModal.fenetrePrincipale = fenetrePrincipale;
        fenetreModale = new Stage();
        fenetreModale.initOwner(fenetrePrincipale);
        fenetreModale.initModality(Modality.APPLICATION_MODAL);
	}

	public static void ouvrirDialogueModal() {
		J.appel(DialogueModal.class);
		
        fenetreModale.showAndWait();
	}
	
	public static void fermerDialogueModal() {
		J.appel(DialogueModal.class);
		
		fenetreModale.close();
	}

	public static void enregistrerScene(Scene sceneParametres) {
		J.appel(DialogueModal.class);

		DoitEtre.nonNul(fenetrePrincipale);

        fenetreModale.setScene(sceneParametres);
	}
}

package commun_javafx;

import commun.debogage.J;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogueModal {
	
	private static Stage fenetrePrincipale;
	
	public static void enregistreFenetrePrincipale(Stage fenetrePrincipale) {
		J.appel(DialogueModal.class);
		
		DialogueModal.fenetrePrincipale = fenetrePrincipale;
	}

	public static Stage ouvrirDialogueModal(Scene scene) {
		J.appel(DialogueModal.class);

        Stage fenetreModale = new Stage();
        fenetreModale.initOwner(fenetrePrincipale);
        fenetreModale.initModality(Modality.APPLICATION_MODAL);
        fenetreModale.setScene(scene);
        
        Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				fenetreModale.showAndWait();
			}
		});
        
        return fenetreModale;
	}
}

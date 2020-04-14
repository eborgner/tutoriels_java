package commun_javafx;

import java.io.File;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
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
		
		DoitEtre.nonNul(fenetrePrincipale);

        Stage fenetreModale = new Stage();
        fenetreModale.setScene(scene);
        fenetreModale.initOwner(fenetrePrincipale);
        fenetreModale.initModality(Modality.APPLICATION_MODAL);
        
        Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				J.appel(this);

				fenetreModale.showAndWait();
			}
		});
        
        return fenetreModale;
	}

	public static File ouvrirDialogueFichiers() {
		J.appel(DialogueModal.class);
		
	     FileChooser fileChooser = new FileChooser();
         File fichierChoisi = fileChooser.showSaveDialog(fenetrePrincipale);
         
         return fichierChoisi;
	}
}

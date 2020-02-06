package commun_javafx;

import commun.debogage.J;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogueModal {
	
	private static Stage fenetrePrincipale;
	
	public static void enregistreFenetrePrincipale(Stage fenetrePrincipale) {
		J.appel(DialogueModal.class);
		
		DialogueModal.fenetrePrincipale = fenetrePrincipale;
	}
	
	public static void ouvrirDialogueModal(Scene scene) {
		J.appel(DialogueModal.class);
		
	}
}

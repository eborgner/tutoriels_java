package quatredesuite_client.vues;

import commun_client.mvc.Vue;
import quatredesuite.modeles.sauvegardes.UneSauvegardeLectureSeule;

public interface VueSauvegardes extends Vue {
	
	void viderLesSauvegardes();
	void ajouterSauvegarde(UneSauvegardeLectureSeule laSauvegarde);
	
	void cacherRechercheEnCours();
}

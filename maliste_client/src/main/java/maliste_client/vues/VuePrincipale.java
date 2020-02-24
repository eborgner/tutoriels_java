package maliste_client.vues;

import commun_client.mvc.Vue;
import maliste.modeles.liste.ItemLectureSeule;

public interface VuePrincipale extends Vue {
	
	void viderListe();
	void ajouterItem(ItemLectureSeule item);

}

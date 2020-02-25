package maliste_client.afficheurs;

import commun_client.mvc.Afficheur;

import commun.debogage.J;
import maliste_client.vues.VuePrincipale;
import maliste.modeles.liste.ItemLectureSeule;
import maliste.modeles.liste.ListeLectureSeule;

public abstract class AfficheurPrincipal<V extends VuePrincipale> 
                extends Afficheur<ListeLectureSeule, V> {

	@Override
	public void initialiserAffichage(ListeLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		afficherListe(modeleLectureSeule, vue);
	}


	@Override
	public void rafraichirAffichage(ListeLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		vue.viderListe();
		afficherListe(modeleLectureSeule, vue);
	}

	private void afficherListe(ListeLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		for(ItemLectureSeule item : modeleLectureSeule.getItems()) {
			vue.ajouterItem(item);
		}
	}


}

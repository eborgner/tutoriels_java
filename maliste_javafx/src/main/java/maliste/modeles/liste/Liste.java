package maliste.modeles.liste;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import commun.debogage.J;
import commun.modeles.Modele;

public class Liste extends Modele<ListeLectureSeule> implements ListeLectureSeule {
	
	Map<Integer, Item> items = new LinkedHashMap<>();
	
	public Liste() {
		super();
		J.appel(this);
		
		ajouterItem("un test");
		ajouterItem("un autre test");
		ajouterItem("répéter:");
		ajouterItem("un test");
	}
	
	public void ajouterItem(String texte) {
		J.appel(this);
		
		Item item = new Item(texte);
		
		items.put(item.getId(), item);
	}
	
	public void retirerItem(int id) {
		J.appel(this);
		
		items.remove(id);
	}

	@Override
	public List<ItemLectureSeule> getItems() {
		J.appel(this);
		
		List<ItemLectureSeule> listeItems = new ArrayList<>();
		
		for(Item item : items.values()) {
			
			listeItems.add((ItemLectureSeule) item);
		}
		
		return listeItems;
	}
}

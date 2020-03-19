package maliste.modeles.liste;

import commun.debogage.J;
import commun.utiles.Hash;

public class Item implements ItemLectureSeule {
	
	private String id;
	private String texte;
	
	public Item(String texte) {
		J.appel(this);
		
		this.texte = texte;
		this.id = Hash.hash(texte + System.currentTimeMillis());
	}
	
	@Override
	public String getId() {
		J.appel(this);
		
		return id;
	}

	@Override
	public String getTexte() {
		J.appel(this);
		
		return texte;
	}
}

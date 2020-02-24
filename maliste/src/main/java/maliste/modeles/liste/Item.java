package maliste.modeles.liste;

import commun.debogage.J;

public class Item implements ItemLectureSeule {
	
	private static int prochainId = 0;

	private int id;
	private String texte;
	
	public Item(String texte) {
		J.appel(this);
		
		this.id = prochainId++;
		this.texte = texte;
	}
	
	@Override
	public int getId() {
		J.appel(this);
		
		return id;
	}

	@Override
	public String getTexte() {
		J.appel(this);
		
		return texte;
	}
}

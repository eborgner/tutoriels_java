package quatredesuite.modeles.sauvegardes;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.modeles.Modele;

public class Sauvegardes 
       extends Modele<SauvegardesLectureSeule>
	   implements SauvegardesLectureSeule {
	
	
	private List<UneSauvegarde> lesSauvegardes = new ArrayList<>();
	
	@Override
	public List<UneSauvegardeLectureSeule> getLesSauvegardes() {
		J.appel(this);
		
		List<UneSauvegardeLectureSeule> lesSauvegardesLectureSeule = new ArrayList<>();
		
		for(UneSauvegarde uneSauvegarde : lesSauvegardes) {
			
			lesSauvegardesLectureSeule.add(uneSauvegarde);
		}
		
		
		return lesSauvegardesLectureSeule;
	}
	
	public void ajouterSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		UneSauvegarde uneSauvegarde = new UneSauvegarde(cheminDansHome);

		lesSauvegardes.add(uneSauvegarde);
	}
	
	
	

}

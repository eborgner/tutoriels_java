package quatredesuite.modeles.sauvegardes;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;
import commun.modeles.Modele;

public class Sauvegardes 
       extends Modele<SauvegardesLectureSeule>
	   implements SauvegardesLectureSeule {
	
	
	private List<UneSauvegarde> lesSauvegardes = new ArrayList<>();
	
	public Sauvegardes() {
		super();
		J.appel(this);
		
		lesSauvegardes.add(new UneSauvegarde("~/test/test/test.json"));
		lesSauvegardes.add(new UneSauvegarde("~/pouet/pouet/pouet.json"));
		lesSauvegardes.add(new UneSauvegarde("~/test/test/test.json"));
		lesSauvegardes.add(new UneSauvegarde("~/test/test/test.json"));
		lesSauvegardes.add(new UneSauvegarde("~/test/test/test.json"));
		lesSauvegardes.add(new UneSauvegarde("~/pouet/pouet/pouet.json"));
		lesSauvegardes.add(new UneSauvegarde("~/pouet/pouet/pouet.json"));
		lesSauvegardes.add(new UneSauvegarde("~/pouet/pouet/pouet.json"));
	}

	@Override
	public List<UneSauvegardeLectureSeule> getLesSauvegardes() {
		J.appel(this);
		
		List<UneSauvegardeLectureSeule> lesSauvegardesLectureSeule = new ArrayList<>();
		
		for(UneSauvegarde uneSauvegarde : lesSauvegardes) {
			
			lesSauvegardesLectureSeule.add(uneSauvegarde);
		}
		
		
		return lesSauvegardesLectureSeule;
	}
	
	
	

}

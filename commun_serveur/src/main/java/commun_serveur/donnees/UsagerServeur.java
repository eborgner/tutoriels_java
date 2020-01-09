package commun_serveur.donnees;

import org.dizitart.no2.Document;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.filters.Filters;

import commun.debogage.J;
import commun.donnees.Usager;

public abstract class UsagerServeur {

	public static void enregistrerDans(NitriteCollection collection, Usager usager) {
		J.appel(UsagerServeur.class);

		// FIXME: faire par introspection dans Donnees ou Modele
		Document doc = Document.createDocument("nomUsager", usager.getNomUsager());
		doc.put("prenom", usager.getPrenom());
		doc.put("nom", usager.getNom());
		doc.put("hashMotDePasse", usager.getHashMotDePasse());
		
		collection.insert(doc);

	}

	public static boolean siDejaEnregistreDans(NitriteCollection collection, Usager usager) {
		J.appel(UsagerServeur.class);

		boolean siDejaEnregistre = false;
		
		if(collection.find(Filters.eq("nomUsager", usager.getNomUsager())).size() != 0) {

			siDejaEnregistre = true;

		}
		
		return siDejaEnregistre;
	}

	public static boolean siConnexionPossible(NitriteCollection collection, Usager usager) {
		J.appel(UsagerServeur.class);
		
		boolean siConnexionPossible = false;
		
		for(Document docUsager : collection.find(Filters.eq("nomUsager", usager.getNomUsager()))){
			
			String hashMotDePasse = usager.getHashMotDePasse();

			// FIXME: constante pur hashMotDePasse ou alors par introspection
			if(hashMotDePasse.equals(docUsager.get("hashMotDePasse"))) {
				siConnexionPossible = true;
				break;
			}
		}

		return siConnexionPossible;
	}

}

package quatredesuite.modeles;

import commun.debogage.J;
import commun.donnees.Usager;
import commun.mvc.Modele;

public class ModeleEnregistrement extends Modele {
	
	protected Usager usager = new Usager();
	
	public void setNomUsager(String nomUsager) {
		J.appel(this);
		this.usager.setNomUsager(nomUsager);
	}
	
	public void setPrenom(String prenom) {
		J.appel(this);
		this.usager.setPrenom(prenom);
	}
	
	public void setNom(String nom) {
		J.appel(this);
		this.usager.setNom(nom);
	}
	
	public void setHashMotDePasse(String hashMotDePasse) {
		J.appel(this);
		this.usager.setHashMotDePasse(hashMotDePasse);
	}
}

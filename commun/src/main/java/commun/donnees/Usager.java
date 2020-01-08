package commun.donnees;

import commun.debogage.J;

public class Usager {

	protected String nomUsager;
	protected String prenom;
	protected String nom;
	protected String hashMotDePasse;

	public String getNomUsager() {
		J.appel(this);
		return nomUsager;
	}

	public String getPrenom() {
		J.appel(this);
		return prenom;
	}

	public String getNom() {
		J.appel(this);
		return nom;
	}

	public String getHashMotDePasse() {
		J.appel(this);
		return hashMotDePasse;
	}

	public void setNomUsager(String nomUsager) {
		J.appel(this);
		this.nomUsager = nomUsager;
	}

	public void setPrenom(String prenom) {
		J.appel(this);
		this.prenom = prenom;
	}

	public void setNom(String nom) {
		J.appel(this);
		this.nom = nom;
	}

	public void setHashMotDePasse(String hashMotDePasse) {
		J.appel(this);
		this.hashMotDePasse = hashMotDePasse;
	}
}

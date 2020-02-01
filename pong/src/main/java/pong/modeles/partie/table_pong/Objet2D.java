package pong.modeles.partie.table_pong;

public abstract class Objet2D {
	
	protected double centreXMetres = 0;
	protected double centreYMetres = 50;
	protected double largeurMetres = 10;
	protected double hauteurMetres = 100;

	protected double vitesseMetreSecondes = 1;
	protected double angleDegres = 90;

	public abstract void reagirAuTempsQuiPasse(double secondesEcoulees);

}

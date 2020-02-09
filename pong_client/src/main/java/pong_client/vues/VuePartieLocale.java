package pong_client.vues;

import commun_client.mvc.Vue;

public interface VuePartieLocale extends Vue {
	
	double getLargeurPixels();
	double getHauteurPixels();
	
	public void viderMonde();
	void afficherObjet2D(Objet2DCanvas objet2d);
	public void afficherFPS(double fps);

}

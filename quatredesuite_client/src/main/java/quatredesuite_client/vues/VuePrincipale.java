package quatredesuite_client.vues;

import commun_client.mvc.Vue;

public interface VuePrincipale extends Vue {
	
	VuePartieLocale creerVuePartieLocale();
	void detruireVuePartieLocale();

}

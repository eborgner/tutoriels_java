package tp01_pages_client.controleurs;

import commun_client.mvc.controleurs.ControleurVue;
import tp01_pages_client.vues.VueAccueil;
import tp01_pages_client.vues.VuePages;

public abstract class ControleurPages<V extends VuePages> extends ControleurVue<V> {}

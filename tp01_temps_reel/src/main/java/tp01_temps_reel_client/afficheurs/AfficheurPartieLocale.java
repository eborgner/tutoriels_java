package tp01_temps_reel_client.afficheurs;


import commun.debogage.J;
import commun.modeles.Modele;
import commun_client.mvc.Afficheur;
import tp01_temps_reel.modeles.partie_locale.PartieLocaleLectureSeule;
import tp01_temps_reel_client.vues.VuePartieLocale;

public abstract class AfficheurPartieLocale<V extends VuePartieLocale> 

                            extends Afficheur<PartieLocaleLectureSeule, 
                                              V> {

    @Override
    public void initialiserAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
        J.appel(this);
        
        vue.afficherNombreCoups(partieLectureSeule.getNombreCoups());
    }

    @Override
    public void rafraichirAffichage(PartieLocaleLectureSeule partieLectureSeule, VuePartieLocale vue) {
        J.appel(this);

        vue.afficherNombreCoups(partieLectureSeule.getNombreCoups());
    }
}

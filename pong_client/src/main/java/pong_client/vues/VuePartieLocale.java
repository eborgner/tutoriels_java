package pong_client.vues;

import commun_client.mvc.Vue;
import pong.modeles.partie.PaletteLectureSeule;

public interface VuePartieLocale extends Vue {
	
	public void viderDessin();
	public void dessinerPalette(PaletteLectureSeule palette);

}

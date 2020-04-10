package quatredesuite.messages.transmettre_coup;

import commun.debogage.J;
import commun.messages.Message;

public class TransmettreCoup extends Message<TransmettreCoupPourEnvoi, TransmettreCoupRecu>

					         implements TransmettreCoupPourEnvoi, TransmettreCoupRecu {
	
	private int indiceColonne;

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}

}

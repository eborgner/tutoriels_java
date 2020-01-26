package commun_client.evenements;

public interface CapteurEvenement<EC extends EvenementCapte> {

	void capterEvenement(EC commande);
	boolean siCaptable(EC commande);

}

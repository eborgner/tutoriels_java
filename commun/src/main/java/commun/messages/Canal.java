package commun.messages;

public interface Canal {

	boolean siOuvert();
	void envoyer(Message message);
}
package commun.messages;

@SuppressWarnings("rawtypes")
public interface Canal {

	boolean siOuvert();
	void envoyer(String chaineMessage);
	void envoyer(Message message);

}
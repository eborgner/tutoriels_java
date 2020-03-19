package commun.messages;

@SuppressWarnings("rawtypes")
public interface Canal {

	long getId();
	boolean siOuvert();
	void envoyer(String chaineMessage);
	void envoyer(Message message);

}
package commun.messages;

@SuppressWarnings("rawtypes")
public interface MessageRecu {

	void relayerMessage();
	<M extends Message> M obtenirReponsePourEnvoi(Class<M> classeMessage);

}

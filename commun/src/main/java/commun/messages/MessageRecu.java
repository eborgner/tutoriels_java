package commun.messages;

import org.java_websocket.WebSocket;

public interface MessageRecu<M extends Message> { 

    void reagirMessageRecuSur(WebSocket webSocket, M message);

}

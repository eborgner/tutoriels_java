package maliste.messages.detruire_item;

import commun.debogage.J;
import commun.messages.Message;

public class DetruireItem extends Message<DetruireItemPourEnvoi, 
										  DetruireItemRecu> 
						  implements DetruireItemPourEnvoi,
						             DetruireItemRecu {
	
	private String id;
	
	@Override
	public String getId() {
		J.appel(this);
		
		return id;
	}
	
	@Override
	public void setId(String id) {
		J.appel(this);
		
		this.id = id;
	}

}

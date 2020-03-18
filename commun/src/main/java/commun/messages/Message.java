// Copyright (C) (2019) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of aquiletour
//
// aquiletour is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// aquiletour is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

package commun.messages;

import java.util.Set;
import commun.debogage.J;

public abstract class Message<ME extends MessagePourEnvoi, 
							  MR extends MessageRecu> 
				implements MessagePourEnvoi, 
				           MessageRecu {
	
	protected transient Canal canalPourEnvoi;
	protected transient Set<Canal> canauxPourRelais;
    protected String _Type;

    Message() {
        J.appel(this);
        this._Type = this.getClass().getSimpleName();
    }
    
    void setConnexionPourEnvoi(Canal canalPourEnvoi){
    	J.appel(this);
    	
    	this.canalPourEnvoi = canalPourEnvoi;
    }
    
    void setConnexionsPourRelai(Set<Canal> canauxPourRelais) {
    	J.appel(this);
    	
    	this.canauxPourRelais = canauxPourRelais;
    }
    
    @Override
    public void envoyerMessage() {
    	J.appel(this);
    	
    	if(canalPourEnvoi != null && canalPourEnvoi.siOuvert()) {

			canalPourEnvoi.envoyer(this);
    	}
    }
    
    @Override
    public void relayerMessage() {
    	J.appel(this);

    	for(Canal canal : canauxPourRelais) {
    		if(canal.siOuvert()) {
    			
    			canal.envoyer(this);
    		}
    	}
    }
}

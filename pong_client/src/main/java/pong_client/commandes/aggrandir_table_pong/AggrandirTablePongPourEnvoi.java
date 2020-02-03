package pong_client.commandes.aggrandir_table_pong;

import commun.enumerations.Dimension;
import commun_client.commandes.CommandePourEnvoi;

public interface AggrandirTablePongPourEnvoi extends CommandePourEnvoi {
	
	void setDimension(Dimension dimension);
	void setFacteurAggrandissement(double facteurAggrandissement);

}

package pong_client.commandes.aggrandir_table_pong;

import commun_client.commandes.CommandePourEnvoi;

public interface AggrandirTablePongPourEnvoi extends CommandePourEnvoi {
	
	void setDirection(AggrandirTablePong.Direction direction);
	void setFacteurAggrandissement(double facteurAggrandissement);

}

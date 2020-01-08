package commun;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import commun.debogage.J;


public class Conf {

	public static String nomServeur;
	
	public static void initialiser(String nomFichier) {
		
		String cheminConf = "/conf/" + nomFichier + ".properties";
		
		InputStream streamConf = Conf.class.getResourceAsStream(cheminConf);
		
		Properties conf = new Properties();
		
		try {

			conf.load(streamConf);

		} catch (Exception e) {
			
			J.valeurs("[FATAL] impossible de charger " + cheminConf);
			System.exit(0);

		}
		
		for(Field field : Conf.class.getFields()) {

			String key = field.getName();
			
			if(conf.containsKey(key)) {
				
				try {

					field.set(null, conf.get(key));

				} catch (IllegalArgumentException | IllegalAccessException e) {

					J.valeurs("[FATAL] impossible de stoquer " + key);
					System.exit(0);
				}
				
			}else {

				J.valeurs("[FATAL] aucune valeur pour " + key);
				System.exit(0);
				
			}

		}
		
	}
}

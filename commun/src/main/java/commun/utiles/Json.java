package commun.utiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import commun.debogage.J;

public class Json {
    
    private static final Gson gson = new GsonBuilder().create();
    private static final Gson gsonPourFichier = new GsonBuilder().setPrettyPrinting().create();
    
    public static <T> T aPartirJson(String chaineJson, Class<T> classeT) {
        J.appel(Json.class);

        return gson.fromJson(chaineJson, classeT);
    }

    public static String versJson(Object objet) {
        J.appel(Json.class);

        return gson.toJson(objet);
    }

	public static void sauvegarder(File fichierSortie, Object objet) throws IOException {
		J.appel(Json.class);
		
		OutputStream sortieStream = new FileOutputStream(fichierSortie);
		
		sortieStream.write(gsonPourFichier.toJson(objet).getBytes());
		sortieStream.close();
	}

}

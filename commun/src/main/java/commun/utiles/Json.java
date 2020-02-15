package commun.utiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import commun.debogage.J;

public class Json {
    
    private static final Gson gson = new GsonBuilder().create();
    
    public static <T> T aPartirJson(String chaineJson, Class<T> classeT) {
        J.appel(Json.class);

        return gson.fromJson(chaineJson, classeT);
    }

    public static String versJson(Object objet) {
        J.appel(Json.class);

        return gson.toJson(objet);
    }

}

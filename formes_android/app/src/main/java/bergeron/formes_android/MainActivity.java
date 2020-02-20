package bergeron.formes_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.InputStream;

import bergeron.formes_android.dessin_android.DessinAndroid;
import commun_android.Initialisateur;
import formes.EntrepotFormes;

public class MainActivity extends AppCompatActivity {

    static{

        Initialisateur.initialiser();

    }

    private final String CHEMIN_FICHIER_ENTREE = "/entrees/02.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream streamFormes = MainActivity.class.getResourceAsStream(CHEMIN_FICHIER_ENTREE);

        EntrepotFormes.chargerFormes(streamFormes);

        DessinAndroid dessinAndroid = findViewById(R.id.dessin_android);

        EntrepotFormes.afficherformes(dessinAndroid);

    }
}

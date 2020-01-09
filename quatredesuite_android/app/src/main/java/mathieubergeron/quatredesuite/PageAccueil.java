package mathieubergeron.quatredesuite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import commun.debogage.J;
import commun.systeme.Systeme;
import commun_android.Initialisateur;

public class PageAccueil extends AppCompatActivity {

    static{

        Initialisateur.initialiser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        J.appel(this);

        setContentView(R.layout.page_accueil);

        Systeme.quitter();
    }
}

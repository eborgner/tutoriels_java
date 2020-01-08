package mathieubergeron.quatredesuite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import commun.debogage.J;

public class PageAccueil extends AppCompatActivity {

    static{

        J.initialiser(J.Contexte.ANDROID);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        J.appel(this);

        setContentView(R.layout.page_accueil);
    }
}

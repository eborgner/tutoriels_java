package mathieubergeron.pong_android.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import commun.debogage.J;
import commun_android.Initialisateur;
import commun_android.vues.composants.CanvasAjustable;
import mathieubergeron.pong_android.R;

public class ActivitePartie extends AppCompatActivity {

	static{

		Initialisateur.initialiser();
	}

	private CanvasAjustable canvasAjustable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_partie);

		canvasAjustable = findViewById(R.id.canvas);

		canvasAjustable.invalidate();
	}

	@Override
	protected void onResume() {
		super.onResume();

		canvasAjustable.invalidate();

		Button boutonGaucheHaut = findViewById(R.id.bouton_gauche_haut);

		boutonGaucheHaut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				J.appel(this);

				canvasAjustable.invalidate();

			}
		});
	}
}

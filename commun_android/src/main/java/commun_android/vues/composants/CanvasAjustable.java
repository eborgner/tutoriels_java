package commun_android.vues.composants;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import commun.debogage.J;

public abstract class CanvasAjustable extends View {

	private Paint couleurBase;

	protected int largeurInitiale;
	protected int hauteurInitiale;

	protected int largeur;
	protected int hauteur;

	public class Objet2DCanvas {


	}

	private List<Objet2DCanvas> objets2D = new ArrayList<>();

	public CanvasAjustable(Context context) {
		super(context);
		J.appel(this);
	}

	public CanvasAjustable(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		J.appel(this);
	}

	public CanvasAjustable(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		J.appel(this);
	}

	public CanvasAjustable(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		J.appel(this);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		J.appel(this);

		initialiser();
	}

	private void initialiser(){
		J.appel(this);

		couleurBase = new Paint(Paint.ANTI_ALIAS_FLAG);
		couleurBase.setStyle(Paint.Style.FILL);
		couleurBase.setColor(Color.BLUE);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		J.appel(this);

		if(oldw == 0){

			largeurInitiale = w;

		}else{

			// TODO: lancer commande AggrandirMonde
		}

		if(oldh == 0){

			hauteurInitiale = h;

		}else{

			// TODO: lancer commande AggrandirMonde

		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		J.appel(this);

		// sera rappeler après chaque invalidate() (au plus 60FPS à ce qu'il paraît)

		canvas.drawCircle(largeurInitiale - 50,hauteurInitiale -50, 50f, couleurBase);

	}

	public void ajouterObjet2D(Objet2DCanvas objet2D){
		J.appel(this);

		objets2D.add(objet2D);
	}

	public void viderCanvas(){
		J.appel(this);

		objets2D.clear();
	}
}

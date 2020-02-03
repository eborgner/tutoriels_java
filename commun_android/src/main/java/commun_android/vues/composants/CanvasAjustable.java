package commun_android.vues.composants;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


import commun.debogage.J;

public abstract class CanvasAjustable extends View {

	protected int largeur;
	protected int hauteur;


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
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		J.appel(this);

		this.largeur = w;
		this.hauteur = h;

		reagirNouvelleTaille(w,h,oldw, oldh);
	}

	protected abstract void reagirNouvelleTaille(int largeur, int hauteur, int ancienneLargeur, int ancienneHauteur);
}

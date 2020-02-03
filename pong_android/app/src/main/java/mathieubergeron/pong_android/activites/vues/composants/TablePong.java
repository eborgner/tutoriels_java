package mathieubergeron.pong_android.activites.vues.composants;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import commun.debogage.J;
import commun_android.vues.composants.CanvasAjustable;

public class TablePong extends CanvasAjustable {

	public TablePong(Context context) {
		super(context);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		J.appel(this);
	}

	public TablePong(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		J.appel(this);
	}


}

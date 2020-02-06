package commun;

import commun.debogage.J;

public final class Fabrique {
	
	private Fabrique() {
		J.appel(this);
	}
	
	public static <C> C nouvelleInstance(Class<C> classe) {
		J.appel(Fabrique.class);
		
		C instance = null;

		try {
			
			instance = (C) classe.newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException | ClassCastException e) {
			
			J.valeurs("[FATAL] impossible d'instancier la classe: " + classe.getSimpleName());
			e.printStackTrace();
		}
		
		return instance;
	}

}

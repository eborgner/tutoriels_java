package quatredesuite_javafx;

public class Constantes {
	
	public enum Vue{
		PRINCIPALE, PARAMETRES;
	}

	public static final Vue VUE_COURANTE = Vue.PRINCIPALE; 

	public static final String CHEMIN_PRINCIPAL_FXML = "/fxml/principal.xml";
	public static final String CHEMIN_PRINCIPAL_CSS = "/css/principal.css";
	public static final String CHEMIN_PRINCIPAL_CHAINES = "chaines.Principal";

	public static final String CHEMIN_PARAMETRES_FXML = "/fxml/parametres.xml";
	public static final String CHEMIN_PARAMETRES_CSS = "/css/parametres.css";

}

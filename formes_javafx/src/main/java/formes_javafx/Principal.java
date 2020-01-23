package formes_javafx;

import java.io.InputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Principal extends Application {
    
    private static final String CHEMIN_FICHIER_ENTREE = "/entrees/01.txt";

    private static final int HAUTEUR = 400;
    private static final int LARGEUR = 600;

    private GraphicsContext dessin;

    public static void main(String[] args) {

        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Scene scene = creerScene();
        
        lireFichierEtAfficherFormes();

        stage.setScene(scene);
        stage.show();
    }

    private void lireFichierEtAfficherFormes() {

        InputStream streamEntree = Principal.class.getResourceAsStream(CHEMIN_FICHIER_ENTREE);

        lireFichierEtAfficherFormes(streamEntree);
    }

    private Scene creerScene() {

        Canvas canvas = new Canvas(LARGEUR, HAUTEUR);
        dessin = canvas.getGraphicsContext2D();
        
        Pane pane = new Pane();
        pane.getChildren().add(canvas);

        Scene scene = new Scene(pane, LARGEUR, HAUTEUR);

        return scene;
    }

    private void lireFichierEtAfficherFormes(InputStream streamEntree) {

        Scanner scan = new Scanner(streamEntree);
        
        while(scan.hasNext()) {
            lireEtAfficherUneForme(scan);
        }

        scan.close();
    }

    private void lireEtAfficherUneForme(Scanner scan) {

        String typeForme = scan.next();

        Color couleur = Color.valueOf(scan.next());
        dessin.setFill(couleur);
        
        int centreX = scan.nextInt();
        int centreY = scan.nextInt();

        lireFichierEtAfficherUneForme(scan, typeForme, centreX, centreY);
    }

    private void lireFichierEtAfficherUneForme(Scanner scan, 
                                               String typeForme, 
                                               int centreX,
                                               int centreY) {

        switch(typeForme) {

            case "Cercle":
                lireEtAfficherUnCercle(scan, centreX, centreY);
                break;

            case "Carre":
                lireEtAfficherUnCarre(scan, centreX, centreY);
                break;

            case "Rectangle":
                lireEtAfficherUnRectangle(scan, centreX, centreY);
                break;
        }
    }

    private void lireEtAfficherUnRectangle(Scanner scan, int centreX, int centreY) {

        int largeur = scan.nextInt();
        int hauteur = scan.nextInt();

        dessin.fillRect(centreX-largeur/2, 
                        centreY-hauteur/2, 
                        largeur, 
                        hauteur);
    }

    private void lireEtAfficherUnCarre(Scanner scan, int centreX, int centreY) {

        int taille = scan.nextInt();

        dessin.fillRect(centreX-taille/2, 
                        centreY-taille/2, 
                        taille, 
                        taille);
    }

    private void lireEtAfficherUnCercle(Scanner scan, int centreX, int centreY) {

        int rayon = scan.nextInt();

        dessin.fillArc(centreX-rayon, 
                       centreY-rayon, 
                       rayon, 
                       rayon, 
                       0, 
                       360, 
                       ArcType.ROUND);
    }
}

package atm;

import atm.models.ATM;
import atm.services.PersistenceService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file = new File("data/data.bin");
        PersistenceService<ATM> persistenceService = new PersistenceService<>();
        ATM atm = persistenceService.load(ATM.class, file);

        System.out.println(atm.a);
        atm.a = "ccc";

        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        persistenceService.save(atm, file);
    }
}

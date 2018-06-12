package atm;

import atm.controllers.BaseController;
import atm.controllers.EnterCardController;
import atm.models.ATM;
import atm.services.PersistenceService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private Stage primaryStage;
    private ATM atm;

    /**
     * Entry point
     *
     * @param args The application startup arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is called by JavaFX when the app is initialized
     *
     * @param primaryStage The primary stage object (The main window)
     * @throws Exception Any exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        File file = new File("data/data.bin");
        PersistenceService<ATM> persistenceService = new PersistenceService<>();
        atm = persistenceService.load(ATM.class, file);

        Seeder seeder = new Seeder();
        seeder.seed(atm);

        System.out.println(atm.users);

        primaryStage.setTitle("Hello World");

        this.changeScene(new EnterCardController(this));

        primaryStage.show();

        persistenceService.save(atm, file);
    }

    /**
     * @return The ATM root Model
     */
    public ATM getAtm() {
        return atm;
    }

    /**
     * Changes the actual scene of the stage. (The content of the window)
     *
     * @param controller The controller to use as the active controller
     */
    public void changeScene(BaseController controller) {
        URL url = getClass().getResource("/resources/views/" + controller.getViewName() + ".fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(controller);
        try {
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace(); // TODO: replace with a custom error view
        }

    }
}

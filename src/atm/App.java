package atm;

import atm.models.ATM;
import atm.services.PersistenceService;
import javafx.stage.Stage;

import java.io.File;


public class App {

    private ATM atm;
    private static final int STAGE_WIDTH = 800;
    private static final int STAGE_HEIGHT = 600;
    private Router router;

    public App(Stage primaryStage) throws Exception {
        this.router = new Router(primaryStage, this);
        Thread.setDefaultUncaughtExceptionHandler(this::handleError);


        File file = new File("data/data.bin");
        PersistenceService<ATM> persistenceService = new PersistenceService<>();
        atm = persistenceService.load(ATM.class, file);

        Seeder seeder = new Seeder();
        seeder.seed(atm);

        System.out.println(atm.users);

        primaryStage.setWidth(STAGE_WIDTH);
        primaryStage.setHeight(STAGE_HEIGHT);
        primaryStage.setTitle("Banco FASTA");


        this.router.gotoEnterCard();

        primaryStage.show();

        persistenceService.save(atm, file);
    }

    private void handleError(Thread thread, Throwable throwable) {
        ExceptionHandler handler = new ExceptionHandler(router);
        handler.handle(throwable);
    }

    /**
     * @return The ATM root Model
     */
    public ATM getAtm() {
        return atm;
    }


    /**
     * @return The application router instance
     */
    public Router getRouter() {
        return router;
    }
}

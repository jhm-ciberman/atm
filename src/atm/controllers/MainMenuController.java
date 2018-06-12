package atm.controllers;

import atm.App;

public class MainMenuController extends BaseController {

    MainMenuController(App app) {
        super(app);
    }

    @Override
    public String getViewName() {
        return "main_menu";
    }


}
